package Inheritance.lab.RandomArrayList;

public class Main {
    public static void main(String[] arguments) {

        RandomArrayList list = new RandomArrayList();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);

        System.out.println(list.getRandomElement());
    }
}
