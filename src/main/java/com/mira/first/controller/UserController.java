package com.mira.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mira.first.service.UserService;
import com.mira.first.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired private UserService userService;
	@Autowired private BCryptPasswordEncoder bcryptPasswordEncoder; 
	
	@GetMapping("/")
	public ModelAndView startPage(@SessionAttribute(name="loginUser", required=false) User loginUser, 
									HttpSession session, ModelAndView mv) {		

		if(loginUser == null) {
			
			mv.setViewName("loginPage");
			return mv;
		} else {
			mv.setViewName("redirect:/board/list");
			return mv;
		}
		
	}

	 
	@PostMapping("/login") 
	public ModelAndView loginUser(User user, ModelAndView mv, HttpServletRequest request, HttpSession session) {
		
		User loginUser = userService.loginUser(user);
		if(loginUser!=null && bcryptPasswordEncoder.matches(user.getUserPw(), loginUser.getUserPw())) { //
			
			session.setAttribute("loginUser", loginUser); 
			session.setMaxInactiveInterval(1800); //30분 뒤 세션 remove
			mv.setViewName("redirect:/board/list");
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
	public ModelAndView insertUser(User user, ModelAndView mv) { 
	
		
		String bcryptPw = bcryptPasswordEncoder.encode(user.getUserPw());
		
		
		user.setUserPw(bcryptPw);
		
		user.setRole("ROLE_USER");
		int result = userService.insertUser(user);
		 
		if(result == 1) { 
			mv.addObject("msg", "success_register");
			mv.setViewName("redirect:/"); 
		} else {
			mv.addObject("msg", "fail_register"); 
		} return mv; 
	
	}
		 
}
