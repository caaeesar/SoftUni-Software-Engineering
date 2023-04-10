package Generics.exercises._01_GenericBox;

import java.util.Scanner;

public class _01_Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            //String element = scanner.nextLine();
             int element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        box.swap(scanner.nextInt(), scanner.nextInt());
        System.out.println(box);*/


        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }
        System.out.println(box.countGreaterElements(Double.parseDouble(scanner.nextLine())));
    }
}
