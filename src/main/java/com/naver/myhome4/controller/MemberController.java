package com.naver.myhome4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.service.MemberService;

import jakarta.servlet.http.Cookie;

/*
 * @Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만 
 *  모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행한느지 파악하기 
 *  어렵습니다. 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서 
 * @Component를 상속하여 다음과 같은 세 개의 애노테이션을 제공합니다.
 * 
 * 1. @Controller - 사용자의 요청을 제어하는 Controller 클래스 
 * 2. @Repository - 데이터 베이스 연동을 처리하는 DAO 클래스
 * 3. @Service - 비즈니스 로직을 처리하는 Service 클래스 
 * */

@Controller
@RequestMapping(value="/member") // http://localhost:8088/myhome4/member/로 시작하는 주소 매핑
public class MemberController {
	
	// import org.slf4j.Logger;
	// import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/*
	 * @CookieValue(value="saveid", required=false) Cookie readCookie
	 * 이름이 saveid인 쿠키를 Cookie 타입으로 전달받습니다.
	 * 지정한 이름의 쿠키가 존재하지 않을 수도 있기 때문에 required=false로 설정해야 합니다.
	 * 즉, id 기억하기를 선택하지 않을 수도 있기 때문에  required=false로 설정해야 합니다.
	 * required=true 상태에서 지정한 이름을 가진 쿠키가 존재하지 않으면 스프링 MVC는 익셉션을 발생시킵니다.
	 * */
	// http://localhost:8088/myhome4/member/login
	// 로그인 폼 이동 
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv, 
							  @CookieValue(value = "saveid", required = false) Cookie readCookie) {
		if(readCookie != null) {
			mv.addObject("saveid", readCookie.getValue());
			logger.info("cookie time=" + readCookie.getMaxAge());
			logger.info(readCookie.getValue());
		}
		mv.setViewName("member/loginForm");
		return mv;
	}
	
	// http://localhost:8088/myhome4/member/join
	// 회원가입 폼 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "member/joinForm"; // WEB-INF/views/member/joinForm.jsp
	}
	
	// 회원가입 폼에서 아이디 검사
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public int idcheck(@RequestParam("id") String id) {
		return memberService.isId(id);
	}
}
