package com.qorlwn.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class JBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	@Column(name = "btitle", length = 15)
	private String title;
	@Column(name = "bcontent", columnDefinition = "mediumtext", length = 500)
	private String content;
	@LastModifiedDate// 마지막 수정 시간으로 바꾼다.
	@Column(columnDefinition = "timestamp")
	private LocalDateTime bdate;
	// jboard (m:1) jmember
	@ManyToOne(fetch = FetchType.LAZY)// 연관 엔티티는 처음에 로드되지 않고, 해당 엔티티를 접근하거나 호출할 때 실제로 데이터베이스에서 로드된다.
	@JoinColumn(name = "mno")// mno를 기준으로 조인
	private Member member;
}
