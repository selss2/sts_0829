package com.hanbit.web.domains;


import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class MemberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String id;
	//@Getter @Setter private String mem_id;
	@Getter @Setter private String pw;
	@Getter @Setter private String name;
	@Getter @Setter private String regDate;
	@Getter @Setter private String gender;
	@Getter @Setter private String ssn;
	@Getter @Setter private String profileImg;
	@Getter @Setter private String email;
	@Getter @Setter private String birth;
	@Getter @Setter private String phone;
	@Getter @Setter private String major;
	@Getter @Setter private String subject;
	
	}