package com.example.tangjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
public class TangJavaApplication {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(TangJavaApplication.class.getName());
    }

    public static void main(String[] args) throws Exception {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(TangJavaApplication.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        Connection connection = DriverManager.getConnection(properties.getProperty("spring.datasource.url"), properties);
        log.info("Database connection test: " + connection.getCatalog());

        readData(connection);

        log.info("Closing database connection");
        connection.close();
    }
    private static void readData(Connection connection) throws SQLException {
        log.info("Read data");
        PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM consumer;");
        ResultSet resultSet = readStatement.executeQuery();
        if (!resultSet.next()) {
            log.info("There is no data in the database!");
            return;
        }
        Consumer consumer = new Consumer();
        consumer.setId(resultSet.getLong("id"));
        consumer.setName(resultSet.getString("description"));
        log.info("Data read from the database: " + consumer.toString());
    }
}
