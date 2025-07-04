package org.example.Saving;

public class Saving {

    double newSavings;
    String nameNewSavings;

    public Saving(double newSavings, String nameNewSavings) {
        this.newSavings = newSavings;
        this.nameNewSavings = nameNewSavings;
    }

    public double getNewSavings() {
        return newSavings;
    }

    public void setNewSavings(double newSavings) {
        this.newSavings = newSavings;
    }

    public String getNameNewSavings() {
        return nameNewSavings;
    }

    public void setNameNewSavings(String nameNewSavings) {
        this.nameNewSavings = nameNewSavings;
    }

    @Override
    public String toString() {
        return "\nСумма: " + newSavings +
                "\n Название: " + nameNewSavings;
    }
}
