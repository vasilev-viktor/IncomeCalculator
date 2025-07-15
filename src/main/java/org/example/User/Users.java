package org.example.User;

public class Users {

    private int salaryOriginal;


    public Users(int salaryOriginal) {
        this.salaryOriginal = salaryOriginal;
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
