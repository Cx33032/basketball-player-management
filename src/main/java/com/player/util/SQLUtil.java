package com.player.util;

import java.sql.*;

public class SQLUtil{
    
    public static Connection getConnection() {
        try {
            // MySQL jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String mysqlUrl = "jdbc:mysql://localhost:3306/players?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String mysqlUser = "root";
            String mysqlPassword = "YOUR-SQL-PASSWORD";
            return DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        try {
            // Use Prepare Statement, Prevent the SQL Injection
            return connection.prepareStatement(sql);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
