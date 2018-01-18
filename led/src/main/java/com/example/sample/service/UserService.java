package com.example.sample.service;

import java.util.List;

import com.example.sample.data.entity.ComUser;

public interface UserService {
	
	 /**
     * 사용자 목록 조회
     * @return
     */
    public List<ComUser> selectUserList();
     
    /**
     * 사용자 조회
     * @param userno
     * @return
     */
    public ComUser selectUser(Long userno);
     
    /**
     * 사용자 등록
     * @param user
     */
    public void insertUser(ComUser user);
     
    /**
     * 사용자 정보 수정
     * @param user
     */
    public void updateUser(ComUser user);
     
    /**
     * 사용자 삭제
     * @param userno
     */
    public void deleteUser(Long userno);


}
