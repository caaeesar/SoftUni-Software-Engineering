package ObjectsAndClasses.moreExercise;

import java.util.*;

import static java.util.Collections.*;

public class TeamworkProjects2 {
//todo 33/100
    static class Team {

        private String teamName;
        private String creator;
        private List<String> members;

        Team(String creator, String teamName) {
            this.creator = creator;
            this.teamName = teamName;
            this.members = new ArrayList<>();
        }

        public String getCreator() {
            return this.creator;
        }

        public List<String> getMembers() {
            return this.members;
        }

        public void setMembers(String member) {
            this.members.add(member);
        }

        public int getNumberOfMembers() {
           return this.members.size();
        }

    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // СЪЗДАВАНЕ НА ОТБОРИТЕ
        int numberOfTeams = Integer.parseInt(scanner.nextLine());
        Map<String, Team> teamMap = new TreeMap<>();

        for (int currentTeam = 1; currentTeam <= numberOfTeams; currentTeam++) {

            String line = scanner.nextLine();
            String[] information = line.split("-");
            String creator = information[0];
            String teamName = information[1];

            Team occurrenceTeam = new Team(creator, teamName);

            if (teamMap.get(teamName) != null) { // отборът вече е създаден
                System.out.printf("Team %s was already created!%n", teamName);
                if (teamMap.get(teamName).getCreator().contains(creator)) { // създател на отбор не може да създава други отбори
                    System.out.printf("%s cannot create another team!%n", creator);
                }
            } else { // отборът не е създаден
                teamMap.put(teamName, occurrenceTeam);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            }
        }

        //ВПИСВАНЕ В ОТБОР
        String line = scanner.nextLine();
        while (!"end of assignment".equals(line)) {
            String[] information = line.split("->");
            String participant = information[0];
            String requestedTeamName = information[1];
            boolean isMember = false;

            if (!teamMap.containsKey(requestedTeamName)) { // несъществуващ отбор
                System.out.printf("Team %s does not exist!%n", requestedTeamName);
            } else { // съществуващ отбор

                if (teamMap.get(requestedTeamName).getCreator().equals(participant)) { // ако участникът е лидер
                    System.out.printf("Member %s cannot join team %s!%n", participant, requestedTeamName);
                } else { // ако участникът не е лидер...
                    // той не трябва да бъде член на друг отбор, за да се присъедини
                    for (Map.Entry<String, Team> currentTeam : teamMap.entrySet()) {
                        if (currentTeam.getValue().getMembers().contains(participant)) {
                            isMember = true;
                            break;
                        }
                    }
                    if (!isMember) { // ако не е член го записваме в списъка на отбора, в който иска да се запише
                        teamMap.get(requestedTeamName).setMembers(participant);
                    } else {
                        System.out.printf("Member %s cannot join team %s!%n", participant, requestedTeamName);
                    }
                }
            }
            line = scanner.nextLine();
        }

        // ПЕЧАТАНЕ НА ОТБОРИТЕ
        // ако в някой отбор няма членове
        // сортиране по брой членове - > ако в някой отбор има равен брой членове се сравнява по азбучен ред
        // сортиране на имената на членовете на всеки отбор
        for (Map.Entry<String, Team> currentTeam : teamMap.entrySet()) {
            
            if (currentTeam.getValue().getMembers().size() != 0) {
                System.out.println(currentTeam.getKey());
                System.out.printf("- %s%n", currentTeam.getValue().getCreator());
            }
            for (int i = 0; i < currentTeam.getValue().getMembers().size(); i++) {
                //трябва да се сравнят имената на членовете по възходящ ред

                System.out.printf("-- %s%n", currentTeam.getValue().getMembers().get(i));
            }
        }
        System.out.println("Teams to disband:");
        for (Map.Entry<String, Team> currentTeam : teamMap.entrySet()) {

            if (currentTeam.getValue().getMembers().isEmpty()) {
                System.out.print(currentTeam.getKey());
            }
        }

    }
}
