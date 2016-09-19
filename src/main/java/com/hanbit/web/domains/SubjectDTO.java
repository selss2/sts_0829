package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Component
@Data
public class SubjectDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Getter @Setter private int subjSeq;
	@Getter @Setter private String subjName;
	@Getter @Setter private String id;
	
}