package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.AccountDao;

/**
 * Servlet implementation class SignupControl
 */
@WebServlet("/signup")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String Repeatpassword = request.getParameter("Repeatpassword");
		
		if(!password.equals(Repeatpassword)) {
			response.sendRedirect("login.jsp");
		}else {
			AccountDao dao = new AccountDao();
			User user = dao.Exist(email ,username);
		
			if(user == null) {
				dao.signup(email, password, username);
				response.sendRedirect("index.jsp");
			}else {
				request.setAttribute("message", "email or username in an already");
				response.sendRedirect("login.jsp");
			}
		}
	}

}
