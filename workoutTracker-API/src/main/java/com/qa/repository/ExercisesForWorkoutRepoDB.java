package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Exercise;
import com.qa.model.ExercisesForWorkout;
import com.qa.model.Workout;

public class ExercisesForWorkoutRepoDB implements ExercisesForWorkoutRepo {
	
	@PersistenceContext(unitName = "myPU")
	EntityManager em;
	
	ExerciseRepo er;
	
	@Transactional(value = TxType.REQUIRED)
	public Exercise addExercise(ExercisesForWorkout efw, String exerciseName) {
		Exercise exercise = er.readExercise(exerciseName);
		exercise.addExercises(efw);
		return exercise;
	}

	@Transactional(value = TxType.REQUIRED)
	public Workout addExerciseToWorkout(ExercisesForWorkout efw, int id, String exerciseName) {
		Workout workout = em.find(Workout.class, id);
		addExercise(efw, exerciseName);
		workout.addExercises(efw);
		return workout;
	}

	public ExercisesForWorkout findExercise(int id) {
		ExercisesForWorkout efw = em.find(ExercisesForWorkout.class, id);
		return efw;
	}

	public List<ExercisesForWorkout> findExerciseByWorkout(int id) {
		TypedQuery<ExercisesForWorkout> tq = em
				.createQuery("Select efw from ExercisesForWorkout efw where workout_id = '" + id + "'", ExercisesForWorkout.class);
		List<ExercisesForWorkout> efw  = tq.getResultList();
		return efw;
	}

	@Transactional(value =  TxType.REQUIRED)
	public ExercisesForWorkout changeExerciseDetails(int id, ExercisesForWorkout newExercise) {
		ExercisesForWorkout efw = findExercise(id);
		efw.setAll(newExercise);
		return efw;
	}

	@Transactional(value = TxType.REQUIRED)
	public void removeExercise(int id) {
		em.remove(findExercise(id));
	}
	
}
