package company.com.workoutdetail.models;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import company.com.workoutdetail.R;

public class WorkoutList {
    private static WorkoutList ourInstance = null;

    private List<Workout> workouts;
    private Context context;

    public static WorkoutList getInstance(Context context) {
        if (ourInstance == null) {
            return ourInstance = new WorkoutList(context);
        } else {
            return ourInstance;
        }
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    private WorkoutList(Context context) {
        this.context = context;

    }

    private void initWorkoutList() {
        workouts = new ArrayList<>();
        workouts.add(new Workout(context, R.string.pushups, R.string.pushups_description, 0));
        workouts.add(new Workout(context, R.string.pullups, R.string.pullups_description, 0));
        workouts.add(new Workout(context, R.string.twist_on_the_floor, R.string.twist_on_the_floor_description, 0));
        workouts.add(new Workout(context, R.string.twisting_with_turning, R.string.twisting_with_turning_description, 0));
        workouts.add(new Workout(context, R.string.twisting_on_the_bench, R.string.twisting_on_the_bench_description, 0));
        workouts.add(new Workout(context, R.string.twisting_on_the_block, R.string.twisting_on_the_block_description, 0));
        workouts.add(new Workout(context, R.string.lateral_twisting, R.string.lateral_twisting_description, 0));
        workouts.add(new Workout(context, R.string.back_torsion, R.string.back_torsion_description, 0));

    }

    private void addWorkout(Workout workout) {
        workouts.add(workout);
    }

}
