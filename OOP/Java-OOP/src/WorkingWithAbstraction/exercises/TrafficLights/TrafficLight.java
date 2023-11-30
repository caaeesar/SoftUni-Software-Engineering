package WorkingWithAbstraction.exercises.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrafficLight {

    enum Signal {
        RED,
        YELLOW,
        GREEN
    }

    private List<Signal> signals;

    public TrafficLight(Signal... signals) {
        this.signals = new ArrayList<>(Arrays.asList(signals));
    }

    public void changeSignal(int times) {

        while (times-- > 0) {

            for (int i = 0; i < this.signals.size(); i++) {

                Signal signal = signals.get(i);
                switch (signal) {
                    case RED:
                        signal = Signal.GREEN;
                        break;
                    case GREEN:
                        signal = Signal.YELLOW;
                        break;
                    case YELLOW:
                        signal = Signal.RED;
                        break;
                }
                this.signals.set(i, signal);
            }

            printSignals();
        }
    }

    private void printSignals() {
        for (Signal signal : this.signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }

}
