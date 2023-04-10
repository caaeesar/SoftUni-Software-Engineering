package JavaBook.Methods;

public class DemoSleep {
    public static void main(String[] arguments) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

            //забавяне на цикъла
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
