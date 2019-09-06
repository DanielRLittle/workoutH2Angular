package com.qa.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.qa.model.Exercise;
import com.qa.model.ExercisesForWorkout;
import com.qa.model.Workout;
import com.qa.repository.ExerciseRepo;
import com.qa.repository.ExercisesForWorkoutRepo;
import com.qa.repository.WorkoutRepo;

@Path("/")
public class ExercisesForWorkoutEndPoints {

	@Inject
	ExercisesForWorkoutRepo efwr;
	
	@Inject
	WorkoutRepo wr;
	
	@Inject
	ExerciseRepo er;
	
	public Response checkExercise(int id) {
		if (efwr.findExercise(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return null;
	}
	
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/efw/{workout_id}")
	public Response addingExercise(ExercisesForWorkout efw, @PathParam("workout_id") int workoutId) {
		Workout workout = efwr.addExerciseToWorkout(efw, workoutId);
		return Response.accepted(workout).build();
	}
	
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/efw/both/{workout_id}/{exercise_name}")
	public Response addingExerciseAndWorkout(@PathParam("workout_id") int workoutId,
			@PathParam("exercise_name") String exerciseName, ExercisesForWorkout efw) {
		if (wr.findWorkout(workoutId).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		else if (er.readExerciseByName(exerciseName).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Workout workout = efwr.addingBothExerciseAndWorkout(efw, workoutId, exerciseName);
		return Response.accepted(workout).build();
	}
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/efw/exercises/{exercise_id}/{exercisesForWorkout_id}")
	public Response completingExerciseDetails(@PathParam("exercise_id") String exerciseName, 
			@PathParam("exercisesForWorkout_id") int id) {
		System.out.println("test1");
		System.out.println(exerciseName);
		Exercise exercise = efwr.addExercise(efwr.findExercise(id), exerciseName);
		System.out.println(5);
		return Response.accepted(exercise).build();
	}
	
	@GET
	@Path("/efw/{exercisesForWorkout_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExerciseById(@PathParam("exercisesForWorkout_id") int id) {
		checkExercise(id);
		ExercisesForWorkout efw = efwr.findExercise(id);
		return Response.ok(efw).build();
	}
	
	@GET
	@Path("/efw/{workout_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExerciseByWorkout(@PathParam("workout_id") int id) {
		if (efwr.findExerciseByWorkout(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		List<ExercisesForWorkout> efw = efwr.findExerciseByWorkout(id);
		return Response.ok(efw).build();
	}
	
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/efw/{exercisesForWorkout_id}")
	public Response updateExercise(ExercisesForWorkout newExercise, @PathParam("exercisesForWorkout_id") int id) {
		checkExercise(id);
		ExercisesForWorkout efw = efwr.changeExerciseDetails(id, newExercise);
		return Response.accepted(efw).build();
	}
	
	@DELETE
	@Path("/efw/{exercisesForWorkout_id}")
	public Response removeExercise(@PathParam("exercisesForWorkout_id") int id) {
		checkExercise(id);
		efwr.deleteExercise(id);
		return Response.noContent().build();
	}
	
}












