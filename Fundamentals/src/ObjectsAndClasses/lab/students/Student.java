package ObjectsAndClasses.lab.students;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    Student(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getHomeTown() {
        return this.homeTown;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old",
                this.firstName,this.lastName,this.age);
    }
}
