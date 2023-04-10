package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int nLines = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int currentLine = 0; currentLine < nLines; currentLine++) {

            String[] currentCommand = scanner.nextLine().split("\\s+");
            int type = Integer.parseInt(currentCommand[0]);

            switch (type) {
                case 1:
                    stack.push(String.valueOf(text));
                    String str = currentCommand[1];
                    text.append(str);
                    break;
                case 2:
                    stack.push(String.valueOf(text));
                    int count = Integer.parseInt(currentCommand[1]);
                    text.delete(text.length() - count, text.length());
                    break;
                case 3:
                    int index = Integer.parseInt(currentCommand[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                       text = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
