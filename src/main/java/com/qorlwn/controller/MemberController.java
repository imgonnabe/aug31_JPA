package com.qorlwn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qorlwn.entity.Member;
import com.qorlwn.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
		List<Member> list = memberService.findTop5ByOrderByMnoDesc();// db에서 mno로 바꾸고 실행
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
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		System.out.println(member);// Member(mno=0, mname=null, id=dfgdfg, pw=dfgdfg, mjoindate=null)
		int count = memberService.count(member);
		if(count == 1) {
			Member result = memberService.findByIdAndPw(member.getId(), member.getPw());
			System.out.println(result);// Member(mno=1, mname=떡볶이, id=aaaa, pw=aaaa, mjoindate=2023-09-01T10:16:39)
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getMname());
			return "redirect:/index";
		} else {
			return "login";
		}
	}
}
