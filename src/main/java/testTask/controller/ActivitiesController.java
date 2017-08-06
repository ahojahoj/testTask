package testTask.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import testTask.entity.Activity;
import testTask.service.IUserService;

@RestController
public class ActivitiesController {

	@Autowired
	private IUserService userService;

	// get activities + profile into db
	@GetMapping("user/{user_google_id}/activities")
	public ResponseEntity<Collection<Activity>> getActivities(@PathVariable("user_google_id") String user_google_id) {
		return new ResponseEntity<>((Collection<Activity>) userService.getUsersActivities(user_google_id),
				HttpStatus.OK);
	}

}
