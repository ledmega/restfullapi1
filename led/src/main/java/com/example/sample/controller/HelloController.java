package com.example.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.model.ApiResponseMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "HelloController", description = "헬로 에이피아이")
public class HelloController {

	@RequestMapping(value="/hello", method= RequestMethod.GET)
	@ApiOperation(value="hello, World API", notes="hello, World 를 반환하는 API, Ajax 통신확인용.")
	public ResponseEntity<ApiResponseMessage> helloWorld() {
		
		ApiResponseMessage message = new ApiResponseMessage("Success", "Hello, World", "", "");
	
		return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
		//return "hello, World";
	}
}
