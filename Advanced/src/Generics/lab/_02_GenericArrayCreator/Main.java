package Generics.lab._02_GenericArrayCreator;

public class Main {
    public static void main(String[] arguments) {

        String[] arr = ArrayCreator.create(10,"none");
        Integer[] array = ArrayCreator.create(Integer.class,10,-1);

    }
}
