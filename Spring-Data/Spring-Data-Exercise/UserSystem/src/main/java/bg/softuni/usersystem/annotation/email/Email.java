package bg.softuni.usersystem.annotation.email;

import jakarta.validation.Constraint;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    int minUserLength();

    int maxUserLength() default 50;

    int minHostLength();
    int maxHostLength() default 50;


}
