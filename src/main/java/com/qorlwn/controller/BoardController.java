package com.qorlwn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qorlwn.entity.JBoard;
import com.qorlwn.entity.Member;
import com.qorlwn.service.BoardService;
import com.qorlwn.service.MemberService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<JBoard> list = boardService.findAll();
		model.addAttribute("list", list);
		return "board";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard, HttpSession session) {
		System.out.println(jBoard);
		if(session.getAttribute("id") != null) {
			Member member = memberService.findById((String)session.getAttribute("id"));
			jBoard.setMember(member);
			boardService.save(jBoard);
			return "redirect:/board";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name = "bno", required = true) int bno, Model model) {
		JBoard detail = boardService.detail(bno);
		model.addAttribute("detail", detail);
		return "detail";
	}
}
