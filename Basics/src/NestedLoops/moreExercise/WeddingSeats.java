package NestedLoops.moreExercise;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // * РЕШЕНИЕ С for И while ЦИКЪЛ
        /*
        char lastSector = scanner.nextLine().charAt(0);
        int lastRows = Integer.parseInt(scanner.nextLine());

        int seatsOddRows = Integer.parseInt(scanner.nextLine());
        int seatsEvenRows = seatsOddRows + 2;

        int copySeatOdd = seatsOddRows;
        int copySeatEven = copySeatOdd + 2;
        int totalSeats = 0;

        for (char sector = 'A'; sector <= lastSector; sector++) {

            for (int row = 1; row <= lastRows; row++) {

                if (row % 2 == 0) {
                    char seat = 'a';
                    while (seatsEvenRows > 0) {
                        totalSeats++;
                        seatsEvenRows--;
                        System.out.printf("%c%d%c\n", sector, row, seat);
                        seat++;
                    }
                } else {
                    char seat = 'a';
                    while (seatsOddRows > 0) {
                        totalSeats++;
                        seatsOddRows--;
                        System.out.printf("%c%d%c\n", sector, row, seat);
                        seat++;
                    }
                }
                seatsEvenRows = copySeatEven;
                seatsOddRows = copySeatOdd;

            }
            lastRows++;
        }
        System.out.println(totalSeats);
    }
}
         */
      /*  char lastSector = scanner.nextLine().charAt(0);
        int lastRow = Integer.parseInt(scanner.nextLine()); // Броят на редовете в първия сектор
        int totalSeatsOddRow = Integer.parseInt(scanner.nextLine()); // Броят на местата на нечетен ред
        int totalSeatsEvenRow = totalSeatsOddRow + 2; // Броят на местата на четен ред
        int countSeats = 0;
        int currentSeatsEvenRow = 0;
        int currentSeatsOddRow = 0;

        for (char sector = 'A'; sector <= lastSector; sector++) {

            for (int rows = 1; rows <= lastRow; rows++) {

                for (char seats = 'a'; seats <= 'z'; seats++) {

                    if (rows % 2 == 0) {
                        currentSeatsEvenRow++;
                    } else {
                        currentSeatsOddRow++;
                    }
                    if (currentSeatsEvenRow > totalSeatsEvenRow) {
                        currentSeatsEvenRow = 0;
                        break;
                    } else if (currentSeatsOddRow > totalSeatsOddRow) {
                        currentSeatsOddRow = 0;
                        break;
                    }
                    countSeats++;
                    System.out.printf("%c%d%c\n", sector, rows, seats);
                }
            }
        lastRow++;
        }
        System.out.println(countSeats); */
//////////////////////////////////////////////////////////////
        char lastSector = scanner.nextLine().charAt(0);
        int rows = Integer.parseInt(scanner.nextLine());
        int seatsOddRow = Integer.parseInt(scanner.nextLine());
        int seatsEvenRow = seatsOddRow + 2;
        int count = 0;

        for (char currentSector = 'A'; currentSector <= lastSector; currentSector++) {

            for (int currentRow = 1; currentRow <= rows; currentRow++) {

                if (currentRow % 2 == 0) {

                    for (char currentSeat = 97; currentSeat < 97 + seatsEvenRow; currentSeat++) {

                        System.out.printf("%C%d%c%n", currentSector, currentRow, currentSeat);
                        count++;
                    }

                } else {

                    for (char currentSeat = 97; currentSeat < 97 + seatsOddRow; currentSeat++) {
                        System.out.printf("%C%d%c%n", currentSector, currentRow, currentSeat);
                        count++;
                    }
                }
            }
            rows++;
        }
        System.out.print(count);
    }
}


