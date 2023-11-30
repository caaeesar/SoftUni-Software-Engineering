package bg.softuni.productsshop.utils;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    <E> Set<ConstraintViolation<E>> violations (E entity);

    <E> boolean isValid(E entity);
}
