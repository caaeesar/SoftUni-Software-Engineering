package Generics.lab._03_GenericScale;

public class Main {
    public static void main(String[] arguments) {

        Scale<Integer> scale = new Scale<>(2, 2);
        System.out.print(scale.getHeavier());
        System.out.println();
        Scale<String> sc = new Scale<>("A", "Bor");
        System.out.print(sc.getHeavier());
    }
}
