package ForLoop.moreExercise;

public class Clock {
    public static void main(String[] arguments) {
        //    | стъпка      || стъпка    |V стъпка
        for (int hours = 0; hours <= 23; hours++) {
            //                    1-ва стъпка    2-ра стъпка    4-та стъпка
            /* ||| стъпка */ for (int minutes = 0; minutes <= 59; minutes++) {

          /*  3-та стъпка */   System.out.printf("%d : %d\n", hours, minutes);
            }
        }
    }
}
