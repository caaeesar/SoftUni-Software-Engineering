package ReflectionAndAnnotations.exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String END_COMMAND = "HARVEST";
    public static final String PRIVATE = "private";
    public static final String PROTECTED = "protected";
    public static final String PUBLIC = "public";
    public static final String ALL = "all";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> aClass = RichSoilLand.class;
        Field[] fields = aClass.getDeclaredFields();

        String input = scanner.nextLine();
        while (!END_COMMAND.equals(input)) {

            switch (input) {
                case PRIVATE:
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(f -> System.out.printf("private %s %s\n", f.getType().getSimpleName(), f.getName()));
                    break;
                case PROTECTED:
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(f -> System.out.printf("protected %s %s\n", f.getType().getSimpleName(), f.getName()));
                    break;
                case PUBLIC:
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(f -> System.out.printf("public %s %s\n", f.getType().getSimpleName(), f.getName()));
                    break;
                case ALL:
                    Arrays.stream(fields)
                            .forEach(f -> System.out.printf("%s %s %s\n", getAccessModifierName(f), f.getType().getSimpleName(), f.getName()));
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static String getAccessModifierName(Field field) {
        if (Modifier.isPublic(field.getModifiers())) {
            return "public";
        } else if (Modifier.isPrivate(field.getModifiers())) {
            return "private";
        } else if (Modifier.isProtected(field.getModifiers())) {
            return "protected";
        }
        return "";
    }


}
