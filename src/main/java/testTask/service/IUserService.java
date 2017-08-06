package testTask.service;

import java.util.List;

import testTask.entity.Activity;
import testTask.entity.User;

public interface IUserService {

	User getUserById(String id);
	String addUser();
	void deleteUser(String id);
	
	List<Activity> getUsersActivities(String id);
	
}
