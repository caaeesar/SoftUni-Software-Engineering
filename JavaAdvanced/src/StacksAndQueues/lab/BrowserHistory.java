package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        String currentURL = "";
        String input = scanner.nextLine();

        while (!"Home".equals(input)) {

            boolean isURL = !input.equals("back");
            if (isURL){
                currentURL = input;
                browserHistory.push(currentURL);
                System.out.println(browserHistory.peek());
            } else {

                if (browserHistory.size() > 1){
                    browserHistory.pop();
                    currentURL = browserHistory.peek();
                    System.out.println(currentURL);
                } else {
                    System.out.println("no previous URLs");
                }
            }
            input = scanner.nextLine();
        }
    }
}
