package com.qorlwn.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

// 영속성
@Entity
@Data
@Table(name = "jmember")
@NoArgsConstructor// 생성자x, 조인 가능
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	@Column(length = 10)
	private String mname;
	@Column(name = "mid", unique = true, length = 10)
	private String id;
	@Column(name = "mpw", nullable = false, columnDefinition = "text")
	private String pw;
	@Column(columnDefinition = "timestamp")
	private LocalDateTime mjoindate;
}
