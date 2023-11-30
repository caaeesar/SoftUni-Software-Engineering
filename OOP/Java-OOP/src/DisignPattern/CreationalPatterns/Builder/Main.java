package DisignPattern.CreationalPatterns.Builder;

public class Main {

    public static void main(String[] args) {

        User user = User.builder()
                .withAge(30)
                .withPhone("1234567")
                .withAddress("Fake address 1234")
                .build();

    }
}
