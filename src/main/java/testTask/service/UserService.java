package testTask.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.Plus.Builder;
import com.google.api.services.plus.model.Person;

import testTask.dao.IActivitiesDAO;
import testTask.dao.IUserDAO;
import testTask.entity.Activity;
import testTask.entity.User;

@Component
public class UserService implements IUserService {

	// ... test test
	public String getUser() {
		return "test";
	}
	// ... test test

	private String ID_PROFILE = "";

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IActivitiesDAO activitiesDAO;

	@Override
	public User getUserById(String id) {
		User obj = userDAO.getUserById(id);
		return obj;
	}

	@Override
	public String addUser() {

		GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(JacksonFactory.getDefaultInstance())
				.setTransport(new NetHttpTransport())
				.setClientSecrets("1030162942722-jiaanama090ceqoulfhfagth5puks1r1.apps.googleusercontent.com",
						"NNvJBe6y1EGOKbrurearYDfV")
				.build();

		Plus plus = new Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
				.setApplicationName("xxx").build();

		try {
			// profil
			Person profile = plus.people().get("ID_PROFILE").execute();
			// ...

			// list aktivit profilu
			 Plus.Activities.List listActivities = plus.activities().list(ID_PROFILE, "public");
			// listActivities.setMaxResults(5L);
			// ...

			return "ano";
		} catch (IOException e) {
			e.printStackTrace();
		}
		// vlozeni persony do db
		User u = new User("id", "name", "gender", "url");
		// vlozeni aktivit do db
		List<Activity> list = new ArrayList<Activity>();
		list.add(new Activity("id", "111", "111", 111, 111));
		list.add(new Activity("id", "222", "222", 111, 111));
		list.add(new Activity("id", "333", "333", 111, 111));
		list.add(new Activity("id2", "444", "444", 222, 222));
		list.add(new Activity("id3", "555", "555", 333, 333));
		for (Activity activity : list) {

			if (!activitiesDAO.activityExists(activity.getActivityUrl()))
				activitiesDAO.addActivity(activity);
			else
				System.out.println("Aktivita uz existuje");
			;
		}
		list.clear();
		list = activitiesDAO.getUsersActivities("id");
		for (Activity activity : list) {
			System.out.println("aktivita: " + activity.getActivityUrl());
		}

		// deleteUser("id");
		// vlozeni usera, pokud uz tam neni..
		if (userDAO.userExists(u.getUserId())) {
			return "uz existuje";
		} else {
			userDAO.addUser(u);
			return "pridan";
		}
	}

	@Override
	public void deleteUser(String id) {
		userDAO.deleteUser(id);
		activitiesDAO.deleteActivity(id);
	}

	@Override
	public List<Activity> getUsersActivities(String id) {
		return activitiesDAO.getUsersActivities(id);
	}

}
