package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDao;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class SubOrAdd
 */
@WebServlet("/subOradd")
public class SubOrAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubOrAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numm = request.getParameter("num");
		String idd = request.getParameter("id");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		int num = Integer.parseInt(numm);
		int id = Integer.parseInt(idd);
		
		try {
			Product p = ListProductDao.getProduct("" + id);
			
			Cart c = (Cart) session.getAttribute("cart");
			
			if(num == -1) {
				c.sub(p);
				if(c.getQuantityById(id) == 0) {
					c.remove(id);
				}
			}else if(num == 1) {
				c.add(p);
			}
			session.setAttribute("cart", c);
			response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idd = request.getParameter("id");
		
		int id = Integer.parseInt(idd);
		
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		Cart c = (Cart) session.getAttribute("cart");
		c.remove(id);
		
		session.setAttribute("cart", c);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	

}
