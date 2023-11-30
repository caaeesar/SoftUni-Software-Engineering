package InterfacesAndAbstraction.exercises.MilitaryElite;
//todo
import InterfacesAndAbstraction.exercises.MilitaryElite.Implementations.*;

import java.util.*;

public class Main {

    public static final String STOP_COMMAND = "End";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, PrivateImpl> idPrivateSoldier = new HashMap<>();

        String input = scanner.nextLine();

        while (!STOP_COMMAND.equals(input)) {

            String[] data = input.split("\\s+");
            String soldierType = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];
            double salary;
            String corp;

            switch (soldierType) {

                case "Private":
                    salary = Double.parseDouble(data[4]);
                    PrivateImpl privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    idPrivateSoldier.put(id, privateSoldier);
                    System.out.println(privateSoldier);
                    break;

                case "LieutenantGeneral":
                    salary = Double.parseDouble(data[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    addPrivateSoldiers(idPrivateSoldier, data, lieutenantGeneral);
                    System.out.println(lieutenantGeneral);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(data[4]);
                    corp = data[5];
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corp);
                        createAndAddRepairs(data, engineer);
                        System.out.println(engineer);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Commando":
                    salary = Double.parseDouble(data[4]);
                    corp = data[5];
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corp);
                        createAndAddMissions(data, commando);
                        System.out.println(commando);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Spy":
                    String codeNumber = data[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.println(spy);
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void createAndAddMissions(String[] data, CommandoImpl commando) {
        for (int i = 6; i < data.length; i += 2) {
            String codeName = data[i];
            String state = data[i + 1];
            try {
                Mission mission = new Mission(codeName, state);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void createAndAddRepairs(String[] data, EngineerImpl engineer) {
        for (int i = 6; i < data.length; i += 2) {
            String partName = data[i];
            int workedHours = Integer.parseInt(data[i + 1]);
            RepairImpl repairImpl = new RepairImpl(partName, workedHours);
            engineer.addRepair(repairImpl);
        }
    }

    private static void addPrivateSoldiers(Map<Integer, PrivateImpl> idPrivateSoldier, String[] data, LieutenantGeneralImpl lieutenantGeneral) {
        for (int i = 5; i < data.length; i++) {
            int currentId = Integer.parseInt(data[i]);
            lieutenantGeneral.addPrivate(idPrivateSoldier.get(currentId));
        }
    }
}


