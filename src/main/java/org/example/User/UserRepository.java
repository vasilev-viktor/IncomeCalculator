package org.example.User;


import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    private final List<Users> usersList = new ArrayList<>();


    public void addUsersOriginal(int salaryOriginal) {
        usersList.add(new Users(salaryOriginal)); // Добавляю в список
    }

    public List<Users> getUsersOriginalList() {
        return List.of(usersList.toArray(new Users[0]));

    }

}
