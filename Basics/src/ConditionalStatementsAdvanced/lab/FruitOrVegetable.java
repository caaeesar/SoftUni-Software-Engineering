package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String products = scanner.next(); //само едно нещо ще четем от конзолата

        switch (products) {
            case "banana":
            case "apple":
            case "kiwi":
            case "cherry":
            case "lemon":
            case "grapes":
                System.out.print("fruit");
                break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot":
                System.out.print("vegetable");
                break;
            default:
                System.out.print("unknown");
                break;
        }
    }
}
