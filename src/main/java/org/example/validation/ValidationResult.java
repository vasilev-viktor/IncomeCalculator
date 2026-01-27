package org.example.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult {

    private final Map<String, List<String>> errors = new HashMap<>();

    // Метод для добавления ошибки
    public void addError(String fieldName, String massage) {
        // computeIfAbsent: если для fieldName еще нет списка ошибок - создаем новый ArrayList
        // если есть - возвращаем существующий список
        // затем добавляем сообщение об ошибке в этот список
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
