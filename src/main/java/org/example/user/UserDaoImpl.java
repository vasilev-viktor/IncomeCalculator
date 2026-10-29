package org.example.user;

import org.example.dataBase.DatabaseConnection;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    //билдер попробовать
    private static String INSERT = """
            INSERT INTO users_income (user_name, user_origin_salary)
            VALUES (?,?)
            """;

    @Override
    public Users save(Users users) {
        try (Connection conn = DatabaseConnection.connection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, users.getUserName());
            preparedStatement.setInt(2, users.getSalaryOriginal());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int generatedId = resultSet.getInt(1);
                    return new Users(generatedId, users.getUserName(), users.getSalaryOriginal());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
