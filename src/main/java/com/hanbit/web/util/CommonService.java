package com.hanbit.web.util;

import java.util.List;
import java.util.Map;

public interface CommonService {
	public List<?> list();
	public List<?> findBy(String keyword);
	public int count();
	public Map<?,?> map();
	
	
	
}

