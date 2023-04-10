package PFSchool;

import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void main(String[] arguments) {

        /*СОРТИРАНЕ НА ЧИСЛА*/

        // сортиране във възходящ ред:
        int[] array = {5, 4, -5, 8, -1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // сортиране в низходящ ред (метода не работи с примитивни данни):
        Integer[] arr = {5, 4, -5, 8, -1};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));

        /*СОРТИРАНЕ НА НИЗОВЕ*/

        // сортиране във възходящ ред:
        String[] text = {"Java", "Python", "C#", "Perl"};
        Arrays.sort(text);
        System.out.println(Arrays.toString(text));

        // сортиране в низходящ ред (метода не работи с примитивни данни):
        Arrays.sort(text, Collections.reverseOrder());
        System.out.println(Arrays.toString(text));
    }
}
