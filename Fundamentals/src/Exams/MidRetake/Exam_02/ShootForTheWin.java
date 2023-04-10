package Exams.MidRetake.Exam_02;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] targetsSequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countTargets = 0;
        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            int targetIndex = Integer.parseInt(input);
            if (targetIndex >= 0 && targetIndex < targetsSequence.length) {
                int shootTargetValue = targetsSequence[targetIndex];
                if (targetsSequence[targetIndex] != -1) {
                    targetsSequence[targetIndex] = -1;
                    countTargets++;
                }
                for (int i = 0; i < targetsSequence.length; i++) {
                    int currentTarget = targetsSequence[i];
                    if (currentTarget != -1) {
                        if (currentTarget > shootTargetValue) {
                            currentTarget -= shootTargetValue;
                        } else if (currentTarget <= shootTargetValue) {
                            currentTarget += shootTargetValue;
                        }
                        targetsSequence[i] = currentTarget;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countTargets);
        Arrays.stream(targetsSequence).forEach(e -> System.out.print(e + " "));
    }
}
