package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentURL = "";

        while (!"Home".equals(input)) {

            boolean isBack = input.equals("back");
            boolean isForward = input.equals("forward");
            boolean isURL = !isBack && !isForward;

            if (isURL) {
                currentURL = input;
                browserHistory.push(currentURL);
                if (!forward.isEmpty()){
                    forward.clear();
                }
                System.out.println(currentURL);

            } else if (isBack) {

                if (browserHistory.size() > 1) {
                    forward.push(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else if (isForward) {

                if (!forward.isEmpty()) {
                    browserHistory.push(forward.peek());
                    System.out.println(forward.pop());

                } else {
                    System.out.println("no next URLs");
                }
            }
            input = scanner.nextLine();
        }
    }
}
