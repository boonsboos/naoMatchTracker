package me.mrsherobrine.naomatchtracker;

import java.sql.PreparedStatement;
import java.util.regex.Pattern;

/*
    this program is made by github.com/mrsherobrine
    please read the licensing information in the readme
    thanks for using my tool
 */

public class DatabaseMagic {
    public static void databaseMagicInsert(String input) throws Exception {

        if (!Pattern.matches("[0-9]\\w:[0-9]\\w",input)) {
            System.out.println(input + " errored!");
            throw new Exception("Bad format!");
        } else {
            System.out.println(input + " insert from dbm");
            //PreparedStatement insertQuery = prepareStatement("INSERT INTO time(timespent) VALUES ('?')");
        }
    }


    public static String databaseMagicAverage(String input) throws Exception {

        if (!Pattern.matches("[0-9]\\w:[0-9]\\w",input)) {
            System.out.println(input);
            throw new Exception("Bad format!");
        } else {
            System.out.println(input + " avg from dbm");
            //PreparedStatement insertQuery = prepareStatement("INSERT INTO time(timespent) VALUES ('?')");
        }
        return input + " avg";
    }

    public static String databaseMagicTotal(String input) throws Exception {
        if (!Pattern.matches("[0-9]\\w:[0-9]\\w",input)) {
            System.out.println(input);
            throw new Exception("Bad format!");
        } else {
            System.out.println(input + " total from dbm");
            //PreparedStatement insertQuery = prepareStatement("INSERT INTO time(timespent) VALUES ('?')");
        }
        return input + " total";
    }

}
