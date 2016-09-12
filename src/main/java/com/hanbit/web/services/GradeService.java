package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.util.CommonService;


public interface GradeService extends CommonService{
	// 총 7개의 기본 패턴이 존재하더라
	// exeU
	public int insert(GradeDTO grade);
	public GradeDTO findBySeq(String seq);
	public void update(GradeDTO grade);
	public String delete(String del);
	// 점수입력받는 메소드
	public void score(String[] strArr);
	public int count(String examDate);
}
