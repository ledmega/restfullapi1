package com.example.sample.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.sample.common.error.UnauthorizedException;
import com.example.sample.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("jwtService")
public class JwtServiceImpl implements JwtService {
	
	private static final String SALT = "ledmegaSecret";
	private static final Log LOG = LogFactory.getLog(JwtServiceImpl.class);
	
	@Override
	public <T> String create(String key, T data, String subject) {
		String jwt = Jwts.builder()
					.setHeaderParam("typ", "JWT")
					.setHeaderParam("regDate", System.currentTimeMillis())
					.setSubject(subject)
					.claim(key, data)
					.signWith(SignatureAlgorithm.HS256, this.generateKey())
					.compact();
		return jwt;
	}
	
	private byte[] generateKey() {
		byte[] key = null;
		
		try {
			key = SALT.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e) {
			if(LOG.isInfoEnabled()) {
				e.printStackTrace();
			}else {
				//LOG.error("Making JWT Key Error ::: {}", e.getMessage());
				LOG.error(e.getMessage(), e);
			}
		}
		
		return key;
	}
	
	@Override
	public boolean isUsable(String jwt) {
		try {
			Jws<Claims> claims = Jwts.parser()
									.setSigningKey(this.generateKey())
									.parseClaimsJws(jwt);
		}catch(Exception e) {
			if(LOG.isInfoEnabled()) {
				e.printStackTrace();
			}else {
				LOG.error(e.getMessage());
			}
			throw new UnauthorizedException();
		}
		
		return false;
	}
	
	@Override
	public Map<String, Object> get(String key){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader("Authorization");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
					.setSigningKey(SALT.getBytes("UTF-8"))
					.parseClaimsJws(jwt);
		}catch(Exception e){
			if(LOG.isInfoEnabled()) {
				e.printStackTrace();
			}else {
				LOG.error(e.getMessage());
			}
			throw new UnauthorizedException();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
		return value;
	}
	
	@Override
	public int getMemberId() {
		return (int)this.get("member").get("memberId");
	}

}
