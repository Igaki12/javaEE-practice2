package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException IOException{
		String forwardpath = null;
		String action = request.getParameter("action");
		
		if(action =="null") {
			forwardpath = "/WEB-INF/jsp/registerForm.jsp";
		}
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			session.removeAttribute("registerUser");
			forwardpath = "/WEB-INF/jsp/registerForm.jsp";
		}
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardpath);
			dispatcher.forward(request, response);
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		User registerUser = new User(id,pass,name);
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request,response);
		
	}
	
}
