package org.example.Saving;

public class Saving {

    int newSavings;
    String nameNewSavings;

    public Saving(int newSavings, String nameNewSavings) {
        this.newSavings = newSavings;
        this.nameNewSavings = nameNewSavings;
    }

    public int getNewSavings() {
        return newSavings;
    }

    public void setNewSavings(int newSavings) {
        this.newSavings = newSavings;
    }

    public String getNameNewSavings() {
        return nameNewSavings;
    }


    @Override
    public String toString() {
        return "\n% " + newSavings + " " + nameNewSavings;
    }
}
