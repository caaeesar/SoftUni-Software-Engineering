package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class PointOnSegment {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int point = Integer.parseInt(scanner.nextLine());

        int start = Math.min(x,y);
        int end = Math.max(x,y);

        if (point >= start && point <= end) {

            System.out.print("in");
            int diff1 = Math.abs(start - point);
            int diff2 = Math.abs(end - point);
            System.out.println();
            System.out.print(Math.min(diff1,diff2));
        } else {

            System.out.print("out");
            int diff1 = Math.abs(start - point);
            int diff2 = Math.abs(end - point);
            System.out.println();
            System.out.print(Math.min(diff1,diff2));
        }
    }
}
