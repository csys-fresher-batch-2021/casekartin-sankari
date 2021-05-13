package in.casekartin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.casekartin.service.CaseManagerService;
import in.casekartin.validator.CaseManagerValidator;

/**
 * Servlet implementation class AddCaseTypeServlet
 */
@WebServlet("/AddCaseTypeServlet")
public class AddCaseTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the form value
		String caseName = request.getParameter("caseName");
		String cost = request.getParameter("cost");
		/**
		 * through try catch method intimate the person to enter the correct case name
		 */
		try {
			if (CaseManagerService.addCaseType(caseName, cost)) {
				response.sendRedirect("caseTypes.jsp");
			} else if (!CaseManagerValidator.isNotExist(caseName)) {
				String message = "Case Name is Already Exist";
				response.sendRedirect("addCaseTypes.jsp?errorMessage=" + message);
			} else {

				String message = "Invalid Case Name";
				response.sendRedirect("addCaseTypes.jsp?errorMessage=" + message);

			}
		} catch (Exception e) {
			String message = e.getMessage();
			response.sendRedirect("addCaseTypes.jsp?errorMessage=" + message);
		}

	}

}
