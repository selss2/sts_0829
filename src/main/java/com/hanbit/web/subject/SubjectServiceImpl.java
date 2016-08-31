package com.hanbit.web.subject;

import org.springframework.stereotype.Service;

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
	public void insert(SubjectVO s) {
		dao.insert(s);
	}
}
