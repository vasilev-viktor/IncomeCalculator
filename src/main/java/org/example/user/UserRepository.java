package org.example.user;


import org.example.Utils.ValidationUtils;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<Users> usersList = new ArrayList<>();

    private ValidationResult validateUser(int salaryOriginal, String userName) {
        ValidationResult resultUser = new ValidationResult();
        ValidationUtils.validateProcessingErrors(resultUser, "mandatory", "userName", userName);
        ValidationUtils.validateProcessingErrors(resultUser, "mandatory", "salaryOriginal", salaryOriginal);
        ValidationUtils.validateProcessingErrors(resultUser, "number", "salaryOriginal", salaryOriginal);
        ValidationUtils.validateProcessingErrors(resultUser, "int max and min", "salaryOriginal", salaryOriginal);
        ValidationUtils.validateProcessingErrors(resultUser, "string max and min", "userName", userName);
        ValidationUtils.validateProcessingErrors(resultUser, "allowed characters", "userName", userName);
        return resultUser;
    }

    public void addUsersOriginal(int salaryOriginal, String userName) {
        ValidationResult validationResultUser = validateUser(salaryOriginal, userName);
        if (!validationResultUser.isValid()) {
            throw new IllegalArgumentException("Validation failed: " + validationResultUser.getErrors());
        }
        usersList.add(new Users(salaryOriginal, userName)); // Добавляю в список
    }

    public void correctionUser(String oldName, String nameNewUser, int newUser) {
        for (Users users : usersList) {
            if (users.getUserName().equals(oldName)) {
                users.setUserName(nameNewUser);
                users.setSalaryOriginal(newUser);
            }
        }
        System.out.println("Старое имя пользователя: " + oldName + ", Новое имя пользователя: " + nameNewUser + ", Новая зарплата: " + newUser);
    }

    public void deleteUser(String nameNewUser) {
        usersList.removeIf(users -> users.getUserName().equals(nameNewUser));
        System.out.println("Удаленный пользователь: " + nameNewUser);
    }

    public List<Users> getUsersOriginalList() {
        return List.of(usersList.toArray(new Users[0]));
    }
}
