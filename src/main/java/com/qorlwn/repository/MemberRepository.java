package com.qorlwn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.qorlwn.entity.Member;

public interface MemberRepository extends Repository<Member, Long> {

	void save(Member member);

	List<Member> findAll();

	List<Member> findTop5ByOrderByMnoDesc();
	
	// @Query가 없으면 count 칼럼을 member.java에 생성해야 한다.
	@Query(value = "select count(*) from jmember j where j.mid=?1 and j.mpw=?2", nativeQuery = true)
	int count(String id, String pw);// 첫번째 parameter : ?1

	Member findById(String mid);

	Member findByIdAndPw(String id, String pw);

}
