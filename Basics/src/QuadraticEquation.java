import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // ax2 + bx + c
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        if (a != 0) {

            double sumD = (Math.pow(b, 2)) - (4 * a * c);

            if (sumD < 0) {

                System.out.println("Квадратното уравнение няма реални корени!");
                System.out.printf("Дискриминантата е отрицателно число %.0f", sumD);
            } else if (sumD == 0) {

                int x = -b / (2 * a);
                System.out.printf("Квадратното уравнение има само един реален корен -> x = %d", x);
            } else if (sumD > 0) {

                double D = Math.sqrt(sumD);
                double x1 = (-b + D) / (2 * a);
                double x2 = (-b - D) / (2 * a);
                System.out.printf("Квадратното уравнение има два реални корена: x1 = %.0f ; x2 = %.0f", x1, x2);
            }
        }
    }
}
