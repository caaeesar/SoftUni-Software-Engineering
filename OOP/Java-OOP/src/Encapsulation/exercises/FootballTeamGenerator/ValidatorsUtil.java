package Encapsulation.exercises.FootballTeamGenerator;

public class ValidatorsUtil {

    public static void validateName(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
}
