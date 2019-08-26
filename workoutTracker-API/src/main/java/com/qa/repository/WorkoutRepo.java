package com.qa.repository;

import java.util.List;
import java.util.Set;

import com.qa.model.Exercise;
import com.qa.model.User;
import com.qa.model.Workout;

public interface WorkoutRepo {
	
	public User addWorkout(Workout w, int id);
	
	public Workout findWorkout(int id);
	
	public List<Workout> findWorkoutByUser(int id);
	
	public Workout changeWorkout(int id, Workout newWorkout);
	
	public Workout addExercises(int id, Set<Exercise> exercises);
	
	public void deleteWorkout(int id);
}
