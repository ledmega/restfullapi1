package com.example.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.sample.data.entity.ComUser;
import com.example.sample.repository.UserRepository;
import com.example.sample.service.UserService;
import com.google.common.collect.ImmutableList;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;
     
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<ComUser> selectUserList() {
        return ImmutableList.copyOf(userRepository.findAll());
    }
 
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ComUser selectUser(Long userno) {
        return userRepository.findOne(userno);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insertUser(ComUser user) {
    	
    	String pw = user.getUserpw();
    	//String encodedPw = new BCryptPasswordEncoder().encode(pw);
    	//user.setUserpw(encodedPw);
        userRepository.save(user);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updateUser(ComUser user) {
    	if(user.getDeleteflag() == null || user.getDeleteflag().length() == 0) {
    		user.setDeleteflag("N");
    	}
        userRepository.save(user);
    }
 
    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteUser(Long userno) {
        userRepository.delete(userno);
 
    }



}
