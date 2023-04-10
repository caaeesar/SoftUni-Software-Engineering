package Arrays.exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] people = new int[n];
        int allPeople = 0;

        for (int index = 0; index < n; index++) {
            int currentPeople = Integer.parseInt(scanner.nextLine());
            people[index] = currentPeople;
            allPeople += currentPeople;
        }
        for (int currentPeople : people) {
            System.out.print(currentPeople + " ");
        }
        System.out.println();
        System.out.print(allPeople);
    }
}
