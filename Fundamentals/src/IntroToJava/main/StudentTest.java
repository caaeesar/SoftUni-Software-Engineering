package IntroToJava.main;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student("Melissa","Dimitrova","Rudeva");
        Student student2 = new Student("George","Georgiev","Georgiev","biology","medicine","SofiaUniversity", "ggg_11@gmail.com",359_876_846);

        student2.setPhoneNumber(359987678);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(Student.getCountStudents());

    }
}
