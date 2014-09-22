package cc.mv.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setting Responxe MIME type
		response.setContentType("text/html");
		// Getting response stream for writing html
		PrintWriter out = response.getWriter();
		// Writing HTML response to stream
		out.println("<h1>Hello Beautiful World</h1>");
		out.println("<h2>Welcome to Servlets</h2><hr>");
		Date curDt = new Date();
		out.println("<h3>Now: " + curDt + "</h3>");
	}

}
