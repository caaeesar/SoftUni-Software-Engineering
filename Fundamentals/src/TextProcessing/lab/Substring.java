package TextProcessing.lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();
        String str = scanner.nextLine();

        int index = str.indexOf(keyWord);

        while (index != -1) {

            String beforeWord = str.substring(0, index);
            String afterWord = str.substring(index + keyWord.length());

            str = beforeWord + afterWord;

            index = str.indexOf(keyWord);
        }
        System.out.print(str);

        /////////////////////////////////////////////////////////////////////////
      String keyword = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(keyword)) {
            text = text.replace(keyword, "");
        }
        System.out.println(text);
    }
}
