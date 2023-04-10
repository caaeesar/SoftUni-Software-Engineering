package Basic.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalLostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int countTrashesHeadset = 0;
        int countTrashesMouse = 0;
        int countTrashesKeyboard = 0;
        int countTrashesDisplay = 0;

        for (int currentLostGame = 1; currentLostGame <= totalLostGames; currentLostGame++) {

            boolean mouseIsTrashes = false;
            boolean headsetIsTrashes = false;
            count1++;
            count2++;
            if (count1 == 2) {
                countTrashesHeadset++;
                headsetIsTrashes = true;
                count1 = 0;
            }

            if (count2 == 3) {
                countTrashesMouse++;
                mouseIsTrashes = true;
                count2 = 0;
            }

            if (headsetIsTrashes && mouseIsTrashes) {
                countTrashesKeyboard++;
                count3++;
            }
            if (count3 == 2) {
                countTrashesDisplay++;
                count3 = 0;
            }
        }

        /*
           търсим зависимост
         int headsetsTrashes = lostGameCount / 2;
         int mouseTrashes = lostGameCount / 3;
         int keyboardTrashes = lostGameCount / 6;
         int displayTrashes = lostGameCount / 12;
         double totalExpenses =
                            (headsetsTrashes * headsetPrice) +
                                 (mouseTrashes * mousePrice) +
                           (keyboardTrashes * keyboardPrice) +
                             (displayTrashes * displayPrice);
         1
         2 с
         3 м
         4 с
         5
      м  6 с м - > к
         7
         8 с
         9 м
         10 с
         11
      д  12 с м -> к -> д
         13
         14 с
         15 м
         16 с
         17
         18 с м -> к
         19
         20 с
         21 м
         22 с
         23
         24 с м -> к -> д
         25
         26 с
         */

        double totalExpenses = (headsetPrice * countTrashesHeadset)
                + (mousePrice * countTrashesMouse)
                + (displayPrice * countTrashesDisplay)
                + (keyboardPrice * countTrashesKeyboard);
        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
