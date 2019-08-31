package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	public Response addingExercise(ExercisesForWorkout efw, @PathParam("workout_id") int id) {
		checkExercise(id);
		Workout workout = efwr.addExerciseToWorkout(efw, id, efw.getExercise().getExerciseName());
		return Response.accepted(workout).build();
	}
	
	@GET
	@Path("/efw/{exercisesForWorkout_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExerciseById(@PathParam("exercisesForWorkout_id") int id) {
		checkExercise(id);
		ExercisesForWorkout efw = efwr.findExercise(id);
		return Response.ok(efw).build();
	}
	
}












