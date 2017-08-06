package testTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import testTask.entity.User;
import testTask.service.IUserService;


@RestController
public class UsersController {


//	@RequestMapping("/user")
	@GetMapping("test")
	public String user() {
		return userService.addUser();
	};
	// test test
	
	@Autowired
	private IUserService userService;
	
	// get activities + profile into db
	@GetMapping("user/{user_google_id}")
	public ResponseEntity<User> getUserById(@PathVariable("user_google_id") String user_google_id) {
		User user = userService.getUserById(user_google_id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@DeleteMapping("user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("user_google_id") String user_google_id) {
		userService.deleteUser(user_google_id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
