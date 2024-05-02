package com.player.player;

import com.player.util.*;

import java.sql.*;

public class Register {
    private static void exsistedRank(int rank){
        String sqlCmd = String.format("select * from `players_list` where `rank`=%d", rank);
        System.out.println(sqlCmd);
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;

        try{
            rs = ps.executeQuery(sqlCmd);
            boolean isEmpty = rs.next();
            System.out.println("Lookup result: " + isEmpty);
            if(isEmpty){
                sqlCmd = String.format("update players_list set `rank` = `rank` + 1 where `rank` >= %d", rank);
                ps.executeUpdate(sqlCmd);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
    }

    public static void registerPlayers(PlayersData player){
        String sqlCmd = String.format("insert into `players_list` (`rank`, `first_name`, `last_name`, `age`, `phone_number`, `email`, `position`) values (%d, \'%s\', \'%s\', %d, \'%s\', \'%s\', \'%s\')", player.getRank(), player.getFirstName(), player.getLastName(), player.getAge(), player.getPhoneNumber(), player.getEmail(), player.getPosition());
        // SQL Command to insert data

        exsistedRank(player.getRank());

        System.out.println(sqlCmd);
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);

        try{
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            SQLUtil.close(connection, ps, null);
        }
    }
}
