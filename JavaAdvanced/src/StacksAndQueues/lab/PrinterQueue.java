package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> printerQueue = new ArrayDeque<>();
        String currentFile = "";

        while (!"print".equals(input)) {

            boolean isFile = !input.equals("cancel");
            if (isFile) {
                currentFile = input;
                printerQueue.offer(currentFile);
            } else {

                if (printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.peek());
                    printerQueue.poll();
                }
            }
            input = scanner.nextLine();
        }
        for (String file : printerQueue) {
            System.out.println(file);
        }
    }
}
