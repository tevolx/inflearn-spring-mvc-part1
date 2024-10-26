package hello.servlet.web.frontcontroller.v1.contoller;

import java.io.IOException;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MemberFormController
 *
 * @author HYUN TAE PARK
 * @version 1.0.0
 * @since 2023. 05. 29.
 */
public class MemberFormControllerV1 implements ControllerV1 {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
