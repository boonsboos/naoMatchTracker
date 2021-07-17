package me.mrsherobrine.naomatchtracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.regex.Pattern;

/*
    this program is made by https://github.com/mrsherobrine
    please read the licensing information in the readme
    thanks for using my tool
 */

public class DatabaseMagic {
    public static void databaseMagicInsert(String input) throws Exception {

        if (!Pattern.matches("[0-9]\\w:[0-9]\\w",input)) {
            System.out.println(input + " errored!");
            throw new Exception("Bad format!");
        } else {
            int inputMinutes = Integer.parseInt(input.substring(0,2)) * 60;
            int inputSeconds = Integer.parseInt(input.substring(3,5));
            int inputTimeInSeconds = inputSeconds + inputMinutes;
            String a = (System.getProperty("user.dir").replace("\\", "\\\\"));
            String dbLocation = "jdbc:sqlite:" + a + "\\\\trackerfiles\\\\timespent.db";
            try (Connection conn = DriverManager.getConnection(dbLocation);
                 PreparedStatement insertQuery = conn.prepareStatement("INSERT INTO time (timespent) VALUES (?);")) {
                insertQuery.setInt(1, inputTimeInSeconds);
                insertQuery.execute();
            } catch (SQLException ea) {
                ea.printStackTrace();
            }
        }
    }


    public static String databaseMagicAverage() throws Exception {
        long totalTime = 0;
        long totalEntries = 0;
        String a = (System.getProperty("user.dir").replace("\\", "\\\\"));
        String dbLocation = "jdbc:sqlite:" + a + "\\\\trackerfiles\\\\timespent.db";
        try (Connection conn = DriverManager.getConnection(dbLocation);
             PreparedStatement gatherTotalTime = conn.prepareStatement("SELECT SUM(timespent) AS time FROM time");
             PreparedStatement gatherTotalEntries = conn.prepareStatement("SELECT COUNT(*) AS entries FROM time")) {
            ResultSet totalTimeRS = gatherTotalTime.executeQuery();
            ResultSet totalEntriesRS = gatherTotalEntries.executeQuery();
            totalTime = totalTimeRS.getLong("time");
            totalEntries = totalEntriesRS.getLong("entries");
        } catch (SQLException ea) {
            ea.printStackTrace();
        }
        return Long.toString((totalTime / totalEntries)/60);
    }

    public static String databaseMagicTotal() throws Exception {
        double totalTime = 0;
        String a = (System.getProperty("user.dir").replace("\\", "\\\\"));
        String dbLocation = "jdbc:sqlite:" + a + "\\\\trackerfiles\\\\timespent.db";
        try (Connection conn = DriverManager.getConnection(dbLocation);
             PreparedStatement gatherTotalTime = conn.prepareStatement("SELECT SUM(timespent) AS time FROM time")) {
            ResultSet totalTimeRS = gatherTotalTime.executeQuery();
            totalTime = totalTimeRS.getLong("time");
        } catch (SQLException ea) {
            ea.printStackTrace();
        }
        BigDecimal bd = new BigDecimal(Double.toString(totalTime/3600));
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.toString();
    }

}
