package com.bridgelabz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {

    private final ArrayBlockingQueue<Connection> pool;

    public ConnectionPool(int size, String url, String user, String password) {
        pool = new ArrayBlockingQueue<>(size);

        try {
            for (int i = 0; i < size; i++) {
                pool.add(DriverManager.getConnection(url, user, password));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating pool", e);
        }
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public void release(Connection conn) {
        pool.offer(conn);
    }
}