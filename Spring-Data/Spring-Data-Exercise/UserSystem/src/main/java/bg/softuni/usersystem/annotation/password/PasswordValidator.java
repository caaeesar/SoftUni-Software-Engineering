package bg.softuni.usersystem.annotation.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.regex.Pattern;

import static bg.softuni.usersystem.message.ErrorMessage.*;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final Pattern PATTERN_LOWER = Pattern.compile("[a-z]+");
    private static final Pattern PATTERN_UPPER = Pattern.compile("[A-Z]+");
    private static final Pattern PATTERN_DIGIT = Pattern.compile("[0-9]+");
    private static final Pattern PATTERN_SYMBOLS = Pattern.compile("[!@#$%^&*()_+<>?]+");

    private int minLength;
    private int maxLength;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasDigit;
    private boolean hasSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.hasUpper = password.containsUpperCase();
        this.hasLower = password.containsLowerCase();
        this.hasDigit = password.containsDigit();
        this.hasSpecialSymbol = password.containsSpecialSymbols();
    }

    @Override
    public boolean isValid(String currentPassword, ConstraintValidatorContext context) {
        //fixme don't print error messages
        if (currentPassword.length() < this.minLength) {
            throw new IllegalArgumentException(SHORT_PASS);
        }

        if (currentPassword.length() > this.maxLength) {
            throw new IllegalArgumentException(LONG_PASS);
        }


        if (this.hasLower && !PATTERN_LOWER.matcher(currentPassword).find()) {
            throw new IllegalArgumentException(PASSWORD_MUST_CONTAIN_LOWER_LETTER);
        }

        if (this.hasUpper && !PATTERN_UPPER.matcher(currentPassword).find()) {
            throw new IllegalArgumentException(PASSWORD_MUST_CONTAIN_UPPER_LETTER);
        }

        if (hasDigit && !PATTERN_DIGIT.matcher(currentPassword).find()) {
            throw new IllegalArgumentException(PASSWORD_MUST_CONTAIN_DIGIT);
        }

        if (hasSpecialSymbol && !PATTERN_SYMBOLS.matcher(currentPassword).find()) {
            throw new IllegalArgumentException(PASSWORD_MUST_CONTAIN_SPECIAL_SYMBOL);
        }

        return true;
    }
}
