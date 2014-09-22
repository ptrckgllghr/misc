package com.thefax.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thefax.bean.ProductBean;
import com.thefax.dao.ShoppingDao;

public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ShoppingDao dao = new ShoppingDao();

		String code = request.getParameter("code");
		if (request.getParameter("code") != null) {
			// Request is coming to add item to cart
			ProductBean product = dao.getProduct(code);
			
			// Creating an array list object to reperesent cart for USER
			ArrayList<ProductBean> cart = null;

			// GEtting session object , getSession() method checks for existing
			// session. If o session id found in rqest header a new session
			// object is returned
			HttpSession session = request.getSession();
			// Getting cart object from session
			cart = (ArrayList<ProductBean>) session.getAttribute("CART");
			// If cart object remains null, that mens its a new session
			if (cart == null)
				cart = new ArrayList<ProductBean>();
			cart.add(product);
			// Adding or updating cart attribute in session
			session.setAttribute("CART", cart);

			//Adding product object in request scope
			request.setAttribute("PRODUCTS", product);
			//Forwarding control to summary page
			getServletContext().getRequestDispatcher("/summary.jsp").forward(request, response);
		} else {
			ArrayList<ProductBean> catalog = dao.getCatalog();

			// Adding catalog to Request scope
			request.setAttribute("CATALOG", catalog);

			// Forwarding request to catalog page
			ServletContext srvCtx = getServletContext();
			// Getting dispatcher from context for catalog page
			RequestDispatcher reqDsp = srvCtx
					.getRequestDispatcher("/catalog.jsp");
			// Forwarding request in invoking service method by passing req &
			// resp
			reqDsp.forward(request, response);
		}
	}
}
