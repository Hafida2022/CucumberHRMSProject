package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void createConnection() {

        try {

            connection = DriverManager.getConnection(
                    ConfigReader.getProperty("dbUrl"),
                    ConfigReader.getProperty("dbUsername"),
                    ConfigReader.getProperty("dbPassword")
            );

            statement = connection.createStatement();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {

        try {

            resultSet = statement.executeQuery(query);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return resultSet;
    }

    public static void closeConnection() {

        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}