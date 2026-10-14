package org.example.dataBase;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.Properties;

import static java.lang.String.format;

public class DatabaseConnection {

    private static Connection connection;

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties");

            if (inputStream == null) {
                System.err.println("application.properties не найден!");
            }
            properties.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            System.err.println("Ошибка загрузки application.properties");
        }
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getUrl() {
        String host = properties.getProperty("db.host");
        String port = properties.getProperty("db.port");
        String name = properties.getProperty("db.usernameDatabase");
        return format("jdbc:postgresql://%s:%s/%s", host, port, name);
    }

    public static String getUsername() {
        return properties.getProperty("db.usernameDatabase");
    }

    public static String getPassword() {
        return properties.getProperty("db.passwordDatabase");
    }

    public static Connection connection(){
        try {
            connection = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.getUrl();
            rowSet.getUsername();
            rowSet.getPassword();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}

