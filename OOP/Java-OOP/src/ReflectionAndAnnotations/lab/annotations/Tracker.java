package ReflectionAndAnnotations.lab.annotations;

import java.lang.reflect.Method;

public class Tracker {

    @Author(name = "Melissa")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Method[] allMethods = clazz.getDeclaredMethods();

        for (Method method : allMethods) {
            Author author = method.getAnnotation(Author.class);
            if (author != null) {
                System.out.printf("%s: %s()\n", author.name(), method.getName());
            }
        }
    }

    public static void main(String[] arguments) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}

