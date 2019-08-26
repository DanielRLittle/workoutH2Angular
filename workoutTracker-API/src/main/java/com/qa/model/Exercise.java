package com.qa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue
	private int id;
	private String exerciseName;
	
	@ManyToMany(mappedBy = "exercises")
	private Set<Workout> workouts;
	
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
	
}
	