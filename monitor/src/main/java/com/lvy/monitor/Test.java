package com.lvy.monitor;

import java.sql.*;

/**
 * Created by livvy on 14-8-1.
 */
public class Test {
    public static class Main{
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Integer integer = Integer.valueOf(1);
            Class.forName("org.postgresql.Driver");
            System.out.printf("jjajsj%n");

            String url = "jdbc:postgresql://localhost:5432/lvydb";
            Connection connection = DriverManager.getConnection(url, "postgres", "livvy");


            DatabaseMetaData metaData = connection.getMetaData();

            ResultSet catalogs = metaData.getCatalogs();
            while (catalogs.next()) {
                System.out.println(catalogs.getString("TABLE_CAT"));
            }

            ResultSet schemas = metaData.getSchemas();
            while (schemas.next()) {
                System.out.println(schemas.getString("TABLE_SCHEM"));
            }

            ResultSet tableTypes = metaData.getTableTypes();

            while (tableTypes.next()) {
                System.out.println(tableTypes.getString("TABLE_TYPE"));
            }
            tableTypes.close();


            ResultSet tables = metaData.getTables(null, null, null, new String[]{"SYSTEM TABLE"});
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }
            tables.close();
            schemas.close();
            catalogs.close();
            connection.close();


        }
    }
}
