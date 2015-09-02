package net.lermex.slownews.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.lermex.slownews.service.UserService;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher requestDisp;
		requestDisp = req.getRequestDispatcher("/WEB-INF/view//register.jsp");
		requestDisp.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		UserService serv = new UserService();
		System.out.println("==============================================================================");
		if(serv.checkLogin(login)){
			serv.addNewUser(login, password);
			resp.sendRedirect("mainpage");
			session.setAttribute(login, String.class);
		}else{
			
			session.setAttribute("regresult", true);
		}
		
		
	}
	
	

}
