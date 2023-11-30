package bg.softuni.cookingadventure.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDisabledException extends UsernameNotFoundException {

    public UserDisabledException(String username) {
        super("User with username " + username + " is disabled. Please contact support.");
    }
}
