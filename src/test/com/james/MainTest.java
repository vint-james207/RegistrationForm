package com.james;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jamesyburr on 6/15/16.
 */
public class MainTest {
    public Connection startConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Main.createTables(conn);
        return conn;
    }

    @Test
    public void testUser() throws SQLException {
        Connection conn = startConnection();
        User alex = new User(1, "Alex", "101 address", "me@me.com");
        Main.insertUser(conn, alex);
        ArrayList<User> user = Main.selectUsers(conn);
        conn.close();
        assertTrue(user.size() == 1);
    }

    @Test
    public void testUpdateUser() throws SQLException {
        Connection conn = startConnection();
        User james = new User(1, "James", "45 address", "me@me.com");
        Main.insertUser(conn, james);
        User temp = new User(1, "Jamesy", "101 address", "you@you.com");
        Main.updateUser(conn, temp.id, temp);
        ArrayList<User> users = Main.selectUsers(conn);
        james = users.get(0);
        conn.close();
        assertTrue(james.username.equals("Jamesy"));
        assertTrue(james.address.equals("101 address"));
        assertTrue(james.email.equals("you@you.com"));
    }

    @Test
    public void testDeleteUser() throws SQLException {
        Connection conn = startConnection();
        User james = new User(1, "James", "1 address", "me@me.com");
        Main.insertUser(conn, james);
        Main.deleteUser(conn, james.id);
        ArrayList<User> users = Main.selectUsers(conn);
        conn.close();
        assertTrue(users.size() == 0);
    }
}