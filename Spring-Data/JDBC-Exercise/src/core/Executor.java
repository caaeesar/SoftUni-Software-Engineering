package core;

import exercises.Exercise;

import java.sql.SQLException;

public class Executor implements Executable {
    private String output;
    private Exercise exercise;
    public Executor(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public void executeExercise() throws SQLException {
     this.output = exercise.execute();
    }
    public void printResult() {
        System.out.println(output);
    }
}
