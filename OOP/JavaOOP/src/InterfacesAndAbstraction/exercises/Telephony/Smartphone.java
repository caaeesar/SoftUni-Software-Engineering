package InterfacesAndAbstraction.exercises.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char currentSymbol = number.charAt(i);
            if (!Character.isDigit(currentSymbol)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidUrl(String url) {
            for (int i = 0; i < url.length(); i++) {
                char currentSymbol = url.charAt(i);
                if (Character.isDigit(currentSymbol)) {
                    return false;
                }
            }
         return true;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : this.urls) {
            if (isValidUrl(url)){
            output.append(String.format("Browsing: %s!",url)).append(System.lineSeparator());
            } else {
                output.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : this.numbers) {
            if (isValidNumber(number)) {
            output.append(String.format("Calling... %s",number)).append(System.lineSeparator());
            } else {
                output.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }
}
