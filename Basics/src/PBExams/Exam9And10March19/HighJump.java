package PBExams.Exam9And10March19;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int purposeHeight = Integer.parseInt(scanner.nextLine()); //желаната височина на летвата
        int currentHeight = purposeHeight - 30; //текущата височина на летвата
        int fails = 0;
        int jumps = 0;

        while (currentHeight <= purposeHeight) { // ще скача, докато не стигне целта си
            // (слагаме = защото трябва да прескочи тази височина)
            int currentJump = Integer.parseInt(scanner.nextLine()); // скок
            jumps++;

            if (currentJump > currentHeight) { //успешен скок

                currentHeight += 5; //летвата се вдига с 5см
                fails = 0;
            } else {
                fails++; //височината си остава същата
                if (fails == 3) {

                    System.out.printf("Tihomir failed at %dcm after %d jumps.", currentHeight, jumps);
                    break;
                }
            }
        }
        if (currentHeight > purposeHeight) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", currentHeight - 5, jumps);
        }
    }
}



