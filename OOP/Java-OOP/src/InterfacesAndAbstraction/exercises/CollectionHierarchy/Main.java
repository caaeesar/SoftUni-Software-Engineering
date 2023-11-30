package InterfacesAndAbstraction.exercises.CollectionHierarchy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsToAdd = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);
        int nRemoveOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        processAddOperation(stringsToAdd,addCollection);
        processAddOperation(stringsToAdd,addRemoveCollection);
        processAddOperation(stringsToAdd,myList);
        processRemoveOperation(nRemoveOperations,addRemoveCollection);
        processRemoveOperation(nRemoveOperations,myList);
    }

    private static void processRemoveOperation(int n, AddRemovable collection) {
        for (int i = 0; i < n; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void processAddOperation(String[] stringsToAdd, Addable collection) {
        for (String item : stringsToAdd) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }
}
