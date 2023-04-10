package IntroToJava;

public class Array20Elements {
    public static void main(String[] arguments) {

        int[] myArray = new int [20];

        for (int index = 0; index < myArray.length; index++) {

            myArray[index] = index * 5;
            System.out.printf("element %d -> %d sum%n",index, myArray[index]);
        }
    }
}
