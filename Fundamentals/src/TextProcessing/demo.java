package TextProcessing;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] arguments) {

        /*String newLine = System.getProperty("line.separator");
        System.out.println(String.join(newLine,
                "Get busy living",
                "or",
                "get busy dying.",
                "--Stephen King"));


            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println("Get busy living");
            printWriter.println("or");
            printWriter.println("get busy dying.");
            printWriter.println("--Stephen King");*/

        //The given regular expression ensures that empty or blank strings won't validate.
        //  @Pattern(regexp = "\\A(?!\\s*\\Z).+")

        /*
         * An empty string is a String object with an assigned value, but its length is equal to zero.
         * A null string has no value at all.
         * A blank String contains only whitespaces, are is neither empty nor null,
         * since it does have an assigned value, and isn't of 0 length.
         */
        String nullString = null;
        String emptyString = ""; //the empty string is a subset of every other string
        String blankString = " ";

        //Count characters in String
        String someString = "elephant";
        long count = someString.chars() //codePoints() chars() -> return IntStream
                .filter(ch -> ch == 'e').count();
        System.out.println(count);

        StringJoiner sj = new StringJoiner(",", "(", ")");
        sj.add("Melisa");
        sj.add("Melisa");
        sj.add("Melisa");
        System.out.println(sj);

        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();//returns string from pool, now it will be same as s2
        System.out.println(s1 == s2);//false because reference variables are pointing to different instance
        System.out.println(s2 == s3);//true because reference variables are pointing to same instance  

        byte[] array = new byte[]{97, 98, 99, 100}; //ascii code
        String s = new String(array);
        System.out.println(s);

        String str = "Aa";
        System.out.println(str.codePointAt(1));

        byte[] byteArray1 = "abcd".getBytes();
        byte[] expected1 = new byte[]{97, 98, 99, 100};
        System.out.println(Arrays.equals(expected1, byteArray1));

        String str1
                = new String("Welcome to Geeksforgeeks.com");
        String str2 = new String("Geeksforgeeks");

        // Comparing str1 and str2
        System.out.print(
                "Result of Comparing of String 1 and String 2: ");
        System.out.println(
                str1.regionMatches(11, str2, 0, 13));

        String a = "my url with spaces";
        System.out.println(a.replaceAll("\\s+", "-"));

        String b = "foo";
        System.out.println(b.startsWith("f"));
        System.out.println(b.startsWith("o", 1));

        StringTokenizer st = new StringTokenizer("Demonstrating methods from StringTokenizer class", " ");
        /* Checks if the String has any more tokens */
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        String asciiStr = "Melissa";
        char[] chars = asciiStr.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString(ch));
        }
        System.out.println(hex);




    }
}