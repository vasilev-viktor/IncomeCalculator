package org.example.validation;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {

    private static final Map<String, FieldValidator> validators = new HashMap<>();

    static {
        validators.put("mandatory", (field, value) -> {
            ValidationResult resultMandatory = new ValidationResult();
            if (value == null || value.toString().trim().isEmpty()) {
                resultMandatory.addError(field, "Поле обязательно для заполнения");
            }
            return resultMandatory;
        });
        validators.put("number", (field, value) -> {
            ValidationResult resultNumber = new ValidationResult();
            if (value != null && !value.toString().trim().isEmpty()) {
                String strValue = value.toString().trim();
                if (!strValue.matches("\\d+")) {
                    resultNumber.addError(field, "Можно ввести только целые, положительные числа");
                } else if (strValue.length() > 1 && strValue.startsWith("0")) {
                    resultNumber.addError(field, "Число не может начинаться с нуля");
                }
            }
            return resultNumber;
        });
        validators.put("max and min", (field, value) -> {
            ValidationResult resultMinMax = new ValidationResult();
            int valueInt = (Integer) value;
            if (valueInt <= 0 || valueInt >= 10000000) {
                resultMinMax.addError(field, "Можно ввести в диапазоне от 0 до 10000000");
            }
            return resultMinMax;
        });
    }
}
