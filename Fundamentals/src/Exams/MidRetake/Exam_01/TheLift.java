package Exams.MidRetake.Exam_01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isFullLift = false;

        while (waitingPeople > 0) { // докато има още чакащи хора

            for (int indexOfWagon = 0; indexOfWagon < lift.length; indexOfWagon++) { // минаваме през всички вагони

                int currentPeopleInWagon = lift[indexOfWagon];

                if (currentPeopleInWagon < 4) { // има място за др. хора

                    if (waitingPeople < 4) {
                        lift[indexOfWagon] = currentPeopleInWagon + waitingPeople;
                        waitingPeople -= waitingPeople;
                    } else {
                        int boardingPeople = 4 - currentPeopleInWagon; // текущото свободно място
                        lift[indexOfWagon] = currentPeopleInWagon + boardingPeople;
                        waitingPeople -= boardingPeople;
                    }
                }

                if (indexOfWagon == lift.length - 1) { // стигаме до последния вагон
                    if (lift[indexOfWagon] == 4) { // ако той е пълен
                        if (waitingPeople == 0) { // ако няма други чакащи хора
                            for (int people : lift) {
                                System.out.printf("%d ", people);
                            }
                            return;
                        } else { // ако има други чакащи хора
                            System.out.printf("There isn't enough space! %d people in a queue!\n", waitingPeople);
                            isFullLift = true;
                            break;
                        }
                    }
                }
            }
            if (isFullLift) {
                break;
            }
        }

        if (waitingPeople == 0) {
            System.out.println("The lift has empty spots!");
        }
        for (int people : lift) {
            System.out.printf("%d ", people);
        }
    }
}
