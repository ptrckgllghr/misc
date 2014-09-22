package com.atos.ajax;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.http.*;

public class SimpleAJAXResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServerException, IOException {
		
		String number = request.getParameter("num");
		String strRepr = null;
		if(number != null){
			switch(Integer.parseInt(number)){
				case 0: 
					strRepr = "Zero";
				break;
				case 1:
					strRepr = "One";
				break;
				case 2:
					strRepr = "Two";
				break;
				case 3:
					strRepr = "Three";
				break;
				case 4:
					strRepr = "Four";
				break;
				case 5:
					strRepr = "Five";
				break;
				case 6:
					strRepr = "Six";
				break;
				case 7:
					strRepr = "Seven";
				break;
				case 8:
					strRepr = "Eight";
				break;
				case 9:
					strRepr = "Nine";
				break;
				default:
					strRepr = "Sorry, no conversion available for the number "+number+".";
			}
			
			//Set up the response
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(strRepr);
			}
			else{
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write("?");
			}
	}
}