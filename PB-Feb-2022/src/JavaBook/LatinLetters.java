package JavaBook;

public class LatinLetters {
    public static void main(String[] arguments) {

        // for-цикъла не работи само с числа, в него може да инициализираме променливи от тип String, char и т.н;

        // първи начин чрез ASCII table
       for (char letter = 97; letter <= 122; letter++) {
           char space = 32;
            System.out.print(letter);
            System.out.print(space);
        }

        // втори начин
      /*  for (char letter = 'a'; letter <= 'z'; letter++) {
            System.out.println(letter);
        } */

    }
}
