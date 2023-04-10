package DefiningClasses.lab._02_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String END = "End";
    private static final String CREATE = "Create";
    private static final String DEPOSIT = "Deposit";
    private static final String SET_INTEREST = "SetInterest";
    private static final String GET_INTEREST = "GetInterest";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> allAccounts = new HashMap<>();
        BankAccount searchAccount;
        int searchId;
        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String command = input.split("\\s+")[0];

            switch (command) {
                case CREATE:
                    BankAccount bankAccount = new BankAccount();
                    allAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created\n", bankAccount.getId());
                    break;
                case DEPOSIT:
                    searchId = Integer.parseInt(input.split("\\s+")[1]);
                    double amount = Double.parseDouble(input.split("\\s+")[2]);
                    searchAccount = allAccounts.get(searchId);
                    if (searchAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        searchAccount.deposit(amount);
                        System.out.printf("Deposited %d to ID%d\n", (int) amount, searchAccount.getId());
                    }

                    break;
                case SET_INTEREST:
                    double interest = Double.parseDouble(input.split("\\s+")[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case GET_INTEREST:
                    searchId = Integer.parseInt(input.split("\\s+")[1]);
                    int years = Integer.parseInt(input.split("\\s+")[2]);
                    searchAccount = allAccounts.get(searchId);
                    if (searchAccount == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f\n", searchAccount.getInterest(years));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
