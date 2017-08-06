package testTask.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import testTask.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserById(String user_google_id) {
		return entityManager.find(User.class, user_google_id);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public void deleteUser(String user_google_id) {
		entityManager.remove(getUserById(user_google_id));

	}

	@Override
	public boolean userExists(String user_google_id) {
		String hql = "FROM User WHERE id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, user_google_id).getResultList().size();
		return count > 0 ? true : false;
	}

}
