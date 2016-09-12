package com.hanbit.web.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService {
	private static GradeServiceImpl instance = new GradeServiceImpl();
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void score(String[] a) {
		GradeDTO g = new GradeDTO();
		g.setId(a[0]);
		g.setExamDate(a[1]);
		g.setJava(Integer.parseInt(a[2]));
		g.setSql(Integer.parseInt(a[3]));
		g.setHtml(Integer.parseInt(a[4]));
		g.setJavascript(Integer.parseInt(a[5]));
		this.insert(g);
	}
	@Override
	public Map<?, ?> map() {
		return null;
	}

	@Override
	public List<?> list() {
		return null;
	}

	@Override
	public List<?> findBy(String keyword) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public int insert(GradeDTO grade) {
		return 0;
	}

	@Override
	public GradeDTO findBySeq(String seq) {
		return null;
	}

	@Override
	public void update(GradeDTO grade) {
		
	}

	@Override
	public String delete(String del) {
		return null;
	}

	@Override
	public int count(String examDate) {
		return 0;
	}
	

}
