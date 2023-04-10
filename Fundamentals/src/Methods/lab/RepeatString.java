package Methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        String result = repeatString(str, count);
        System.out.print(result);
    }

    static String repeatString(String str, int count) {
        String[] arr = new String[count];
    //  Arrays.fill(arr, str);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str;
        }
        return String.join("", arr);
      /*  String text = "";

        for (int i = 0; i < count; i++) {
            text += str;
        }
        return text;*/
    }
}
