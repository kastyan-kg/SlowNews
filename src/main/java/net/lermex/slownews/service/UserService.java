package net.lermex.slownews.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.lermex.slownews.entity.Item;
import net.lermex.slownews.entity.User;

public class UserService {

	public  void addNewUser(String login, String password) {
		
		final User user = new User();
		user.setLogin(login);
		user.setDigestPassword(password);;

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("User");;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public boolean checkLogin(String possibleLogin){
		
		EntityManagerFactory entityManFact = Persistence.createEntityManagerFactory("User");
		EntityManager entManager = entityManFact.createEntityManager();
		entManager.getTransaction().begin();
		List<User> usersInDB = (List<User>) entManager.createQuery("select e from User e").getResultList();
		boolean correctLogin = true;
		for (User user : usersInDB) {
			if(user.getLogin().equals(possibleLogin)){
				correctLogin =  false;
			}
		}
		
		entManager.close();
		return correctLogin;
	}
	}


