package bg.softuni.automappingobjectsexercise.util;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {

    // this method check if entity is valid and return all constrain violations if not
   <E> Set<ConstraintViolation<E>> violations (E entity);

   <E> boolean isValid(E entity);

}
