package com.inflearn.servlet.basic.request;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HttpServletRequestTest", urlPatterns = "/request-params")
public class ServletRequest extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String contentType = req.getContentType();
		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();

		System.out.println("method = " + method);
		System.out.println("contentType = " + contentType);
		System.out.println("requestURI = " + requestURI);
		System.out.println("requestURL = " + requestURL);

		req.getParameterNames().asIterator().forEachRemaining(paramNames -> System.out.println(paramNames + " : " + req.getParameter(paramNames)));


	}
}
