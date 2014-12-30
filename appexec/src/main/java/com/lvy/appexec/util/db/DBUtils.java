package com.lvy.appexec.util.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by livvy on 14-9-2.
 */
public class DBUtils {
    private DBUtils() {
        throw new AssertionError("no instance for you !");
    }

    public static void closeQuietly(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //ignore
            }
        }
    }

    public static void closeQuietly(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                //ignore
            }
        }
    }

    public static void closeQuietly(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                //ignore
            }
        }
    }


}
