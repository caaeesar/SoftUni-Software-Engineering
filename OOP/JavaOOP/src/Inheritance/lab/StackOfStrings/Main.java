package Inheritance.lab.StackOfStrings;

public class Main {
    public static void main(String[] arguments) {

        StackOfStrings stackOfString = new StackOfStrings();

        stackOfString.push("one");
        stackOfString.push("two");
        stackOfString.push("three");

        System.out.println(stackOfString.isEmpty());
        System.out.println(stackOfString.peek());
        System.out.println(stackOfString.pop());

    }
}
