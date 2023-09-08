package jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jwt.dao.UserDao;
import jwt.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		return user;
	}
	
	public List<User> getAllUsers() {
		return this.userDao.getAll();
	}
}
