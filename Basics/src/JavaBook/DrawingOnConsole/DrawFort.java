package JavaBook.DrawingOnConsole;

import java.util.Scanner;

public class DrawFort {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int cols = n * 2;
        int towerSize = (n / 2);
        int midSize = (cols - (2 * towerSize) - 4);

        // ПОКРИВ:
        String caret = repeatString("^", towerSize);
        String underscore1 = repeatString("_", midSize);
        String tower = "/" + caret + "\\" + underscore1 + "/" + caret + "\\";
        System.out.println(tower);

         //СРЕДНА ЧАСТ:
        // махаме покрива, основата и предпоследния ред от средната част;
        for (int row = 1; row <= (n - 3); row++) {

            String space = repeatString(" ", cols - 2);
           // String middle = "|" + space + "|";
           // System.out.println(middle);
            System.out.printf("|%s|%n",space);

        }
            int spaceSize = (cols - (2 * towerSize) - 4);
            String space1 = repeatString(" ", ((cols - 2) - spaceSize) / 2);
            String underscore2 = repeatString("_", midSize);
           // String middle = "|" + space1 + underscore2 + space1 + "|";
           // System.out.println(middle);
        System.out.printf("|%s%s%s|%n", space1,underscore2, space1);

        //ОСНОВА:
        String underscore3 = repeatString("_", towerSize);
        String space2 = repeatString(" ", midSize);
      //  String ground = "\\" + underscore3 + "/" + space2 + "\\" + underscore3 + "/";
       // System.out.println(ground);
        System.out.printf("\\%s/%s\\%s/",underscore3,space2,underscore3);
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}
