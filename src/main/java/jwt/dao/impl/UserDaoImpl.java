package jwt.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jwt.dao.UserDao;
import jwt.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.save(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		return (User) cr.add(Restrictions.eq("email", email)).uniqueResult();
		
	}

	@Override
	public List<User> getAll() {
		Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		return cr.list();
	}
	
	

}
