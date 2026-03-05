package org.example.saving;

import org.example.Utils.ValidationUtils;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public class SavingRepository {

    private final List<Saving> savingList = new ArrayList<>();

    private ValidationResult validateSaving(String nameNewSavings, int newSavings) {
        ValidationResult resultSaving = new ValidationResult();
        ValidationUtils.validateProcessingErrors(resultSaving, "mandatory", "НАЗВАНИЕ СБЕРЕЖЕНИЯ", nameNewSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "mandatory", "СУММА СБЕРЕЖЕНИЯ", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "number", "СУММА СБЕРЕЖЕНИЯ", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "int max and min", "СУММА СБЕРЕЖЕНИЯ", newSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "string max and min", "НАЗВАНИЕ СБЕРЕЖЕНИЯ", nameNewSavings);
        ValidationUtils.validateProcessingErrors(resultSaving, "allowed characters", "НАЗВАНИЕ СБЕРЕЖЕНИЯ", nameNewSavings);
        return resultSaving;
    }

    public void addSaving(String nameNewSavings, int newSavings) {
        ValidationResult validationResultSaving = validateSaving(nameNewSavings, newSavings);
        if (!validationResultSaving.isValid()) {
            System.out.println("Validation failed: " + validationResultSaving.getErrors());
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


