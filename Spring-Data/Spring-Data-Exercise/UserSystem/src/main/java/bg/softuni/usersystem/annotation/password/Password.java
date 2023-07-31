package bg.softuni.usersystem.annotation.password;

import jakarta.validation.Constraint;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    int minLength() default 6;

    int maxLength() default 50;

    boolean containsUpperCase() default false;

    boolean containsLowerCase() default false;

    boolean containsDigit() default false;

    boolean containsSpecialSymbols() default false;
}
