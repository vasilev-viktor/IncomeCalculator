package org.example.saving;


import org.example.Utils.ValidationUtils;
import org.example.validation.FieldValidator;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavingRepository {

    private final List<Saving> savingList = new ArrayList<>();

    private ValidationResult validateSaving(String name, int amount){

        ValidationResult resultSaving = new ValidationResult();

        FieldValidator nameValidatorSaving = ValidationUtils.getValidator("mandatory");
        ValidationResult nameResultSaving = nameValidatorSaving.validate("nameNewSavings", name);
        if (!nameResultSaving.isValid()) {
            for (Map.Entry<String, List<String>> entry : nameResultSaving.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    resultSaving.addError(entry.getKey(), error);
                }
            }
        }

        FieldValidator numberValidatorSaving = ValidationUtils.getValidator("number");
        ValidationResult numberResultSaving = numberValidatorSaving.validate("newSavings", String.valueOf(amount));
        if (!numberResultSaving.isValid()) {
            for (Map.Entry<String, List<String>> entry : numberResultSaving.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    resultSaving.addError(entry.getKey(), error);
                }
            }
        }

        FieldValidator minMaxValidator = ValidationUtils.getValidator("int max and min");
        ValidationResult minMaxResultSaving = minMaxValidator.validate("newSavings", amount);
        if (!minMaxResultSaving.isValid()) {
            for (Map.Entry<String, List<String>> entry : minMaxResultSaving.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    resultSaving.addError(entry.getKey(), error);
                }
            }
        }

        FieldValidator allowedCharactersSaving = ValidationUtils.getValidator("allowed characters");
        ValidationResult allowedCharactersResultSaving = allowedCharactersSaving.validate("nameNewSavings", name);
        if (!allowedCharactersResultSaving.isValid()){
            for (Map.Entry<String, List<String>> entry : allowedCharactersResultSaving.getErrors().entrySet()){
                for (String error : entry.getValue()){
                    resultSaving.addError(entry.getKey(), error);
                }
            }
        }

        return resultSaving;
    }

    public void addSaving(String nameNewSavings, int newSavings) {
        ValidationResult validationResult = validateSaving(nameNewSavings, newSavings);
        if (!validationResult.isValid()) {
            // Выводим ошибки
            for (Map.Entry<String, List<String>> entry : validationResult.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    System.out.println("Ошибка валидации: поле " + entry.getKey() + " - " + error);
                }
            }
            return; // Не добавляем, если есть ошибки
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


