package bg.softuni.productsshop.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violations(E entity) {
        return this.validator.validate(entity);
    }

    @Override
    public <E> boolean isValid(E entity) {
        // the set of constraints is empty -> valid entity
        return this.validator.validate(entity).isEmpty();
    }
}
