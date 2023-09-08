package jwt.dao;

import java.util.List;

import jwt.entity.User;

public interface UserDao{
	
	public User save(User user);
	
	public User findByEmail(String email);
	
	public List<User> getAll();
}
