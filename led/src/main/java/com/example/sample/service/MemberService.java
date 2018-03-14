package com.example.sample.service;

import org.springframework.stereotype.Service;

import com.example.sample.vo.ComUser;

@Service
public interface MemberService {
	
	ComUser signin(String id, String password);
}
