package Lists.moreExercise;

import java.util.*;

public class MixedUpLists {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        List<String> secondList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        String firstLastElement;
        String secondLastElement;
        if (firstList.size() > secondList.size()) {

            firstLastElement = firstList.get(firstList.size() - 1);
            firstList.remove(firstList.size() - 1);
            secondLastElement = firstList.get(firstList.size() - 1);
            firstList.remove(firstList.size() - 1);
        } else {

            firstLastElement = secondList.get(0);
            secondList.remove(0);
            secondLastElement = secondList.get(0);
            secondList.remove(0);
        }

        List<String> mixedList = mixingLists(firstList, secondList);
        List<Integer> numbersInRange = fulfilCondition(firstLastElement, secondLastElement, mixedList);
        Collections.sort(numbersInRange);
        for (int value : numbersInRange) {
            System.out.print(value + " ");
        }
    }

    private static List<Integer> fulfilCondition(String firstLastElement, String secondLastElement, List<String> mixedList) {
        int start = Math.min(Integer.parseInt(firstLastElement), Integer.parseInt(secondLastElement));
        int end = Math.max(Integer.parseInt(firstLastElement), Integer.parseInt(secondLastElement));
        List<Integer> numbersInRange = new ArrayList<>();

        int i = 0;
        while (i < mixedList.size()) {
            int currentValue = Integer.parseInt(mixedList.get(i));

            if (currentValue > start && currentValue < end) {
                numbersInRange.add(currentValue);
                mixedList.remove(i);
            } else {
                i++;
            }
        }
        return numbersInRange;
    }

    private static List<String> mixingLists(List<String> firstList, List<String> secondList) {
        List<String> mixedList = new ArrayList<>();

        while (!(firstList.isEmpty()) && !(secondList.isEmpty())) {
            int index1 = 0;
            int index2 = secondList.size() - 1;
            mixedList.add(firstList.get(index1));
            firstList.remove(index1);

            mixedList.add(secondList.get(index2));
            secondList.remove(index2);
        }
        return mixedList;
    }
}
