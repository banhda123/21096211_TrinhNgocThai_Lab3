package iuh.fit.se.daoImpl;

import java.util.ArrayList;
import java.util.List;

import iuh.fit.se.dao.UserDAO;
import iuh.fit.se.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAOImpl implements UserDAO{
	private EntityManager entityManager;
	private List<User> users;
	public UserDAOImpl(EntityManager en) {
		this.entityManager = en;
		users = new ArrayList<User>();
	}

	@Override
	public User add(User user) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(user);
			trans.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "SELECT u FROM User u";
	    return entityManager.createQuery(jpql, User.class).getResultList();
	}

	@Override
	public boolean isEmailExists(String email) {
	    String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
	    Long count = entityManager.createQuery(jpql, Long.class)
	                              .setParameter("email", email)
	                              .getSingleResult();
	    return count > 0;
	}


}
