package com.hanbit.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanbit.web.domains.MemberDTO;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("user");
		if (member.getId()==null) {
			logger.info("Interceptor : Session INFO IS NONE");
			response.sendRedirect("redirect : /");
			return false;
		}
		else{
			logger.info("Interceptor : Session INFO IS FULL");
			return super.preHandle(request, response, handler);
		}
	}
}
