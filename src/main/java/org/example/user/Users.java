package org.example.user;

public class Users {

    private int id;
    private String userName;
    private int salaryOriginal;

    public Users(int id,String userName, int salaryOriginal) {
        this.id = id;
        this.salaryOriginal = salaryOriginal;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSalaryOriginal() {
        return salaryOriginal;
    }

    public void setSalaryOriginal(int salaryOriginal) {
        this.salaryOriginal = salaryOriginal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Имя: " + userName + "\nЗарплата: " + salaryOriginal;
    }
}
