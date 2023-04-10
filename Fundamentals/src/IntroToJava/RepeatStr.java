package IntroToJava;

import java.util.Scanner;

public class RepeatStr {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int countRepeat = Integer.parseInt(scanner.nextLine());
        System.out.println(String.join("",repeatedString(str, countRepeat)));
    }

    static String[] repeatedString(String s, int count) {
        String[] array = new String[count];

        //Arrays.fill(array, s);
        for (int index = 0; index < array.length; index++) {

            array[index] = s;
        }
        return array;
    }
}
