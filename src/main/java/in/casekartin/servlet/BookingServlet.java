package in.casekartin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import in.casekartin.exception.ServiceException;
import in.casekartin.model.CartManager;
import in.casekartin.service.CartManagerService;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caseType=request.getParameter("caseType");
		String mobileBrand=request.getParameter("mobileBrand");	
		String mobileModel=request.getParameter("mobileModel");	
		String noOfCases=request.getParameter("noOfCases");	
		String price=request.getParameter("price");	
		HttpSession session=request.getSession(); 
		String userName= (String) session.getAttribute("LOGGED_IN_USER");
		
		CartManager cart=new CartManager();
		cart.setCaseName(caseType);
		cart.setMobileBrand(mobileBrand);
		cart.setMobileModel(mobileModel);
		cart.setPrice(Float.parseFloat(price));
		cart.setNoOfCases(Integer.parseInt(noOfCases));
		
		Gson gson = new Gson();
		String message=null;
		try {
			CartManagerService.addCartToBookedDetails(cart,userName);
			message="true";
		} catch (ServiceException e) {
			e.printStackTrace();
			message=e.getMessage();
		}
		String json = gson.toJson(message);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
