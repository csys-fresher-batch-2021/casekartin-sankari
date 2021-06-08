package in.casekartin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.casekartin.exception.ServiceException;
import in.casekartin.model.CartManager;
import in.casekartin.service.CartManagerService;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		try {
			List<CartManager> cart=CartManagerService.listByUserName(userName);
			Gson gson = new Gson();
			String json = gson.toJson(cart);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}catch(ServiceException e) {
			e.printStackTrace();
		}
	}



}
