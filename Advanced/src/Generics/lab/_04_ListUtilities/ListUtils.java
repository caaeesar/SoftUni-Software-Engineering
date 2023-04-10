package Generics.lab._04_ListUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        T min;
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                T current = list.get(i);
                if (min.compareTo(current) > 0) {
                    min = current;
                }
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        T max;
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                T current = list.get(i);
                if (max.compareTo(current) < 0) {
                    max = current;
                }
            }
        }
        return max;
    }
}
