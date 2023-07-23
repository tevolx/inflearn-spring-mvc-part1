package com.inflearn.servlet.web.frontcontroller.v1.contoller;

import java.io.IOException;

import com.inflearn.servlet.domain.member.Member;
import com.inflearn.servlet.domain.member.MemberRepository;
import com.inflearn.servlet.web.frontcontroller.v1.ControllerV1;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MemberSaveControllerV1
 *
 * @author HYUN TAE PARK
 * @version 1.0.0
 * @since 2023. 05. 29.
 */

public class MemberSaveControllerV1 implements ControllerV1 {

	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		request.setAttribute("member", member);

		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
