package net.lermex.slownews.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.JAXBException;

import net.lermex.slownews.entity.Item;
import net.lermex.slownews.entity.Rss;

public class DAO {

	public static void main(String[] args) throws JAXBException, IOException {
		
		EntityManagerFactory entityManFact = Persistence.createEntityManagerFactory("Item");
		EntityManager entManager = entityManFact.createEntityManager();
		entManager.getTransaction().begin();
		XMLFeeder feeder = new XMLFeeder();
		Rss rss = feeder.getNews();
		List<Item> news = rss.getNews();
		for (Item item : news) {
			entManager.persist(item);
		}
		entManager.getTransaction().commit();
		
		//trying to get smth from db
		List<Item> news2 = (List<Item>) entManager.createQuery("select e from Item e").getResultList();
		
		System.out.println(news2.get(0).getDescription());
		
		entManager.close();
		
		
		

	}

}
