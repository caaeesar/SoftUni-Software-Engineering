package ObjectsAndClasses.exercise;

import java.util.*;

public class OrderByAge {

    static class Customer {

        private String name;
        private String id;
        private int age;

        Customer(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    this.name, this.id, this.age
            );
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Customer> customersList = new ArrayList<>();
        String command = scanner.nextLine();

        while (!"End".equals(command)) {

            String[] customerInfo = command.split(" ");
            String name = customerInfo[0];
            String id = customerInfo[1];
            int age = Integer.parseInt(customerInfo[2]);

            Customer customer = new Customer(name, id, age);
            customersList.add(customer);
            command = scanner.nextLine();
        }

        customersList.stream().sorted(Comparator.comparing(Customer::getAge)).forEach(System.out::println);

       /* int[] ages = new int[customersList.size()];

        for (int i = 0; i < customersList.size(); i++) {
            Customer currentCustomer = customersList.get(i);
            ages[i] = currentCustomer.getAge();
        }
        // todo sorting -> my algorithm
        Arrays.sort(ages);
        int indexAge = 0;
        int indexCustomer = 0;
        while (!customersList.isEmpty()) {

            double currentAge = ages[indexAge];
            Customer currentCustomer = customersList.get(indexCustomer);

            if (currentCustomer.getAge() == currentAge) {

                System.out.println(currentCustomer);
                customersList.remove(currentCustomer);
                indexAge++;
                indexCustomer = 0;
            } else {
                indexCustomer++;
            }
        }*/
    }
}
