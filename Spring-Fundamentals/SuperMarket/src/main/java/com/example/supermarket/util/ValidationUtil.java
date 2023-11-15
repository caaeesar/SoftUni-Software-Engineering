package com.example.supermarket.util;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    public <E> boolean isValid(E entity);

    public <E> Set<ConstraintViolation<Object>> constraint(E entity);
}
