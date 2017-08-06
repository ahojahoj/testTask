package testTask.dao;

import testTask.entity.User;

public interface IUserDAO {
    User getUserById(String user_google_id);
    void addUser(User user);
    void deleteUser(String user_google_id);
    boolean userExists(String user_google_id);
}
