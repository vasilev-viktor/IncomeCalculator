package org.example.validation;

public interface FieldValidator {
    ValidationResult validate(String field, Object value);
}
