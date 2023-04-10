package ReflectionAndAnnotations.exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> aClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt instance = constructor.newInstance();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String[] parts = input.split("_");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            Method declaredMethod = aClass.getDeclaredMethod(command, int.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, value);

            Field field = aClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.getInt(instance));


            input = scanner.nextLine();
        }

    }
}
