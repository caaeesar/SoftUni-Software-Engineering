package Encapsulation.lab.FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        if (salary > 460.00) {
            this.salary = salary;
        } else {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
    }

    public void setFirstName(String firstName) {
        if (isValidName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
    }

    public void setLastName(String lastName) {
        if (isValidName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalStateException("Last name cannot be less than 3 symbols");
        }
    }

    private boolean isValidName(String name) {
        return name.length() > 3;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
    }

    public void increaseSalary(double percentBonus) {
        double bonus = this.getAge() < 30 ? percentBonus / 2 : percentBonus;
        this.salary += (this.salary * (bonus / 100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}

