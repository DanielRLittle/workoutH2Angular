package com.qa.repository;

import java.util.List;

import com.qa.model.ExercisesForWorkout;
import com.qa.model.Workout;

public interface ExercisesForWorkoutRepo {
	
	public Workout addExercise(ExercisesForWorkout e, int id);
	
	public ExercisesForWorkout findExercise(int id);
	
	public List<ExercisesForWorkout> findExerciseByWorkout(int id);
	
	public ExercisesForWorkout changeExerciseDetails(int id, ExercisesForWorkout newExercise);
	
	public void removeExercise(int id);

}
