package in.casekartin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.casekartin.exception.ServiceException;
import in.casekartin.service.CartManagerService;

/**
 * Servlet implementation class DeleteFromCartServlet
 */
@WebServlet("/DeleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		//Get order id to cancel
		String orderId=request.getParameter("orderId");
		try {
			CartManagerService.cancelOrder(orderId);
			response.sendRedirect("viewCart.jsp");
		}catch(ServiceException | IOException e){
			logger.info(e.getMessage());
		}
	}

	

}
