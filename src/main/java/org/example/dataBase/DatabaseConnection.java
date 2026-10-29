package org.example.dataBase;

import org.example.user.Users;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.Properties;

import static java.lang.String.format;

public class DatabaseConnection {
    // рай виф ресурсес
    private static Connection connection;

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")){
            if (inputStream == null) {
                throw new IllegalStateException("database.properties не найден!");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка загрузки database.properties", e);
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
            throw new RuntimeException ("Не удалось подключиться к базе данных: " + getUrl() + " (пользователь БД: " + getUsername() + e);
        }
        return connection;
    }
}

