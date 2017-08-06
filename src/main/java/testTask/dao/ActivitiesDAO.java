package testTask.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import testTask.entity.Activity;

@Transactional
@Repository
public class ActivitiesDAO implements IActivitiesDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Activity> getUsersActivities(String user_google_id) {
		System.out.println("cau "+user_google_id);
		return entityManager.createQuery("from Activity WHERE userId=:id", Activity.class).setParameter("id", user_google_id)
				.getResultList();
	}

	@Override
	public void addActivity(Activity activity) {
		entityManager.persist(activity);
	}

	@Override
	public void deleteActivity(String user_google_id) {
		Query query = entityManager.createQuery("DELETE FROM Activity WHERE id = :id");
		query.setParameter("id", user_google_id).executeUpdate();
	}

	@Override
	public boolean activityExists(String url) {
		String hql = "FROM Activity WHERE url = ?";
		int count = entityManager.createQuery(hql).setParameter(1, url).getResultList().size();
		return count > 0 ? true : false;
	}
}
