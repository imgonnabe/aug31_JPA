package com.qorlwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qorlwn.entity.Member;
import com.qorlwn.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	/*
	 * findAll() 전체 가져오기 findOne() 하나 가져오기 save() 저장하기 / 수정하기 count() delete()
	 * 
	 */
	public void save(Member member) {
		memberRepository.save(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public List<Member> findTop5ByOrderByMnoDesc() {
		return memberRepository.findTop5ByOrderByMnoDesc();
	}

	public int count(Member member) {
		return memberRepository.count(member.getId(), member.getPw());
	}

	public Member findById(String mid) {// id가 들어오면 해당 사용자의 정보 찾아오기
		return memberRepository.findById(mid);
	}

	public Member findByIdAndPw(String id, String pw) {// 로그인
		return memberRepository.findByIdAndPw(id, pw);
	}

}
