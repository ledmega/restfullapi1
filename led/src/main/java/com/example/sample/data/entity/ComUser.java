package com.example.sample.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "com_user")
@Setter
@Getter
public class ComUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "userno") Long userno;
	
	private @Column(name = "userid" ) String userid;
	private @Column(name = "usernm" ) String usernm;
	private @Column(name = "userpw") String userpw;
	private @Column(name = "userrole") String userrole;
	private @Column(name = "photo") String photo;
	private @Column(name = "deptno") int deptno;
	
	private @Column(name = "deleteflag", nullable = false) String deleteflag;
	
	private @Column(name = "cuserid") String cuserid;
	
	@CreationTimestamp
	private @Column(name = "cdate") Timestamp cdate;
	
	private @Column(name = "uuserid") String uuserid;
	
	@UpdateTimestamp
	private @Column(name = "udate") Timestamp update;
	
	
	
}
