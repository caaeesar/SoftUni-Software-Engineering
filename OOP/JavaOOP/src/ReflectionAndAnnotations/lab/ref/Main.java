package ReflectionAndAnnotations.lab.ref;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] arguments) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        // entry point
        Class<Reflection> reflectionClass = Reflection.class;

        // Class.forName("ReflectionAndAnnotations.lab.ref.Reflection");

        // _01_

        System.out.println(reflectionClass);
        // if there is no such class, return Object class
        System.out.println(reflectionClass.getSuperclass());

        Class<?>[] interfaces = reflectionClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();

        // init param                                        // init args
        // reflectionClass.getDeclaredConstructor(String.class, String.class, String.class).newInstance("Melisa", "Melissa", "Mellisa");

        System.out.println(reflectionObject);

        // _02_

        Method[] methods = reflectionClass.getDeclaredMethods(); // all methods

        Arrays.stream(methods)
                .filter(isGetterMethod())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s will return class %s\n", m.getName(), m.getReturnType().getName()));

        Arrays.stream(methods)
                .filter(isSetterMethod())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s and will set field of class %s\n", m.getName(), m.getParameterTypes()[0].getName()));

        // _03_

        Field[] fields = reflectionClass.getDeclaredFields();

      /*  for (Field field : fields) {
            int modifiers = field.getModifiers(); // a bit number represent kind of modifiers ex. public static final
            if (!Modifier.isPrivate(modifiers)) {
                System.out.printf("%s must be private!\n",field.getName());
            }
        }*/

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!\n", f.getName()));

        Arrays.stream(methods)
                .filter(isGetterMethod())
                .filter(g -> !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g -> System.out.printf("%s have to be public!\n", g.getName()));

        Arrays.stream(methods)
                .filter(isSetterMethod())
                .filter(s -> !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s -> System.out.printf("%s have to be private!\n", s.getName()));

    }

    private static Predicate<Method> isSetterMethod() {
        return m -> m.getName().startsWith("set")
                && m.getParameterCount() != 0
                && m.getReturnType().equals(void.class);
    }

    private static Predicate<Method> isGetterMethod() {
        return m -> m.getName().startsWith("get")
                && m.getParameterCount() == 0
                && !m.getReturnType().equals(void.class);
    }
}
