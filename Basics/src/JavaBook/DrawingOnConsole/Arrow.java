package JavaBook.DrawingOnConsole;

import java.util.Scanner;

public class Arrow {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalCols = n + ((n - 1) / 2) * 2;
        int countOutFullStop = (n - 1) / 2;
        int countOutLastFullStop = 1;
        int countInLastFullStop = (totalCols - (countOutLastFullStop * 2)) - 2;

        //първи ред:
        String outFullStop = repeatString(".", countOutFullStop);
        String firstDash = repeatString("#", n);
        System.out.printf("%s%s%s%n", outFullStop, firstDash, outFullStop);

        //останалите редове до средата:
        for (int row = 1; row <= (n - 2); row++) {

            String inMidFullStop = repeatString(".", n - 2);
            String outMidFullStop = repeatString(".", (n - 1) / 2);
            System.out.printf("%s#%s#%s%n", outMidFullStop, inMidFullStop, outMidFullStop);
        }
        //среден ред:
        String midDash = repeatString("#", (n + 1) / 2);
        String midFullStop = repeatString(".", n - 2);
        System.out.printf("%s%s%s%n", midDash, midFullStop, midDash);

        //последна част:
        for (int row = 1; row <= n - 2; row++) {

            String outLastFullStop = repeatString(".", countOutLastFullStop);
            String inLastFullStop = repeatString(".", countInLastFullStop);
            System.out.printf("%s#%s#%s%n", outLastFullStop, inLastFullStop, outLastFullStop);
            countOutLastFullStop++;
            countInLastFullStop -= 2;
        }
        //последен ред:
        String lastFullStop = repeatString(".", (totalCols - 1) / 2);
        System.out.printf("%s#%s", lastFullStop, lastFullStop);
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}
