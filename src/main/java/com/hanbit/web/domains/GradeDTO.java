package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Component
@Data
public class GradeDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String 
		subjName,grade,term,
		id,pw,name,regDate,gender,ssn,profileImg,email,phone,role;
	@Getter @Setter private int examSeq,subjSeq,gradeSeq,score,birth;
}