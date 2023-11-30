package Encapsulation.exercises.FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String END = "END";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> allTeams = new HashMap<>();
        Team team = null;
        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String[] parts = input.split(";");
            String command = parts[0];
            String teamName = parts[1];
            team = allTeams.get(teamName);

            switch (command) {
                case "Encapsulation.lab.FirstAndReserveTeam.Team":
                    try {
                         team = new Team(teamName);
                        allTeams.put(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    if (team != null) {
                        try {
                            Player player = new Player(parts[2],
                                    Integer.parseInt(parts[3]),
                                    Integer.parseInt(parts[4]),
                                    Integer.parseInt(parts[5]),
                                    Integer.parseInt(parts[6]),
                                    Integer.parseInt(parts[7]));
                            team.addPlayer(player);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.printf("Encapsulation.lab.FirstAndReserveTeam.Team %s does not exist.\n", teamName);
                    }
                    break;
                case "Remove":
                    if (team != null) {
                        try {
                        team.removePlayer(parts[2]);
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.printf("Encapsulation.lab.FirstAndReserveTeam.Team %s does not exist.\n", teamName);
                    }
                    break;
                case "Rating":
                    if (team != null) {
                      System.out.printf("%s - %.0f\n",teamName,team.getRating());
                    } else {
                        System.out.printf("Encapsulation.lab.FirstAndReserveTeam.Team %s does not exist.\n", teamName);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
