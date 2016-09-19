package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.services.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

	@Override
	public void insert(SubjectDTO s) {
	}
}