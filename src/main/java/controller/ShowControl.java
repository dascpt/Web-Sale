package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.ListProductDao;
import dao.OrderDao;
import model.Product;
import model.ProductOrders;

/**
 * Servlet implementation class ShowControl
 */
@WebServlet("/show")
public class ShowControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		session.getAttribute("acc");
		
		User acc = (User) session.getAttribute("acc");
		
		OrderDao orderDao = new OrderDao();
		
		ListProductDao listProductDao = new ListProductDao();
		
		List<Product> listProducts = new ArrayList<>();
		
		List<ProductOrders> proOrders = orderDao.show(acc);
		try {
			List<ProductOrders> listProductOrders = orderDao.show(acc);	
			for(ProductOrders proOrder : listProductOrders) {
				listProducts.add(listProductDao.getProduct("" + proOrder.getProductId()));
			}
			session.setAttribute("listProducts", listProducts);
			session.setAttribute("listProductOrders", listProductOrders);
//			response.sendRedirect("show.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("show.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
