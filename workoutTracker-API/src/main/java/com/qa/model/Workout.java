package com.qa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue
	private int id;
	private String workoutName;
	private String workoutDescription;
	private LocalDate workoutDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkoutName() {
		return this.workoutName;
	}
	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	public String getWorkoutDescription() {
		return this.workoutDescription;
	}
	public void setWorkoutDescription(String workoutDescription) {
		this.workoutDescription = workoutDescription;
	}
	
	public void setAll(Workout newWorkout) {
		this.workoutName = newWorkout.workoutName;
		this.workoutDescription = newWorkout.workoutDescription;
	}
	
	public LocalDate getWorkoutDate() {
		return this.workoutDate;
	}
	
	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}
	
}
