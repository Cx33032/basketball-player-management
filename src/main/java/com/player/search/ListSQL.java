package com.player.search;

import com.player.util.*;

import java.sql.*;
import java.util.*;

public class ListSQL {
    public static List<String> readName(){
        String sqlCmd = "select * from players_list";
        System.out.println(sqlCmd);

        List<String> names = new ArrayList<String>();
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                String appended = rs.getString("first_name")+ " " + rs.getString("last_name");
                names.add(appended);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
        return names;
    }

    public static List<String> readEmail(){
        String sqlCmd = "select * from players_list";
        System.out.println(sqlCmd);

        List<String> emails = new ArrayList<String>();
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                String appended = rs.getString("email");
                emails.add(appended);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
        return emails;
    }

    public static List<String> readPhoneNumber(){
        String sqlCmd = "select * from players_list";
        System.out.println(sqlCmd);

        List<String> phoNums = new ArrayList<String>();
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                String appended = rs.getString("phone_number");
                phoNums.add(appended);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
        return phoNums;
    }

    public static List<String> readPosition(){
        String sqlCmd = "select * from players_list";
        System.out.println(sqlCmd);

        List<String> positions = new ArrayList<String>();
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                String appended = rs.getString("position");
                positions.add(appended);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
        return positions;
    }

    public static List<List<String>> listSearchResult(){
        List<List<String>> results = new ArrayList<List<String>>();
        String sqlCmd = "select * from `query_list`";
        
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                String rank = String.format("%d", rs.getInt("rank"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String nameStr = firstName + " " + lastName;
                String age = String.format("%d", rs.getShort("age"));
                // String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String position = rs.getString("position");

                List<String> appendList = new ArrayList<String>();
                appendList.add(rank);
                appendList.add(nameStr);
                appendList.add(age);
                appendList.add(email);
                appendList.add(position);
                results.add(appendList);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }

        return results;
    }
}
