package org.example.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult {

    private final Map<String, List<String>> errors = new HashMap<>();

    // Метод для добавления ошибки
    public void addError(String fieldName, String massage) {
        errors.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(massage);
    }

    // isEmpty() возвращает true, если Map пустой (нет ошибок)
    public boolean isValid() {
        return errors.isEmpty();
    }

    // Метод для получения всех ошибок
    public Map<String, List<String>> getErrors() {
        return errors;
    }
}
