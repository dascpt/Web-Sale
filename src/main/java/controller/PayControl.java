package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.OrderDao;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayControl
 */
@WebServlet("/pay")
public class PayControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User acc = (User) session.getAttribute("acc");
		
		String username = acc.getEmail();
		String discount = request.getParameter("discount");
		String address = request.getParameter("address");
		
		try {


			if (session.getAttribute("cart") == null) {
			}

			OrderDao dao = new OrderDao();

			Cart c = (Cart) session.getAttribute("cart");

			Orders d = new Orders(username, 2,null,  discount, address, "");

			dao.insertOrder(d, c);

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception ex) {
			response.getWriter().println(ex);
			ex.printStackTrace();
		}
	}

}
