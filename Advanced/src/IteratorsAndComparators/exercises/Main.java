package IteratorsAndComparators.exercises;

import IteratorsAndComparators.exercises.ListyIterator;

import java.util.Scanner;

public class Main {

    public static final String END = "END";
    public static final String HAS_NEXT = "HasNext";
    public static final String MOVE = "Move";
    public static final String PRINT = "Print";
    public static final String CREATE = "Create";
    public static final String PRINT_ALL = "PrintAll";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = new ListyIterator();
        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String[] parts = input.split("\\s");
            String command = parts[0];
            String[] elements = new String[parts.length - 1];

            switch (command) {
                case CREATE:
                    for (int i = 1; i < parts.length; i++) {
                        elements[i - 1] = parts[i];
                    }
                    listyIterator = new ListyIterator(elements);
                    break;
                case HAS_NEXT:
                    System.out.println(listyIterator.hasNext());
                    break;
                case MOVE:
                    System.out.println(listyIterator.move());
                    break;
                case PRINT:
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case PRINT_ALL:
                    for (String e : listyIterator) {
                        System.out.print(e + " ");
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
