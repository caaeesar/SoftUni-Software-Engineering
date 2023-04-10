package MapsLambdaStreamAPI.moreExercise;

import java.util.*;

public class MOBAChallenger {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  String command = scanner.nextLine();
         *           key              value
         *           player    position - skill
         *         Map<String, Map<String, Integer>> playerPool = new HashMap<>();
         *                      key    value
         *         while (!"Season end".equals(command)) {
         *
         *             if (command.contains("vs")) {
         *
         *                 String[] information = command.split("vs");
         *                 String firstPlayer = information[0].trim();
         *                 String secondPlayer = information[1].trim();
         *
         *                 if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)) {
         *
         *                     Map<String, Integer> firstPlayerInformation = playerPool.get(firstPlayer);
         *                     Map<String, Integer> secondPlayerInformation = playerPool.get(secondPlayer);
         *
         *                     for (String position1 : firstPlayerInformation.keySet()) {
         *
         *                         for (String position2 : secondPlayerInformation.keySet()) {
         *
         *                             if (position1.equals(position2)) {
         *                                 if (playerPool.get(firstPlayer).values().stream().mapToInt(i -> i).sum()
         *                                         > playerPool.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
         *                                     playerPool.remove(secondPlayer);
         *                                 } else if (playerPool.get(secondPlayer).values().stream().mapToInt(i -> i).sum()
         *                                         > playerPool.get(firstPlayer).values().stream().mapToInt(i -> i).sum()) {
         *                                     playerPool.remove(firstPlayer);
         *                                 }
         *                             }
         *                         }
         *                     }
         *                 }
         *             } else {
         *                 String[] input = command.split("->");
         *                 String player = input[0].trim();
         *                 String position = input[1].trim();
         *                 int skill = Integer.parseInt(input[2].trim());
         *
         *                 Map<String, Integer> existPositionsAndSkills = playerPool.get(player);
         *                 if (!playerPool.containsKey(player)) {
         *
         *                     existPositionsAndSkills = new HashMap<>();
         *                     existPositionsAndSkills.put(position, skill);
         *                     playerPool.put(player, existPositionsAndSkills);
         *                 } else {
         *
         *                     if (existPositionsAndSkills.containsKey(position)) {
         *                         int currentSkill = existPositionsAndSkills.get(position);
         *                         if (currentSkill < skill) {
         *                             existPositionsAndSkills.put(position, skill);
         *                             playerPool.put(player, existPositionsAndSkills);
         *                         }
         *                     } else {
         *                         // add new position for this player
         *                         existPositionsAndSkills.put(position, skill);
         *                         playerPool.put(player, existPositionsAndSkills);
         *                     }
         *                 }
         *             }
         *             command = scanner.nextLine();
         *         }
         *
         *         playerPool.entrySet().stream().sorted((p1, p2) -> {
         *             int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
         *                     p1.getValue().values().stream().mapToInt(i -> i).sum());
         *             if (result == 0) {
         *                 result = p1.getKey().compareTo(p2.getKey());
         *             }
         *             return result;
         *         }).forEach(element -> {
         *             System.out.printf("%s: %d skill%n", element.getKey(), element.getValue().values().stream().mapToInt(i -> i).sum());
         *             element.getValue().entrySet().stream().sorted((p1, p2) -> {
         *
         *                 int result = p2.getValue().compareTo(p1.getValue());
         *                 if (result == 0) {
         *                     result = p1.getKey().compareTo(p2.getKey());
         *                 }
         *                 return result;
         *             }).forEach(e -> {
         *                 System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
         *             });
         *         });
         */


        //player // position, skill
        Map<String, Map<String, Integer>> playerPool = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Season end".equals(input)) {

            if (input.contains("->")) {
                String[] date = input.split(" -> ");
                String player = date[0];
                String position = date[1];
                int skill = Integer.parseInt(date[2]);

                Map<String, Integer> currentPlayerInfo = playerPool.get(player);
                if (currentPlayerInfo == null) {
                    currentPlayerInfo = new HashMap<>();
                }

                Integer currentSkill = currentPlayerInfo.get(position);
                if (currentSkill == null) {
                    currentSkill = 0;
                }

                if (currentSkill > skill) {
                    input = scanner.nextLine();
                    continue;
                }

                currentPlayerInfo.put(position, skill);
                playerPool.put(player, currentPlayerInfo);

            } else if (input.contains("vs")) {
                String[] playersInfo = input.split(" vs ");
                String firstPlayer = playersInfo[0];
                String secondPlayer = playersInfo[1];

                if (playerPool.containsKey(firstPlayer) &&
                        playerPool.containsKey(secondPlayer)) {

                    Map<String, Integer> firstPlayerInfo = playerPool.get(firstPlayer);
                    Map<String, Integer> secondPlayerInfo = playerPool.get(secondPlayer);

                    // boolean isHaveCommonPosition = false;

                    for (String position1 : firstPlayerInfo.keySet()) {

                        for (String position2 : secondPlayerInfo.keySet()) {

                            if (position1.equals(position2)) {

                                int firstPlayerTotalPoint = firstPlayerInfo.values()
                                        .stream()
                                        .mapToInt(Integer::intValue)
                                        .sum();

                                int secondPlayerTotalPoint = secondPlayerInfo.values()
                                        .stream()
                                        .mapToInt(Integer::intValue)
                                        .sum();

                                if (firstPlayerTotalPoint > secondPlayerTotalPoint) {
                                    playerPool.remove(secondPlayer);
                                } else if (secondPlayerTotalPoint > firstPlayerTotalPoint) {
                                    playerPool.remove(firstPlayer);
                                }
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        playerPool.entrySet().stream().sorted((player1, player2) -> {

            int result = Integer.compare(player2.getValue().values().stream().mapToInt(Integer::intValue).sum(),
                    player1.getValue().values().stream().mapToInt(Integer::intValue).sum());

            if (result == 0) {
                result = player1.getKey().compareTo(player2.getKey());
            }
            return result;
        }).forEach(player -> {
            System.out.printf("%s: %d skill\n", player.getKey(),
                    player.getValue().values().stream().mapToInt(Integer::intValue).sum());
            player.getValue().entrySet().stream().sorted((c1, c2) -> {
                int result = Integer.compare(c2.getValue(), c1.getValue());

                if (result == 0) {
                    result = c1.getKey().compareTo(c2.getKey());
                }
                return result;
            }).forEach(position -> {
                System.out.printf("- %s <::> %d\n", position.getKey(), position.getValue());
            });
        });
    }
}
