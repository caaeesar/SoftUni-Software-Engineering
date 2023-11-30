package bg.softuni.usersystem.annotation.email;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static bg.softuni.usersystem.message.ErrorMessage.*;

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    private final Pattern EMAIL_PATTERN = Pattern.compile("\\b(?<user>[A-Za-z0-9]+[\\.\\-_]?[A-Za-z0-9]*)@(?<host>[A-Za-z0-9]+-?[a-z]*(\\.[a-z]+)+)\\b");
    private int minUserLength;
    private int maxUserLength;
    private int minHostLength;
    private int maxHostLength;

    @Override
    public void initialize(Email email) {
        this.minUserLength = email.minUserLength();
        this.maxUserLength = email.maxUserLength();
        this.minHostLength = email.minHostLength();
        this.maxHostLength = email.maxHostLength();
    }

    @Override
    public boolean isValid(String currentEmail, ConstraintValidatorContext context) {
        //fixme don't print error messages
        int userLength = currentEmail.split("@")[0].length();

        if (userLength < this.minUserLength) {
            throw new IllegalArgumentException(SHORT_USER);
        }

        if (userLength > this.maxUserLength) {
            throw new IllegalArgumentException(LONG_USER);
        }

        int hostLength = currentEmail.split("@")[1].length();
        if (hostLength < this.minHostLength) {
            throw new IllegalArgumentException(SHORT_HOST);
        }

        if (hostLength > this.maxHostLength) {
            throw new IllegalArgumentException(LONG_HOST);
        }

        if (!EMAIL_PATTERN.matcher(currentEmail).find()) {
            throw new IllegalArgumentException(INVALID_EMAIL_FORMAT);
        }

        return true;
    }
}
