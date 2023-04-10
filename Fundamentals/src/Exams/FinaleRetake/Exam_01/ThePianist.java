package Exams.FinaleRetake.Exam_01;

import java.util.*;

public class ThePianist {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //  piece   composer[0] key[1]
        Map<String, List<String>> pianoMap = new LinkedHashMap<>();
        int numbersOfPieces = Integer.parseInt(scanner.nextLine());
        String piece;
        String composer;
        String key;
        for (int i = 1; i <= numbersOfPieces; i++) {

            String[] parts = scanner.nextLine().split("\\|");
            piece = parts[0];
            composer = parts[1];
            key = parts[2];

            List<String> currentList = new ArrayList<>();
            currentList.add(0, composer);
            currentList.add(1, key);
            pianoMap.put(piece, currentList);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {

            String[] parts = input.split("\\|");
            String command = parts[0];

            switch (command) {

                case "Add":

                    piece = parts[1];
                    composer = parts[2];
                    key = parts[3];

                    if (pianoMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!\n", piece);
                    } else {
                        List<String> newNestedMap = new ArrayList<>();
                        newNestedMap.add(0, composer);
                        newNestedMap.add(1, key);
                        pianoMap.put(piece, newNestedMap);
                        System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
                    }
                    break;

                case "Remove":
                    piece = parts[1];

                    if (pianoMap.containsKey(piece)) {
                        pianoMap.remove(piece);
                        System.out.printf("Successfully removed %s!\n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;

                case "ChangeKey":

                    piece = parts[1];
                    String newKey = parts[2];

                    if (pianoMap.containsKey(piece)) {
                        List<String> currentList = pianoMap.get(piece);
                        currentList.remove(1);
                        currentList.add(1, newKey);
                        pianoMap.put(piece, currentList);
                        System.out.printf("Changed the key of %s to %s!\n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        pianoMap.forEach((mapKey, mapValue) -> {
            String p = mapKey;
            String c = mapValue.get(0);
            String k = mapValue.get(1);
            System.out.printf("%s -> Composer: %s, Key: %s\n", p, c, k);

        });
    }
}
