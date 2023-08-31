package com.qorlwn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qorlwn.web.Member;
import com.qorlwn.web.repository.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/members")
	public String members(Model model) {
		/*
		Member member = new Member();
		member.setMid("bbbb");
		member.setMname("떡꼬치");
		member.setMpw("bbbb");
		member.setMjoindate("2023-08-31");
		memberRepository.save(member);
		*/
		List<Member> list = memberRepository.findTop5ByOrderByMnoDesc();// db에서 mno로 바꾸고 실행
		/*
		 * finaAll() : 전체 가져오기
		 * findOne(pk) : 하나 가져오기
		 * save() : 저장하기 / 수정하기
		 * count()
		 * delete()
		 */
		model.addAttribute("list", list);
		return "members";
	}
}
