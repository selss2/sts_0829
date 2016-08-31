package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class GradeServiceImpl implements GradeService {
	GradeDAOImpl dao = GradeDAOImpl.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {}
	@Override
	public int insert(GradeVO grade) {
		return dao.insert(grade);
	}

	@Override
	public void update(GradeVO grade) {
		if (dao.update(grade)==1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	@Override
	public String delete(String del) {
		String msg = "";
		if (dao.delete(del) == 1) {
			msg = "삭제완료";
		} else {
			msg = "실패";
		}
			
		return msg;
	}

	@Override
	public List<?> list() {
		List<?> list = dao.list();
		return list;
	}

	@Override
	public List<?> findBy(String id) {
		return dao.findById(id);
	}

	@Override
	public GradeVO findBySeq(String seq) {
		return dao.findBySeq(seq);
	}
	@Override
	public int count() {
		return dao.count();
	}
	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}
	@Override
	public void score(String[] a) {
		GradeVO g = new GradeVO();
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
		// TODO Auto-generated method stub
		return null;
	}
	

}
