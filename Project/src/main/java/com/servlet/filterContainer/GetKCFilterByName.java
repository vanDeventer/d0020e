package com.servlet.filterContainer;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetKCs/FilterByName")
public class GetKCFilterByName extends HttpServlet {

	/**
	 *  No idea what this is.. 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		response.setContentType("text/plain");
		response.getWriter().write("This is the response from get KC Filter By name");
		
	}
	
}