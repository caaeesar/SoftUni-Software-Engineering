package ObjectsAndClasses.moreExercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeamworkProjects {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 50/100
        // СЪЗДАВАНЕ НА ОТБОРИТЕ
        int numberOfTeams = Integer.parseInt(scanner.nextLine());
        //teamName,leader
        Map<String, String> teamLeader = new TreeMap<>();

        for (int currentTeam = 1; currentTeam <= numberOfTeams; currentTeam++) {

            String[] information = scanner.nextLine().split("-");
            String leader = information[0];
            String teamName = information[1];

            if (teamLeader.containsValue(leader)) { // ако някой лидер се опита да създане друг отбор или същия
                System.out.printf("%s cannot create another team!%n", leader);
            } else if (!teamLeader.containsKey(teamName)) { // ако не съществува такъв отбор го записваме
                teamLeader.put(teamName, leader);
                System.out.printf("Team %s has been created by %s!%n", teamName, leader);
            } else { // ако вече съществува изписваме съобщението
                System.out.printf("Team %s was already created!%n", teamName);
            }
        }

        //ВПИСВАНЕ В ОТБОР
        //teamName, members
        Map<String, List<String>> teamMembers = new TreeMap<>();
        String line = scanner.nextLine();
        while (!"end of assignment".equals(line)) {
            String[] information = line.split("->");
            String participant = information[0];
            String currentTeamName = information[1];

            if (!teamLeader.containsKey(currentTeamName)) { // ако някой иска да се присъедини към несъществуващ отбор
                System.out.printf("Team %s does not exist!%n", currentTeamName);
            } else { // ако някой иска да се присъедини към някой същ. отбор
                // той не трябва да е член на друг отбор
                if (!(participant.equals(teamLeader.get(currentTeamName)))) { // ако участникът не е лидер
                    // ако участникът не e член в друг отбор
                    List<String> currentMembers = teamMembers.get(currentTeamName);
                    if (currentMembers != null) {
                        if (!currentMembers.contains(participant)) { // ako участникът не e член в друг отбор
                            currentMembers.add(participant);
                        } else { // ако е член в друг отбор изписваме съобщението
                            System.out.printf("Member %s cannot join team %s!%n", participant, currentTeamName);
                        }
                    } else {
                        currentMembers = new ArrayList<>();
                        currentMembers.add(participant);
                        teamMembers.put(currentTeamName, currentMembers);
                    }
                } else { // ако участникът е лидер
                    System.out.printf("Member %s cannot join team %s!%n", participant, currentTeamName);
                }
            }
            line = scanner.nextLine();
        }
        // ПЕЧАТАНЕ НА ОТБОРИТЕ
        // ако в някой отбор няма членове
        // сортиране по брой членове - > ако в някой отбор има равен брой членове се сравнява по азбучен ред
        // сортиране на имената на членовете на всеки отбор

        // todo must to be sorted
        for (Map.Entry<String, List<String>> entry : teamMembers.entrySet()) {

            if (entry.getValue().size() != 0) {
                System.out.println(entry.getKey());
                System.out.printf("- %s%n", teamLeader.get(entry.getKey()));
            }
        }
                //трябва да се сравнят имената на членовете по възходящ ред
       List<List<String>> sorted1 = teamMembers.entrySet().stream().sorted((t1, t2) -> {
            int sorted = Integer.compare(t2.getValue().size(), t1.getValue().size());
            if (sorted == 0) {
                sorted = t1.getKey().compareTo(t2.getKey());
            }
            return sorted;
        }).map(Map.Entry::getValue).collect(Collectors.toList());

        for (int i = 0; i < sorted1.size(); i++) {
            List<String> str = sorted1.get(i);
            System.out.printf("-- %s\n", str.get(i));
        }

        System.out.println("Teams to disband:");

    }
}

