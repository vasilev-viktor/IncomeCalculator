package org.example.saving;


import org.example.Utils.ValidationUtils;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public class SavingRepository {

    private final List<Saving> savingList = new ArrayList<>();

    private ValidationResult validateSaving(String nameNewSavings, int newSavings) {
        ValidationResult resultSaving = new ValidationResult();
        ValidationUtils.validateProcessingErrors(resultSaving, "mandatory", "nameNewSavings", nameNewSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "mandatory", "newSavings", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "number", "newSavings", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "int max and min", "newSavings", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "string max and min", "nameNewSavings", nameNewSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "allowed characters", "nameNewSavings", nameNewSavings);
        return resultSaving;
    }

    public void addSaving(String nameNewSavings, int newSavings) {
        ValidationResult validationResultSaving = validateSaving(nameNewSavings, newSavings);
        if (!validationResultSaving.isValid()) {
            throw new IllegalArgumentException("Validation failed: " + validationResultSaving.getErrors());
        }
        savingList.add(new Saving(newSavings, nameNewSavings));
    }

    public void correctionSaving(String oldName, String nameNewSaving, int newSaving) {
        for (Saving saving : savingList) {
            if (saving.getNameNewSavings().equals(oldName)) {
                saving.setNameNewSavings(nameNewSaving);
                saving.setNewSavings(newSaving);
            }
        }
        System.out.println("Старое сбережение: " + oldName + ", Новое имя сбережения: " + nameNewSaving + ", Новая сумма сбережения: " + newSaving);
    }

    public void deleteSaving(String nameNewSaving) {
        savingList.removeIf(saving -> saving.getNameNewSavings().equals(nameNewSaving));
        System.out.println("Удаленное сбережение: " + nameNewSaving);
    }

    public List<Saving> getSavingList() {
        return List.of(savingList.toArray(new Saving[0]));

    }
}


