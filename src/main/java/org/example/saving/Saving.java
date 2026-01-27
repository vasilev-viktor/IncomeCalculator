package org.example.saving;

public class Saving {

    int newSavings;
    String nameNewSavings;

    public Saving(int newSavings, String nameNewSavings) {
        this.newSavings = newSavings;
        this.nameNewSavings = nameNewSavings;
    }

    public void setNewSavings(int newSavings) {
        this.newSavings = newSavings;
    }

    public void setNameNewSavings(String nameNewSavings) {
        this.nameNewSavings = nameNewSavings;
    }

    public int getNewSavings() {
        return newSavings;
    }

    public String getNameNewSavings() {
        return nameNewSavings;
    }



    @Override
    public String toString() {
        return "\n% " + newSavings + " " + nameNewSavings;
    }
}
