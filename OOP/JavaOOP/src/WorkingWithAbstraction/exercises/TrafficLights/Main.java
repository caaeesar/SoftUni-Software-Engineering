package WorkingWithAbstraction.exercises.TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight.Signal[] signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight.Signal::valueOf)
                .toArray(TrafficLight.Signal[]::new);

        TrafficLight trafficLight = new TrafficLight(signals);

        int times = Integer.parseInt(scanner.nextLine());
        trafficLight.changeSignal(times);
    }
}
