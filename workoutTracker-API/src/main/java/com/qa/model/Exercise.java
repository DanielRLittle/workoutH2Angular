package com.qa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue
	private int id;
	private String exerciseName;
	
	@OneToMany(mappedBy = "exercise")
	private Set<ExercisesForWorkout> exercisesForWorkouts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public void setAll(Exercise newExercise) {
		this.exerciseName = newExercise.exerciseName;
	}
	public Set<ExercisesForWorkout> getExercisesForWorkouts() {
		return exercisesForWorkouts;
	}
	public void setExercisesForWorkouts(Set<ExercisesForWorkout> exercisesForWorkouts) {
		this.exercisesForWorkouts = exercisesForWorkouts;
	}
	
	public Set<ExercisesForWorkout> addExercises(ExercisesForWorkout exercise) {
		exercisesForWorkouts.add(exercise);
		return exercisesForWorkouts;
	}
	
	public Set<ExercisesForWorkout> removeExercises(ExercisesForWorkout exercise) {
		exercisesForWorkouts.remove(exercise);
		return exercisesForWorkouts;
	}
	
}
	