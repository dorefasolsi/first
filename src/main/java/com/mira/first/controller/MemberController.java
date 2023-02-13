package com.mira.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mira.first.service.MemberService;
import com.mira.first.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;
	@Autowired private BCryptPasswordEncoder bcryptPasswordEncoder; 
	
	@GetMapping("/")
	public String startPage() {
		System.out.println("/");
		return "loginPage";
		
	}
	/*
	 * @GetMapping("/loginPage") public String loginPage() { return "/login";
	 * 
	 * }
	 */
	 
	@PostMapping("/login") 
	public String loginMember(Member member, ModelAndView mv, HttpServletRequest request, HttpSession session) {
		Member loginUser = memberService.loginMember(member);
		if(loginUser!=null && bcryptPasswordEncoder.matches(member.getMpw(), loginUser.getMpw())) { //
			mv.setViewName("index");
			session.setAttribute("loginUser", loginUser); 
			return "redirect:/boardList";
		}else { 
			return "/loginFail"; 
		} 
		
	}
	
	
	@GetMapping("/enrollPage") 
	public String enrollPage() { 
		return "/enroll"; 
	
	}
	
	@PostMapping("/enroll") public ModelAndView insertMember(Member member,
	ModelAndView mv) { 
	
		System.out.println(member.getMpw());
		
		String bcryptPw = bcryptPasswordEncoder.encode(member.getMpw());
			 
		member.setMpw(bcryptPw);
		
		int result = memberService.insertMember(member);
		 
		if(result == 1) { 
			System.out.println("성공"); 
			mv.addObject("msg", "success_register");
			mv.setViewName("redirect:/"); 
		} else {
			System.out.println("실패"); 
			mv.addObject("msg", "fail_register"); 
		} return mv; 
	
	}
		 
}
