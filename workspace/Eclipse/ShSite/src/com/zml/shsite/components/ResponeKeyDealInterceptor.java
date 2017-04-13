package com.zml.shsite.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 拦截器
 * @author fhr
 */
public class ResponeKeyDealInterceptor extends HandlerInterceptorAdapter{
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//PrintWriter out = response.getWriter();  
		//response.getOutputStream().
		response.setContentLength(-1);
		response.getWriter().println("Hello");
	}
}
