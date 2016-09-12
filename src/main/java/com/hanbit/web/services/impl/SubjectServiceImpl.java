package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	SubjectDAOImpl dao = SubjectDAOImpl.getInstance();
	private static SubjectServiceImpl instance
		= new SubjectServiceImpl();
	private SubjectServiceImpl() {
		
	}
	public static SubjectServiceImpl getInstance() {
		return instance;
	}

	@Override
	public void insert(SubjectDTO s) {
		dao.insert(s);
	}
}
