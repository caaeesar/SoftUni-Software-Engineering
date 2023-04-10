package JavaBook.Methods;

public class BlankReceipt {
    public static void main(String[] arguments) {

        printReceipt();
    }

    static void printFirstPArt() {
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }

    static void printSecondPart() {
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }

    static void printThirdPart() {
        System.out.println("------------------------------");
        System.out.println("(c) SoftUni");
    }

    static void printReceipt() {
        printFirstPArt();
        printSecondPart();
        printThirdPart();
    }
}
