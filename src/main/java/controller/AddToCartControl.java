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
 * Servlet implementation class AddToCartControl
 */
@WebServlet("/addtocart")
public class AddToCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		try {
			int amountProduct = 1;
			
			HttpSession session = request.getSession();
			
			String idd = request.getParameter("id");
			
			String action = request.getParameter("action");
			
			if(action != null && action.equalsIgnoreCase("add")) {
				if(session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
				}
				
				int id = Integer.parseInt(idd);
				
				Product p = new ListProductDao().getProduct("" + id);	
//				p.setNumber(1);
				
				session.setAttribute("product", p);
				
				Cart c = (Cart)session.getAttribute("cart");
				
				c.add(p);
				
				c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(),
						p.getType(), p.getBrand(), 1));
				session.setAttribute("cart", c);
			} else if(action != null && action.equalsIgnoreCase("delete")) {
				
				int id = Integer.parseInt(idd);
				
				Cart c = (Cart)session.getAttribute("cart");
				
				c.remove(id);
				
				session.setAttribute("cart", c);
			}
			response.sendRedirect("cart.jsp");			
		}catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String num = request.getParameter("quantity");
		int quantity = Integer.parseInt(num);
		
		if(quantity <= 0) {
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		session.setAttribute("quantity", quantity);
		
		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		Product p;
		try {
			p = ListProductDao.getProduct("" + id);
			p.setNumber(quantity);
			Cart c = (Cart) session.getAttribute("cart");
			session.setAttribute("cart", c);
			response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
