package com.qorlwn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qorlwn.web.JBoard;
import com.qorlwn.web.repository.BoardRepository;

@Controller
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard) {
		System.out.println(jBoard);
		// 저장하기 save()
		jBoard.setMname("떡꼬치");
		boardRepository.save(jBoard);
		return "redirect:/board";
	}
}
