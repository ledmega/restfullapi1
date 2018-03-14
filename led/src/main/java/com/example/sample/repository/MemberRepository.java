package com.example.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.vo.ComUser;

//@Mapper
//@Repository
public interface MemberRepository extends JpaRepository<ComUser, Integer> {
	//List<ComUser> getUserList();
	
	ComUser findByUserid(String userid);
}
