package com.qa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExercisesForWorkout {
	
	@Id
	@GeneratedValue
	private int id;
	
//	@ManyToOne
//	private Exercise exercise;
	
	private BigDecimal weight;
	
	private int sets;
	
	private int totalReps;
	
	private BigDecimal repsPerSet;
	
	private String exerciseName;
	
	public void setAll(ExercisesForWorkout newExercise) {
		this.weight = newExercise.weight;
		this.sets = newExercise.sets;
		this.totalReps = newExercise.totalReps;
		this.setRepsPerSet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Exercise getExercise() {
//		return exercise;
//	}
//
//	public void setExercise(Exercise exercise) {
//		this.exercise = exercise;
//	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getTotalReps() {
		return totalReps;
	}

	public void setTotalReps(int totalReps) {
		this.totalReps = totalReps;
	}
	
	public BigDecimal getRepsPerSet() {
		return repsPerSet;
	}
	
	public void setRepsPerSet() {
		this.repsPerSet = BigDecimal.valueOf(this.totalReps)
				.divide(BigDecimal.valueOf(this.sets));
	}
	
	public String getExerciseName() {
		return exerciseName;
	}
	
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

}
