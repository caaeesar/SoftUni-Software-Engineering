package com.example.resellerapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String first;
    private String second;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        // get property of object with reflection
        Object first = beanWrapper.getPropertyValue(this.first);
        Object second = beanWrapper.getPropertyValue(this.second);

        boolean isValid =  Objects.equals(first, second);

        if (!isValid) {
            context
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(this.second)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return  isValid;
    }
}
