package repository;

import entity.Document;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepo {
	
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primarie");
	
	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public boolean checkUserAndPassword(String username, String password){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM User u WHERE UPPER(u.username) = :user_id and u.password = :password_id");
		query.setParameter("user_id",username);
		query.setParameter("password_id",password);
		List results = query.getResultList();
		em.close();

		return !results.isEmpty();

	}

	public String userType(String username){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u.tipUser FROM User u WHERE UPPER(u.username) = :user_id");
		query.setParameter("user_id",username);
		String userType = query.getResultList().get(0).toString();
		em.close();

		return userType;
	}

	public boolean checkUser(String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM User u WHERE UPPER(u.username) = :user_id");
		query.setParameter("user_id",username);
		List results = query.getResultList();
		em.close();

		return !results.isEmpty();
	}

	public List<User> allUsers(){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT new User(u.id,u.username,u.nume,u.prenume) FROM User u" );
		List <User> results = query.getResultList();
		em.close();

		return results;
	}

	public String getIdByUsername(String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u.id FROM User u WHERE UPPER(u.username) = :user_username");
		query.setParameter("user_username",username);
		String id = query.getResultList().get(0).toString();
		em.close();

		return id;
	}

	public String getNameByUsername(String username){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u.nume FROM User u WHERE UPPER(u.username) = :user_username");
		query.setParameter("user_username",username);
		String nume = query.getResultList().get(0).toString();
		em.close();

		return nume;
	}

	public String getPrenumeByUsername(String username){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u.prenume FROM User u WHERE UPPER(u.username) = :user_username");
		query.setParameter("user_username",username);
		String prenume = query.getResultList().get(0).toString();
		em.close();

		return prenume;
	}

	public List<User> getUserInfo(String username){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT new User(u.id,u.nume,u.prenume) FROM User u WHERE UPPER(u.username) = :user_username" );
		query.setParameter("user_username",username);
		List <User>results = query.getResultList();
		em.close();

		return results;
	}

}
