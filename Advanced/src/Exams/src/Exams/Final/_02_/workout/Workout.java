package Exams.Final._02_.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise searchExercise = null;
        int maxCalories = Integer.MIN_VALUE;
        for (Exercise exercise : exercises) {
            if (exercise.getBurnedCalories() >= maxCalories) {
                maxCalories = exercise.getBurnedCalories();
                searchExercise = exercise;
            }
        }
        return searchExercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("Workout type: %s", this.type));
        statistics.append(System.lineSeparator());
        for (Exercise exercise : exercises) {
            statistics.append(String.format("Exercise: %s", exercise.getName()));
            statistics.append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }

}
