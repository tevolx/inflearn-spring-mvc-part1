package com.inflearn.servlet.web.frontcontroller.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import com.inflearn.servlet.web.frontcontroller.v1.contoller.MemberFormControllerV1;
import com.inflearn.servlet.web.frontcontroller.v1.contoller.MemberListControllerV1;
import com.inflearn.servlet.web.frontcontroller.v1.contoller.MemberSaveControllerV1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FrontControllerV1
 *
 * @author HYUN TAE PARK
 * @version 1.0.0
 * @since 2023. 05. 29.
 */

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {

	private final Map<String, ControllerV1> controllerMap = new HashMap<>();

	public FrontControllerV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FrontControllerServletV1.service");
		String requestURI = request.getRequestURI();

		ControllerV1 controller = controllerMap.get(requestURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		controller.process(request, response);
	}
}
