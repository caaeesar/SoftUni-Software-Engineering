package Exams.Mid.MyExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> booksList = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {

            String[] parts = input.split(" \\| ");
            String command = parts[0];
            String bookName = parts[1];

            switch (command) {
                case "Add Book":
                    if (!booksList.contains(bookName)) {
                        booksList.add(0, bookName);
                    }
                    break;
                case "Take Book":
                    booksList.remove(bookName);
                    break;
                case "Swap Books":
                    String book1 = parts[1];
                    String book2 = parts[2];
                    if (booksList.contains(book1) && booksList.contains(book2)) {
                        int index1 = booksList.indexOf(book1);
                        int index2 = booksList.indexOf(book2);
                        booksList.set(index1, book2);
                        booksList.set(index2, book1);
                    }
                    break;
                case "Insert Book":
                    if (!booksList.contains(bookName)) {
                        booksList.add(bookName);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(parts[1]);
                    if (index >= 0 && index < booksList.size()) {
                        System.out.println(booksList.get(index));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", booksList));
    }
}
