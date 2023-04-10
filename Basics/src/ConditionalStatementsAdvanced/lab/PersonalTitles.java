package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);

        switch (gender){
            case 'm':
                if (age >= 16) {
                    System.out.println("Mr.");
                } else{
                    System.out.println("Master");
                }
                break;
            case 'f':
                if (age >= 16){
                    System.out.println("Ms.");
                } else {
                    System.out.println("Miss");
                }
                break;
        }
    }
}
