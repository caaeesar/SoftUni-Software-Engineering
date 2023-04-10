package ObjectsAndClasses.moreExercise.teamworkProjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//todo 50/100
public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Team> allTeams = new ArrayList<>();
        int countOfTeams = Integer.parseInt(scanner.nextLine());

        //регистриране:
        for (int currentLine = 1; currentLine <= countOfTeams; currentLine++) {

            String[] teamDate = scanner.nextLine().trim().split("-");
            String creator = teamDate[0];
            String teamName = teamDate[1];
            Team team = new Team(creator, teamName);

            if (allTeams.isEmpty()) { // ако няма никакви регистрирани отбори
                System.out.printf("Team %s has been created by %s!\n", teamName, creator);
                allTeams.add(team);
            } else { // има регистрирани отбори
                boolean isExistCreator = false;
                for (Team currentTeam : allTeams) {

                    // ако user-а е създал вече отбор:
                    if (currentTeam.getCreator().equals(creator)) {
                        isExistCreator = true;
                        System.out.printf("%s cannot create another team!\n", creator);
                        break;
                    }
                }
                if (!isExistCreator) { // ако user-а не е създавал досега отбор
                    boolean isExistTeam = false;
                    for (Team currentTeam : allTeams) {

                        // проверяваме дали вече има създаден отбор с такова име
                        if (currentTeam.getTeamName().equals(teamName)) {
                            isExistTeam = true;
                            System.out.printf("Team %s was already created!\n", teamName);
                            break;
                        }
                    }
                    if (!isExistTeam) { // добавяме отбора, ако той не съществува
                        System.out.printf("Team %s has been created by %s!\n", teamName, creator);
                        allTeams.add(team);
                    }
                }
            }
        }

        //вписване:
        String input = scanner.nextLine();
        while (!"end of assignment".equals(input)) {

            String[] information = input.split("->");
            String user = information[0];
            String teamName = information[1];

            boolean isExistTeam = false;
            for (Team currentTeam : allTeams) {

                if (currentTeam.getTeamName().equals(teamName)) {
                    isExistTeam = true;
                    // ако този отбор няма никакви членове:
                    if (currentTeam.getMembersList() == null) {
                        List<String> membersList = new ArrayList<>(); // empty
                        currentTeam.setMemberList(membersList);
                        if (!currentTeam.getCreator().equals(user)) {
                            membersList.add(user);
                        } else {
                            System.out.printf("Member %s cannot join team %s!\n", user, teamName);
                        }
                    } else { // ако има членове, проверяваме дали user-а е вписан в листа на всички отбори, които имат членове
                        boolean isExistMember = false;
                        for (Team team : allTeams) {
                            if (team.getMembersList() == null || team.getMembersList().size() == 0) {
                                continue;
                            }
                                for (String currentMember : team.getMembersList()) {
                                    if (currentMember.equals(user)) {
                                        isExistMember = true;
                                        System.out.printf("Member %s cannot join team %s!\n", user, teamName);
                                        break;
                                    }
                                }
                            }
                        List<String> currentMemberList = currentTeam.getMembersList();
                        if (!isExistMember && !currentTeam.getCreator().equals(user)) {
                            currentMemberList.add(user);
                        }
                    }
                }
            }
            if (!isExistTeam) {
                System.out.printf("Team %s does not exist!\n", teamName);
            }
            input = scanner.nextLine();
        }

        // намиране дисквалифицираните отбори:
        List<Team> disbandTeams = new ArrayList<>();
        for (int i = 0; i < allTeams.size(); i++) {
            Team currentTeam = allTeams.get(i);

            if (currentTeam.getMembersList() == null || currentTeam.getMembersList().size() == 0) {
                disbandTeams.add(currentTeam);
                allTeams.remove(currentTeam);
            }
        }
        List<Team> sortedDisbandTeam = new ArrayList<>();
        if (!disbandTeams.isEmpty()) {
            sortedDisbandTeam = disbandTeams.stream().sorted(Comparator.comparing(Team::getTeamName)).collect(Collectors.toList());
        }

        List<Team> sortedTeams = new ArrayList<>();
        if (!allTeams.isEmpty()) {
            sortedTeams = allTeams.stream().sorted(Comparator.comparing(Team::getMembersCount).reversed().thenComparing(Team::getTeamName)).collect(Collectors.toList());
        }

    /*    List<Team> sortedTeams = allTeams.stream().sorted((t1, t2) -> {
            int x = Integer.compare(t2.getMembersList().size(), t1.getMembersList().size());
            if (x == 0) {
                x = t1.getTeamName().compareTo(t2.getTeamName());
            }
            return x;
        }).collect(Collectors.toList());*/

        for (Team currentTeam : sortedTeams) {
            System.out.println(currentTeam);

            for (String currentMember : currentTeam.getMembersList()) {
                System.out.printf("-- %s\n", currentMember);
            }
        }

        System.out.println("Teams to disband:");
        if (!sortedDisbandTeam.isEmpty()) {
            for (Team currentDisbandTeam : sortedDisbandTeam) {
                System.out.println(currentDisbandTeam.getTeamName());
            }
        }
    }
}
