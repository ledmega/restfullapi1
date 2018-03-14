package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.common.domain.Result;
import com.example.sample.service.MemberService;
import com.example.sample.vo.ComUser;

import io.swagger.annotations.Api;

@RestController
@Api(value = "AuthenticationCtr", description = "사용자 인증 관련", basePath = "")
public class AuthenticationCtr {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value="/auth0")
	private void getToken(HttpServletRequest req, ModelMap model) {
		Result result = Result.successInstance();
		String jsonData = "";
		jsonData = req.getParameter("json");
		System.out.println("jsonData = " + jsonData);
		try {
			JSONObject js = new JSONObject(jsonData);
			//js.get("id")
			ComUser comuser = memberService.signin(js.get("id").toString(),js.get("password").toString());
			
			System.out.println("name = " + comuser.getUsernm());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//ComUser comuser = 
		
		
	}
	
	

}
