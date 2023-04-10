package Exams.Final.Exam_02;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int nLines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= nLines; currentLine++) {

            String currentBarcode = scanner.nextLine();

            String regex = "^@[#]+[A-Z][A-Za-z0-9]{4,}[A-Z]@[#]+$";
            Pattern validBarcodePattern = Pattern.compile(regex);
            Matcher barcodeMatcher = validBarcodePattern.matcher(currentBarcode);
            String productGroup = "";

            if (barcodeMatcher.matches()) {
                String digitRegex = "[0-9]";
                Pattern productGroupPattern = Pattern.compile(digitRegex);
                Matcher digitsMatcher = productGroupPattern.matcher(barcodeMatcher.group(0));
                boolean isHaveGroup = false;
                while (digitsMatcher.find()) {
                    productGroup += digitsMatcher.group();
                    isHaveGroup = true;
                }
                if (isHaveGroup) {
                    System.out.printf("Product group: %s\n", productGroup);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
