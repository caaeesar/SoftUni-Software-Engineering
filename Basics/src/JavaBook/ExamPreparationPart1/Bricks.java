package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class Bricks {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allBricks = Integer.parseInt(scanner.nextLine());
        int allWorker = Integer.parseInt(scanner.nextLine());
        int trolleyCapacity = Integer.parseInt(scanner.nextLine());

        int totalBricks = allWorker * trolleyCapacity;
        double courses = Math.ceil(allBricks * 1.00 / totalBricks);
        System.out.printf("%.0f", courses);
    }
}
