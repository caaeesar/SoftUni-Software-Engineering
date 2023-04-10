package ObjectsAndClasses.exercise.articles;

import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split(", ");
        Article article = new Article(parts[0], parts[1], parts[2]);
        int commands = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= commands; currentLine++) {

            String[] information = scanner.nextLine().split(": ");
            switch (information[0]) {
                case "Edit":
                    article.editContent(information[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(information[1]);
                    break;
                case "Rename":
                    article.renameTitle(information[1]);
                    break;
            }
        }
        System.out.print(article);
    }
}
