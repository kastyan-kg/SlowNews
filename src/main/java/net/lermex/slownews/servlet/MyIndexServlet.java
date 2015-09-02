package net.lermex.slownews.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import net.lermex.slownews.entity.Item;
import net.lermex.slownews.service.XMLFeeder;



public class MyIndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		XMLFeeder feeder = new XMLFeeder();
		List<Item> news = null;
		try {
			news = feeder.getNews().getNews();
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("news", news);
		
		RequestDispatcher requestDisp;
		requestDisp = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
	    requestDisp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] selectedNewsToArchive = req.getParameterValues("selected");
		
		HttpSession session = req.getSession();
		List<Item> news1 = (List<Item>) session.getAttribute("news");
		List<Item> alreadyInArchive = (List<Item>) session.getAttribute("archivedNews");
		List<Item>archivedNews = new ArrayList<Item>();
		if(news1!=null){
		
		if(selectedNewsToArchive!=null){
			
		
		for (int i = 0; i < selectedNewsToArchive.length; i++) {
			for (Item item : news1) {
				if(selectedNewsToArchive[i].equals(item.getTitle())){
					if(alreadyInArchive != null){
						for (Item itemInArchive : alreadyInArchive) {
							if(!item.getTitle().equals(itemInArchive.getTitle())){
								archivedNews.add(item);
							}
						}
						
					}else{
						archivedNews.add(item);
					}
					
				}
			}
		}
		
		}
		}
		if(alreadyInArchive!= null){
		archivedNews.addAll(alreadyInArchive);
		}
		session.setAttribute("archivedNews", archivedNews);
		resp.sendRedirect("mainpage");
				
	}
	
	
	
}
