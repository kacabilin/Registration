package com.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * Created by ADI on 5/25/2017.
 */
public class PostgreSQLJDBC {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "khevin");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO ExerciseDBase (ID,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) "
                    + "VALUES (1, 'Paul', 'Paul', 'California', 'lolonya' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ExerciseDBase (ID,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) "
                    + "VALUES (2, 'Allen', 'Walker', 'Texas', 'lolokita' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ExerciseDBase (ID,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) "
                    + "VALUES (3, 'Teddy', 'Bear', 'Norway', 'lolomo' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ExerciseDBase (ID,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) "
                    + "VALUES (4, 'Mark', 'Manuelit', 'Rich-Mond ', 'loloko' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
