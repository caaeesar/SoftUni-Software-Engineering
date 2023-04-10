package FirstStepsInCoding.lab;
import java.util.Scanner;

public class GreetingByName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        char symbol = '!';

//      System.out.printf ("Hello, %s!", name);          first way
//      System.out.println("Hello, " + name + "!");      second way - чрез конкатенация(прилепване на String)
        System.out.printf("Hello, %s%c", name, symbol);  // third way

    }
}
