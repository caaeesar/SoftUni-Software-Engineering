package Generics.lab._04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] arguments) {

        List<Integer> list = new ArrayList<>();

        Collections.addAll(list,1,6,3,-1,5,-6);

       /* System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));*/
    }
}
