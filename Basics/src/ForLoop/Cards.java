package ForLoop;

public class Cards {
    public static void main(String[] arguments) {

        String card = "";
        String paint = "";

        for (int currentCard = 1; currentCard <= 14; currentCard++) {

            for (int currentPaint = 1; currentPaint <= 4; currentPaint++) {

                switch (currentCard) {

                    case 11:
                        card = "J";
                        break;
                    case 12:
                        card = "Q";
                        break;
                    case 13:
                        card = "K";
                        break;
                    case 14:
                        card = "A";
                        break;
                    default:
                        card = currentCard + "";
                        break;
                }

                switch (currentPaint) {

                    case 1:
                        paint = "спатия";
                        break;
                    case 2:
                        paint = "каро";
                        break;
                    case 3:
                        paint = "купа";
                        break;
                    case 4:
                        paint = "пика";
                        break;
                }
                System.out.printf("%s %s%n", card, paint);
            }
        }
    }
}
