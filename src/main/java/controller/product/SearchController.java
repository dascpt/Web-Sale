package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SearchController2;
import dao.ListProductDao;
import model.Product;

public class SearchController {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String txt = request.getParameter("txt");
		
		try {
			List<Product> list = ListProductDao.search(txt);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		} catch (Exception e) {
			Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
