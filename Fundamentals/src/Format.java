import java.text.DecimalFormat;

public class Format {

    public static void main(String[] arguments) {

        String pattern = "###,###.###";
      /*  String pattern = "0.##"; */

        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        String format = decimalFormat.format(123456789.123);
        System.out.println(format);

    }
}
