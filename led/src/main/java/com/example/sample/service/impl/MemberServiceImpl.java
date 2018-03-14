package com.example.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.repository.MemberRepository;
import com.example.sample.service.MemberService;
import com.example.sample.vo.ComUser;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private static final String DEFAULT_NICKNAME = "번째러버";
	private static final String PROFILE_DEFAULT_PATH = "/profile/0/profile_default.jpg";
	private static final String SIGNIN_EXCEPTION_MSG = "로그인정보가 일치하지 않습니다.";
	private static final String EMAIL_EXIST_EXCEPTION_MSG = "이미 계정이 존재합니다.";
	private static final String NICKNAME_EXIST_EXCEPTION_MSG = "이미 닉네임이 존재합니다.";
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public ComUser signin(String id, String password) {
		
		ComUser user = memberRepository.findByUserid(id);
		
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		
		return user;
	}
}
