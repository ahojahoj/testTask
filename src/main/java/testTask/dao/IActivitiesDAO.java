package testTask.dao;

import java.util.List;

import testTask.entity.Activity;

public interface IActivitiesDAO {
	List<Activity>  getUsersActivities(String user_google_id);
    void addActivity(Activity activity);
    void deleteActivity(String user_google_id);
    boolean activityExists(String url);
}
