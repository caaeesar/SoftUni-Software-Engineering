package WhileLoop.moreExercise;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // проверяваме дали са прочетени специалните букви;
        boolean isReadC = false;
        boolean isReadO = false;
        boolean isReadN = false;
        String word = "";
        String input = scanner.next();

        while (!input.equals("End")) {
            char letter = input.charAt(0); // взимаме от входа първия символ;
            boolean isSave = false; // проверяваме дали се запазва буква (буквите различни от латинските НЕ се конкатенират към думата)

            //от asciiTable взимаме числовата стойност на буквите от a до z ; от A до Z;
            // може вместо числа и самите букви да вземем;
            if (letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122) {

                switch (letter) { // по условие при първото получаване на спец.букви не се запазват;
                    case 'c':
                        isSave = isReadC; // първия път не се запазва само се чете;
                        isReadC = true;   // показваме, че вече е прочетена веднъж и следващите пъти ще се запази;
                        break;
                    case 'o':
                        isSave = isReadO;
                        isReadO = true;
                        break;
                    case 'n':
                        isSave = isReadN;
                        isReadN = true;
                        break;
                    default:
                        isSave = true;
                        break;
                }
            }

            if (isSave) { // ако е запазена някоя буква я печатаме;
                word += letter;
            }
            if (isReadC && isReadN && isReadO) { // по условие след като по веднъж са прочетени спец.символи:
                System.out.print(word + " ");  // трябва да отшечатаме думата
                word = ""; // започваме да конкатенираме отначало
                isReadC = false; // сетваме ги да са непрочетени
                isReadN = false;
                isReadO = false;
            }
            input = scanner.next();
        }
    }
}
