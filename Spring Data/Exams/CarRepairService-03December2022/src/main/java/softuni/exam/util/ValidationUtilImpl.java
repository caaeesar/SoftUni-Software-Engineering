package softuni.exam.util;

import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidationUtilImpl() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        // the set of constraints is empty -> valid entity
        return validator.validate(entity).isEmpty();
    }
}
