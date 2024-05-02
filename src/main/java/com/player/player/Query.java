package com.player.player;

import com.player.util.*;

import java.sql.*;
import java.io.*;

public class Query {
    // private static File thisFile = new File("");
    // private static File parentFile = new File();
    // private static File queryResult = new File("./query.md");
    // private static PrintWriter pw;

    // private static String getMarkDownOutput(int rank, String firstName, String lastName, int age, String phoneNum, String email, String position){
    //     return
    //     "Player Details|" + firstName + " " + lastName + "\n"
    //     + "---|---" + "\n"
    //     + "Rank|" + rank + numberSufix(rank) + "\n"
    //     + "Age|" + age + "\n"
    //     + "Email|" + email + "\n"
    //     + "Position|" + position+"  \n******************************\n";
    // }

    // private static String numberSufix(int num){
    //     if(num / 10 == 1) return "th"; /*11, 12, and 13 use the th sufix*/
    //     switch(num%10)
    //     {
    //     case 1:
    //         return "st";
    //     case 2:
    //         return "nd";
    //     case 3:
    //         return "rd";
    //     default:
    //         return "th";
    //     }
    // }

    public static boolean searchPlayerByRank(int rank) throws IOException, SQLException{
        String sqlCmd = String.format("select * from `players_list` where `rank`=%d", rank);
        System.out.println(sqlCmd);
        Connection connection = SQLUtil.getConnection();
        PreparedStatement ps = SQLUtil.getPreparedStatement(connection, sqlCmd);
        ResultSet rs = null;
        try{
            rs = ps.executeQuery(sqlCmd);
            boolean isValid = rs.next();
            if(!isValid)
                return isValid;
            else{
                try{
                    String tempSqlCmd = String.format("insert into `query_list` (`rank`, `first_name`, `last_name`, `age`, `phone_number`, `email`, `position`) values (%d, \'%s\', \'%s\', %d, \'%s\', \'%s\', \'%s\')", rs.getInt("rank"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("phone_number"), rs.getString("email"), rs.getString("position"));
                    System.out.println(tempSqlCmd);
                    PreparedStatement psTemp = SQLUtil.getPreparedStatement(connection, tempSqlCmd);

                    psTemp.executeUpdate();
                    SQLUtil.close(psTemp);
                    return true;
                }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
            SQLUtil.close(connection, ps, rs);
        }
    }
}
