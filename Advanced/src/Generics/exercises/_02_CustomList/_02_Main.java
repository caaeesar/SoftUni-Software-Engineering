package Generics.exercises._02_CustomList;

import java.util.Collections;
import java.util.Scanner;

public class _02_Main {

    public static final String END = "END";
    public static final String ADD = "Add";
    public static final String REMOVE = "Remove";
    public static final String CONTAINS = "Contains";
    public static final String SWAP = "Swap";
    public static final String GREATER = "Greater";
    public static final String MAX = "Max";
    public static final String MIN = "Min";
    public static final String PRINT = "Print";
    public static final String SORT = "Sort";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();
        String input = scanner.nextLine();

        while (!END.equals(input)) {

            String command = input.split("\\s")[0];
            String element;
            switch (command) {
                case ADD:
                    element = input.split("\\s")[1];
                    list.add(element);
                    break;
                case REMOVE:
                    int index = Integer.parseInt(input.split("\\s")[1]);
                    list.remove(index);
                    break;
                case CONTAINS:
                    element = input.split("\\s")[1];
                    System.out.println(list.contains(element));
                    break;
                case SWAP:
                    int index1 = Integer.parseInt(input.split("\\s")[1]);
                    int index2 = Integer.parseInt(input.split("\\s")[2]);
                    list.swap(index1,index2);
                    break;
                case GREATER:
                    element = input.split("\\s")[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case MAX:
                    System.out.println(list.getMax());
                    break;
                case MIN:
                    System.out.println(list.getMin());
                    break;
                case SORT:
                  list.sort();
                    break;
                case PRINT:
                    System.out.print(list);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
