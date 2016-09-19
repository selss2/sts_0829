package com.hanbit.web.services;

import org.springframework.stereotype.Component;

import com.hanbit.web.domains.SubjectDTO;
@Component
public interface SubjectService {
	public void insert(SubjectDTO s);
}