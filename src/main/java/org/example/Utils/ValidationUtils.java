package org.example.Utils;

import org.example.validation.FieldValidator;
import org.example.validation.ValidationResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class ValidationUtils {

    private static final Map<String, FieldValidator> validators = new HashMap<>();

    private ValidationUtils(){
       throw new AssertionError("You are trying to create an instance of the final class");
    }

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
        validators.put("int max and min", (field, value) -> {
            ValidationResult intResultMinMax = new ValidationResult();
            int valueInt = (Integer) value;
            if (valueInt < 0 || valueInt > 100000) {
                intResultMinMax.addError(field, "Можно ввести в диапазоне от 0 до 10000000");
            }
            return intResultMinMax;
        });

        validators.put("string max and min", (field, value) -> {
            ValidationResult stringResultMinMax = new ValidationResult();
            String valueString = (String) value;
            if (value != null && !value.toString().trim().isEmpty()) {
                if (valueString.length() <= 3 || valueString.length() >= 20) {
                    stringResultMinMax.addError(field, "Можно ввести не меньше 2 и не больше 20 символов");
                }
            }
            return stringResultMinMax;
        });
        validators.put("allowed characters", (field, value) -> {
            ValidationResult allowedCharacters = new ValidationResult();
            String regex = "^[a-zA-Zа-яА-Я\\s-]+$";
            String allowedValue = (String) value;
            if (!Pattern.matches(regex, allowedValue)) {
                allowedCharacters.addError(field, "Можно ввести только буквы, пробелы и дефис");
            }
            return allowedCharacters;
        });
    }

    public static void validateProcessingErrors(ValidationResult nameResult, String key, String field, Object name) {
        FieldValidator nameValidator = ValidationUtils.getValidator(key);
        ValidationResult validationResult = nameValidator.validate(field, name);
        if (!validationResult.isValid()) {
            for (Map.Entry<String, List<String>> entry : validationResult.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    nameResult.addError(entry.getKey(), error);
                }
            }
        }
    }

    public static FieldValidator getValidator(String key) {
        return validators.get(key);
    }
}