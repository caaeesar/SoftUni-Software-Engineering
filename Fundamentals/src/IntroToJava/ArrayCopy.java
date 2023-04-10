package IntroToJava;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] arguments) {
        String[] names = {"Melisa", "Georgi"};

        String[] copyString = new String[2];

        // 1. масива, от който ще копираме;
        // 2. началната позиция на входния масив(индексът, от който искаме да копираме);
        // 3. масива, на който искаме на презаписваме;
        // 4. началната позиция на изходния масив;
        // 5. номера на елементите за копиране;

        System.arraycopy(names,0,copyString,0,2);
        System.out.println(Arrays.deepToString(copyString));

        /*
         *
         */

        // from index to index НЕ ВКЛЮЧИТЕЛНО
                         // 0   1    2    3    4     5    6    7    8    9    10   11   12
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'e', 't', 'e', 'd'};
        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 10);
        System.out.println(new String(copyTo)); // caffeine
    }
}
