package org.example.user;


import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<Users> usersList = new ArrayList<>();

    public void addUsersOriginal(int salaryOriginal, String userName) {
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
        for (Users users : usersList) {
            if (users.getUserName().equals(nameNewUser)) {
                usersList.remove(users);
            }
        }
        System.out.println("Удаленный пользователь: " + nameNewUser);
    }

    public List<Users> getUsersOriginalList() {
        return List.of(usersList.toArray(new Users[0]));
    }
}
