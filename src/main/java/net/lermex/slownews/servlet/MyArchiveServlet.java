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

import org.springframework.http.HttpRequest;

import net.lermex.slownews.entity.Item;

@SuppressWarnings("serial")
public class MyArchiveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
	
		RequestDispatcher requestDisp;
		requestDisp = req.getRequestDispatcher("/WEB-INF/view/archive.jsp");
	    requestDisp.forward(req, resp);
	    
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] selectedToDel = req.getParameterValues("selectedToDel");
		System.out.println(selectedToDel[0]);
		HttpSession session = req.getSession();
		List<Item> archivedNews =  (List<Item>) session.getAttribute("archivedNews");
	
		
		resp.sendRedirect("archive");
	}
	
}
