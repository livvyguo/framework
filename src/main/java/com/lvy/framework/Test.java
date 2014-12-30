package com.lvy.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by livvy on 14-5-9.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");

        Statement statement = connection.createStatement();

//        statement.execute("insert into u values (1,'zzz')");
        for(long i = 668733L;i < 10000000L;) {
            //String s = String.format("insert into u values ( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s')",++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID());
            String s = String.format("insert into u values ( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s'),( %d,'%s')",++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID(),++i, UUID.randomUUID());

            statement.execute(s);
        }
        statement.close();
        connection.close();



    }
}
