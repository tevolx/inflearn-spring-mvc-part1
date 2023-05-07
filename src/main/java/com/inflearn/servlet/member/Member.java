package com.inflearn.servlet.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private String username;
	private Long id;
	private int age;

	public Member(String username, int age) {
		this.username = username;
		this.age = age;
	}
}
