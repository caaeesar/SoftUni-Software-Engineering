package core;

import exercises.*;

import java.sql.SQLException;
import java.util.Scanner;

import static common.ErrorMessages.INVALID_EX_NAME;
import static common.ExerciseName.*;
import static common.PromptMessages.ENTER_EXERCISE;

public class EngineImpl implements Engine {
    private Exercise exercise;
    private Executor executor;

    @Override
    public void run() {
        try {
            this.exercise = createExercise();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        this.executor = new Executor(exercise);
        try {
            this.executor.executeExercise();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        executor.printResult();
    }

    private static Exercise createExercise() throws SQLException {
        System.out.println(ENTER_EXERCISE);
        String name = new Scanner(System.in).nextLine();

        switch (name) {
            case EX_02:
                return new GetVillainsNames();
            case EX_03:
                return new GetMinionNames();
            case EX_04:
                return new AddMinion();
            case EX_05:
                return new ChangeTownNamesCasing();
            case EX_06:
                return new RemoveVillain();
            case EX_07:
                return new PrintAllMinionNames();
            case EX_08:
                return new IncreaseMinionsAge();
            case EX_09:
                return new IncreaseAgeStoredProcedure();
        }
        throw new IllegalArgumentException(String.format(INVALID_EX_NAME, name));
    }
}
