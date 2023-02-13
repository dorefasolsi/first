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
		return "loginPage";
		
	}

	 
	@PostMapping("/login") 
	public ModelAndView loginMember(Member member, ModelAndView mv, HttpServletRequest request, HttpSession session) {
		
		Member loginUser = memberService.loginMember(member);
		if(loginUser!=null && bcryptPasswordEncoder.matches(member.getMpw(), loginUser.getMpw())) { //
			
			session.setAttribute("loginUser", loginUser); 
			mv.setViewName("redirect:/boardList");
//			return "redirect:/boardList";
			return mv;
		}else { 
			mv.addObject("msg", "success_register");
			System.out.println("로그인 실패");
//			return "/loginFail"; 
			mv.setViewName("/loginFail");
			return mv;
		} 
		
	}
	
	
	@GetMapping("/enrollPage") 
	public String enrollPage() { 
		return "/enrollPage"; 
	
	}
	
	@PostMapping("/enroll") 
	public ModelAndView insertMember(Member member, ModelAndView mv) { 
	
		
		String bcryptPw = bcryptPasswordEncoder.encode(member.getMpw());
		
		
		member.setMpw(bcryptPw);
		
		
		int result = memberService.insertMember(member);
		 
		if(result == 1) { 
			mv.addObject("msg", "success_register");
			mv.setViewName("redirect:/"); 
		} else {
			mv.addObject("msg", "fail_register"); 
		} return mv; 
	
	}
		 
}
