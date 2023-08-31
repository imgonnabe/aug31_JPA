package com.qorlwn.web.repository;

import org.springframework.data.repository.Repository;

import com.qorlwn.web.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jBoard);

}
