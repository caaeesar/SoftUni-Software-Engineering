package DefiningClasses.lab._02_BankAccount;

public class BankAccount {
    private int id;
    private static int countAccount = 0;
    private double balance;
    private static double DEFAULT_INTEREST_RATE = 0.02;

    public BankAccount() {
        this.id = ++countAccount;
    }

    public static void setInterestRate(double interest) {
        DEFAULT_INTEREST_RATE = interest;
    }

    public double getInterest(int years) {
       return DEFAULT_INTEREST_RATE * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
