package TextProcessing.moreExercise;

import java.util.Scanner;

public class HTML {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String content = scanner.nextLine();

        System.out.println("<h1>");
        System.out.printf("    %s%n", title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.printf("    %s%n", content);
        System.out.println("</article>");

        String command = scanner.nextLine();
        while (!"end of comments".equals(command)) {

            String comment = command;
            System.out.printf("<div>%n");
            System.out.printf("    %s%n", comment);
            System.out.printf("</div>%n");

            command = scanner.nextLine();
        }
    }
}
