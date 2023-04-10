package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> companiesEmployees = new LinkedHashMap<>();

        while (!"End".equals(command)) {

            String[] information = command.split(" -> ");
            String company = information[0];
            String employeeId = information[1];

            List<String> currentEmployeeIds = companiesEmployees.get(company);

            if (currentEmployeeIds == null) {
                currentEmployeeIds = new ArrayList<>();
                currentEmployeeIds.add(employeeId);
            } else {

                if (!currentEmployeeIds.contains(employeeId)) {
                    currentEmployeeIds.add(employeeId);
                }
            }
            companiesEmployees.put(company, currentEmployeeIds);
            command = scanner.nextLine();
        }

          /*companiesEmployees.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .forEach(company -> {
                            System.out.println(company.getKey());
                            company.getValue().forEach(employee -> System.out.println("-- " + employee));

                       });*/

        for (Map.Entry<String, List<String>> entry : companiesEmployees.entrySet()) {
            System.out.println(entry.getKey());
            for (String currentId : entry.getValue()) {
                System.out.printf("-- %s%n", currentId.trim());
            }
        }
    }
}
