package iuh.fit.se.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityMangerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public EntityMangerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("user-registration");
		entityManager = entityManagerFactory.createEntityManager();
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}