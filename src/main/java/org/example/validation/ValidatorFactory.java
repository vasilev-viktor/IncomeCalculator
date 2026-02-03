package org.example.validation;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {

    private static final Map<String, FieldValidator> validators = new HashMap<>();

    static {
        validators.put("mandatory", (field, value) -> {
            ValidationResult result = new ValidationResult();
            if (value == null || value.toString().trim().isEmpty()) {
                result.addError(field, "Поле обязательно для заполнения");
            }
            return result;
        });
    }
}
