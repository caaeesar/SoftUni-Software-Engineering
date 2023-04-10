package IntroToJava.main;

public class Student {

    private static int countStudents;
    private final String name;
    private final String surname;
    private final String family;
    private String course;
    private String specialty;
    private String university;
    private String mail;
    private long phoneNumber;

    Student(String name, String surname, String family, String course, String specialty, String university, String mail, long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.family = family;
        this.course = course;
        this.specialty = specialty;
        this.university = university;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        countStudents++;
    }

    Student(String name, String surname, String family) {
        this(name, surname, family, null, null, null, null, 0);
    }

    Student(String name, String surname, String family, String course, String specialty, String university) {
        this(name, surname, family, course, specialty, university, null, 0);
    }

    Student(String name, String surname, String family, String course, String specialty, String university, String mail) {
        this(name, surname, family, course, specialty, university, mail, 0);
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void  setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static int getCountStudents() {
        return countStudents; // don't use this
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                ", family='" + this.family + '\'' +
                ", course='" + this.course + '\'' +
                ", specialty='" + this.specialty + '\'' +
                ", university='" + this.university + '\'' +
                ", mail='" + this.mail + '\'' +
                ", phoneNumber=" + this.phoneNumber +
                '}';
    }
}
