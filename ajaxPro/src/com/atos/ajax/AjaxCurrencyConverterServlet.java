package com.atos.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxCurrencyConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount = request.getParameter("amt");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
		if(amount != null) {
			int amt = Integer.parseInt(amount);
			int result = amt * 51;
			response.getWriter().write(""+result);
		}
	}
}
