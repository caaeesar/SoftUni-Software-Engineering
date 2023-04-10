package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceSidesUsers = new LinkedHashMap<>();
        String forceSide = "";
        String forceUser = "";

        String input = scanner.nextLine();
        while (!"Lumpawaroo".equals(input)) {

            if (input.contains("|")) {
                String[] parts = input.split(" \\| ");
                forceSide = parts[0];
                forceUser = parts[1];

                List<String> currentsUsersList = forceSidesUsers.get(forceSide);
                if (currentsUsersList == null) {

                    currentsUsersList = new ArrayList<>();
                    currentsUsersList.add(forceUser);
                    forceSidesUsers.put(forceSide, currentsUsersList);
                } else {

                    boolean isExistUser = false;
                    for (List<String> entry : forceSidesUsers.values()) {
                        if (entry.contains(forceUser)) {
                            isExistUser = true;
                            break;
                        }
                    }
                    if (!isExistUser) {
                        currentsUsersList.add(forceUser);
                    }
                }

            } else if (input.contains("->")) {
                String[] parts = input.split(" -> ");
                forceUser = parts[0];
                forceSide = parts[1];

                String finalForceUser = forceUser;
                forceSidesUsers.entrySet().forEach(entry -> entry.getValue().remove(finalForceUser));

                if (!forceSidesUsers.containsKey(forceSide)) {
                    forceSidesUsers.put(forceSide, new ArrayList<>());

                }
                List<String> currentList = forceSidesUsers.get(forceSide);
                currentList.add(forceUser);
                forceSidesUsers.put(forceSide, currentList);
                System.out.printf("%s joins the %s side!\n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }
        forceSidesUsers.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d\n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(user -> System.out.printf("! %s\n", user));
                });

       /* String command = scanner.nextLine();
        String forceSide = "";
        String forceUser = "";
        Map<String, List<String>> sidesUsers = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(command)) {

            if (command.contains("|")) {
                String[] input = command.split("\\|");
                forceSide = input[0].trim();
                forceUser = input[1].trim();

                List<String> currentUsersList = sidesUsers.get(forceSide);
                // If there is no such force user and no such force side
                if (!sidesUsers.containsKey(forceSide) && currentUsersList == null) {
                    currentUsersList = new ArrayList<>();
                    currentUsersList.add(forceUser);
                    sidesUsers.put(forceSide, currentUsersList);
                } else { // if there is no such force user in any force side
                    boolean isHaveUser = false;
                    for (Map.Entry<String, List<String>> entry : sidesUsers.entrySet()) {
                        if (entry.getValue().contains(forceUser)) {
                            isHaveUser = true;
                            break;
                        }
                    }
                    if (!isHaveUser) { // if there is no such force user in any force side
                        currentUsersList.add(forceUser);
                        sidesUsers.put(forceSide, currentUsersList);
                    }
                }
            } else if (command.contains("->")) {
                String[] input = command.split("->");
                forceUser = input[0].trim();
                forceSide = input[1].trim();
                boolean isHaveUser = false;
                String existedUser = "";
                String currentSide = "";

                for (Map.Entry<String, List<String>> entry : sidesUsers.entrySet()) {

                    if (entry.getValue().contains(forceUser)) {
                        isHaveUser = true;
                        currentSide = entry.getKey();
                        existedUser = forceUser;
                        break;
                    }

                }
                List<String> currentUsersList = sidesUsers.get(forceSide);
                if (isHaveUser) { //If there is such force user already

                    // if there is no side
                    if (!sidesUsers.containsKey(forceSide)) {
                        currentUsersList = new ArrayList<>();
                        currentUsersList.add(forceUser);
                        sidesUsers.put(forceSide, currentUsersList);
                        List<String> listForChange = sidesUsers.get(currentSide);
                        listForChange.remove(existedUser);
                        sidesUsers.remove(currentSide, listForChange);
                    } else { // if there is the side
                        currentUsersList.add(forceUser);
                        sidesUsers.put(forceSide, currentUsersList);
                        List<String> listForChange = sidesUsers.get(currentSide);
                        listForChange.remove(existedUser);
                        sidesUsers.remove(currentSide, listForChange);
                    }
                } else if (sidesUsers.containsKey(forceSide)) { // If there is no such force user in any force side
                    currentUsersList.add(forceUser);
                    sidesUsers.put(forceSide, currentUsersList);
                } else { // If there is no such force user and no such force side
                    currentUsersList = new ArrayList<>();
                    currentUsersList.add(forceUser);
                    sidesUsers.put(forceSide, currentUsersList);
                }
                if (!currentSide.equals(forceSide)) {
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : sidesUsers.entrySet()) {

            if (entry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                for (String currentUser : entry.getValue()) {
                    System.out.printf("! %s%n", currentUser);
                }
            }
        }*/
    }
}


