package org.example.user;

public class Users {

    private String userName;
    private int salaryOriginal;


    public Users(int salaryOriginal, String userName) {
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

    @Override
    public String toString() {
        return "Зарплата: " + salaryOriginal;
    }
}
