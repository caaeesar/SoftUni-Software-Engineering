package others.humans;

public class Worker extends Human implements Comparable<Worker>{
    double salary;
    int hours;

    public Worker(String name, String surname, double salary) {
        super(name,surname);
        this.salary = salary;
    }
   public Worker(String name, String surname, double salary, int hours) {
        super(name, surname);
        this.salary = salary;
        this.hours = hours;
    }
    public double getSalary() {
        return this.salary;
    }

    // individual method for subclasses Worker (not visible for Human)
    public double calculationHourlyWage() {
       return this.salary / this.hours;
    }

    @Override
    public int compareTo(Worker worker) {
       return Double.compare(this.salary, worker.salary);
    }

    @Override
    public String toString() {
        return String.format("%s %.0f", this.name, this.salary);
    }
}
