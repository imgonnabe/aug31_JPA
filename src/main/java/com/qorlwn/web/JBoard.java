package com.qorlwn.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	@Column(name = "btitle", length = 15)
	private String title;
	@Column(name = "bcontent", columnDefinition = "mediumtext", length = 500)
	private String content;
	@Column(columnDefinition = "timestamp")
	private String bdate;
	@Column(length = 10)
	private String mname;
}
