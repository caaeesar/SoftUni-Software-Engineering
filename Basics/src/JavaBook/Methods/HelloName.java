package JavaBook.Methods;

import java.util.Scanner;

public class HelloName {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        printName(name);
    }

    static void printName(String name) {

        System.out.printf("Hello, %s!", name);
    }
}
