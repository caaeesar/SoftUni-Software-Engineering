package JavaBook;

import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] argument) {
        Scanner scanner = new Scanner(System.in);

        int side = Integer.parseInt(scanner.nextLine()); // дължина на площадката (квадрат)
        double widthTile = Double.parseDouble(scanner.nextLine()); // широчина на една плочка
        double lengthTile = Double.parseDouble(scanner.nextLine()); // дължина на една плочка
        int widthBench = Integer.parseInt(scanner.nextLine()); // широчина на пейката
        int lengthBench = Integer.parseInt(scanner.nextLine()); // дължина на пейката
        double putTime = 0.2;   // минути се поставя една плочка

        int playground = side * side; // площа на цялата площадка
        double tile = widthTile * lengthTile; // мястото, което заема една плочка
        double bench = widthBench * lengthBench; // мястото, което заема пейката

        double needTiles = (playground - bench) / tile; // нужния брой плочки
        double needTime = needTiles * putTime;

        System.out.println(needTiles);
        System.out.println(needTime);
    }
}
