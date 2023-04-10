package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class RectangleWithStars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalRows = 0;
        String currentRow = "";

        if (n % 2 == 0) {
            totalRows = n + 1;
        } else {
            totalRows = n + 2;
        }

        // първия и последния ред:
        String firstLAstRow = repeatString("%", n * 2);
        System.out.println(firstLAstRow);

        // други редове:
        for (int row = 1; row <= (totalRows - 3) / 2; row++) {

            String space1 = repeatString(" ", (n * 2) - 2);
            currentRow = "%" + space1 + "%";
            System.out.println(currentRow);
        }
        // среден ред:
        String space = repeatString(" ", ((n * 2) - 4) / 2);
        String midRow = "%" + space + "**" + space + "%";
        System.out.println(midRow);

        // други редове:
        for (int row = 1; row <= (totalRows - 3) / 2; row++) {

            String space2 = repeatString(" ", (n * 2) - 2);
            currentRow = "%" + space2 + "%";
            System.out.println(currentRow);
        }
        // последен ред:
        System.out.println(firstLAstRow);
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}

