package MapsLambdaStreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demoAPI {
    public static void main(String[] arguments) {

        int[] numbers = new int[]{1, 2, 3, 4 ,5};

        int maxValue = Arrays.stream(numbers).max().orElse(-1);
        System.out.println(maxValue);

       IntStream intToStream = Arrays.stream(numbers);
        OptionalDouble optionalMin = intToStream.average();
        if (optionalMin.isPresent()) {
            System.out.println(optionalMin.getAsDouble());
        } else {
            System.out.println("There is no value in this array");
        }

        List<Integer> integerList = Arrays.asList(1, 2, -3, -4, 5, 6, 7, -8, -9);
        Stream<Integer> integerStream = integerList.stream();
        integerStream.mapToInt(Integer::intValue).skip(2).limit(1).forEach(System.out::println);
        System.out.println(integerStream.sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        System.out.println(integerStream.sorted(Comparator.reverseOrder()).collect(Collectors.toList()));


        Map<String, Integer> map = new HashMap<>();
        map.put("Melisa", 55);
        map.put("Geogre", 23);
        map.put("Fefe", 45);
        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
    }
}
