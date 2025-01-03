package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello", name = "helloServlet")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("HelloServlet service");
		System.out.println("request = " + request);
		System.out.println("response = " + response);

		String username = request.getParameter("username");
		System.out.println("username = " + username);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("Hello " + username);
	}
}
