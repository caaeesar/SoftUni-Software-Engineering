package Lists.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  List<Integer> numberList1 = Arrays.stream(scanner.nextLine().split(" "))
         *                 .map(Integer::parseInt)
         *                 .collect(Collectors.toList());
         *         List<Integer> numberList2 = Arrays.stream(scanner.nextLine().split(" "))
         *                 .map(Integer::parseInt)
         *                 .collect(Collectors.toList());
         *
         *         List<Integer> resultList = new ArrayList<>(numberList1.size() + numberList2.size());
         *
         *         int smallerSize = Math.min(numberList1.size(), numberList2.size());
         *         int index = 0;
         *         while (index <= smallerSize - 1) {
         *
         *             int firstElement = numberList1.get(index);
         *             int secondElement = numberList2.get(index);
         *             numberList1.remove(index);
         *             numberList2.remove(index);
         *             resultList.add(firstElement);
         *             resultList.add(secondElement);
         *
         *             smallerSize--;
         *         }
         *
         *         if (!numberList1.isEmpty()) {
         *             resultList.addAll(numberList1);
         *         }
         *         if (!numberList2.isEmpty()) {
         *             resultList.addAll(numberList2);
         *         }
         *         resultList.forEach(e -> System.out.print(e + " "));
         */

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        List<Integer> numbers1 = parseNumbers(array1);
        List<Integer> numbers2 = parseNumbers(array2);

        List<Integer> merged = new ArrayList<>();
        int maxSize = Math.max(numbers1.size(), numbers2.size());

        for (int i = 0; i < maxSize; i++) {

            if (numbers1.size() > i) {
                merged.add(numbers1.get(i));
            }
            if (numbers2.size() > i) {
                merged.add(numbers2.get(i));
            }
        }
        for (int number : merged) {
            System.out.print(number + " ");
        }
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>(splitLine.length);
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
