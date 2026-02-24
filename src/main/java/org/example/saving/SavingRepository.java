package org.example.saving;


import org.example.Utils.ValidationUtils;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;


public class SavingRepository {

    private final List<Saving> savingList = new ArrayList<>();

    public void addSaving(String nameNewSavings, int newSavings) {
        // добавиль валидацию туть, создать в ютилс статичную валидацию и добавить сюда,
        // чтобы проходило через валидацию, выпадала ошибка или проходило дальше, так во всех репозиториях
            savingList.add(new Saving(newSavings, nameNewSavings)); // Добавляю в список
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


