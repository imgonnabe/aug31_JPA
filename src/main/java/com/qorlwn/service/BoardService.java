package com.qorlwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qorlwn.entity.JBoard;
import com.qorlwn.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public void save(JBoard jBoard) {
		boardRepository.save(jBoard);
	}
	
	public List<JBoard> findAll() {
		return boardRepository.findAll();
	}

	public JBoard detail(int bno) {
		return boardRepository.findByBno(bno);
	}
}
