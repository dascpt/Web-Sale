package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDao;
import model.Product;

public class ListController {
	protected void processReques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.setContentType("text/html;charset=UTF-8");
		
		
		try(PrintWriter out = response.getWriter()) {
			String pageid = request.getParameter("page");
			if(pageid == null) {
				pageid = "1";
			}
			int start = Integer.parseInt(pageid);
			int total = 6;
			
			if(start ==1) {
			}
			else {
				start = start - 1;
				start = start * total + 1;
			}
			
			List<Product> list = ListProductDao.getProduct(start, total);
			Product last = ListProductDao.getLast();
			
			request.setAttribute("list", list);
			
			request.setAttribute("p", last);
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
		} catch (Exception ex) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
