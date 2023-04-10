package Exams.Mid.Exam_03;

import java.util.Scanner;

public class MuOnline {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        int countRoom = 0;

        String[] dungeonRooms = scanner.nextLine().split("\\|"); //room1|room2|room3…
        for (int indexRoom = 0; indexRoom < dungeonRooms.length; indexRoom++) {

            //  rat 10|bat 20|potion 10|rat 10
            String[] currentRoom = dungeonRooms[indexRoom].split(" ");

            String command = currentRoom[0];
            int amount = Integer.parseInt(currentRoom[1]);
            countRoom++;

            switch (command) {
                case "potion":
                    if (health + amount > 100) {
                        System.out.printf("You healed for %d hp.\n", 100 - health);
                        health = 100;
                    } else {
                        health += amount;
                        System.out.printf("You healed for %d hp.\n", amount);
                    }
                    System.out.printf("Current health: %d hp.\n", health);
                    break;
                case "chest":
                    bitcoins += amount;
                    System.out.printf("You found %d bitcoins.\n", amount);
                    break;
                default:
                    String monster = currentRoom[0];
                    int attack = Integer.parseInt(currentRoom[1]);
                    if (health - attack > 0) {
                        health -= attack;
                        System.out.printf("You slayed %s.\n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", monster);
                        System.out.printf("Best room: %d\n", countRoom);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d\n", bitcoins);
        System.out.printf("Health: %d", health);
    }
}
