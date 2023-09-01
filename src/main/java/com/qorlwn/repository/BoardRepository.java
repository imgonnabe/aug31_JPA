package com.qorlwn.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.qorlwn.entity.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {// long은 pk타입

	void save(JBoard jBoard);

	List<JBoard> findAll();

	JBoard findByBno(int bno);

}
