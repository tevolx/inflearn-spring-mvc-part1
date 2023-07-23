package com.inflearn.servlet.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.inflearn.servlet.basic.member.Member;
import com.inflearn.servlet.basic.member.MemberRepository;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		//given
		Member member = new Member("kim", 20);

		//when
		Member savedMember = memberRepository.save(member);

		//then
		Member findMember = memberRepository.findById(member.getId());
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	void findAll() {
		//given
		Member member1 = new Member("kim", 21);
		Member member2 = new Member("park", 32);

		//when
		memberRepository.save(member1);
		memberRepository.save(member2);

		List<Member> memberList = memberRepository.findAll();

		//then
		assertThat(memberList.size()).isEqualTo(2);
		assertThat(memberList).contains(member1, member2);
	}
}