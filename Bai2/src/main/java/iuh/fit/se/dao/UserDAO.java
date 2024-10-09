package iuh.fit.se.dao;

import java.util.List;

import iuh.fit.se.models.User;

public interface UserDAO {
	public User add(User user);
	public List<User> getAllUsers();
	public boolean isEmailExists(String email);
}
