package IntroToJava;

import java.util.Random;

public class RandomPassGenerator {

    static Random random = new Random();

    public static void main(String[] arguments) {

        String capitalLetter = "ABCDIFJHIGKLNMOPQRSTUVWXYZ";
        String lowerLetter = "abcdifghijklmnopqrstuvwxyz";
        String specialSymbols = "!@#$%^&*()[]{}<>";
        String numbers = "0123456789";

        StringBuilder password = new StringBuilder(" ");

        for (int i = 1; i <= 5; i++) {
            char randomSymbol = generateRandomChar(capitalLetter);
            insertRandomSymbol(password,randomSymbol);
        }
        for (int i = 1; i <= 5; i++) {
            char randomSymbol = generateRandomChar(lowerLetter);
            insertRandomSymbol(password,randomSymbol);
        }
        for (int i = 1; i <= 4; i++) {
            char randomSymbol = generateRandomChar(specialSymbols);
            insertRandomSymbol(password,randomSymbol);
        }
        for (int i = 1; i <= 2; i++) {
            char randomSymbol = generateRandomChar(numbers);
            insertRandomSymbol(password,randomSymbol);
        }
        System.out.println(password);
    }
    static char generateRandomChar(String str) {
        int randomIndex = random.nextInt(str.length());
        char randomSymbol = str.charAt(randomIndex);
        return randomSymbol;
    }

    static void insertRandomSymbol(StringBuilder pass, char symbol) {
        int randomPosition = random.nextInt(pass.length()) ;
        pass.insert(randomPosition,symbol);
    }
}
