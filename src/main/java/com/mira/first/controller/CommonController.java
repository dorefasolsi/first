package com.mira.first.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mira.first.model.CommonService;
import com.mira.first.vo.Board;
import com.mira.first.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "/login";
	}
	
	@PostMapping("/login")
	public String loginMember(Member member, ModelAndView mv, HttpServletRequest request, HttpSession session) {
		
		
		Member loginUser = commonService.loginMember(member);
		
		if(loginUser!=null && member.getMpw().equals(loginUser.getMpw())) {
//			mv.setViewName("index");
			
			session.setAttribute("loginUser", loginUser);
			return "redirect:/boardList";
			
			
			
		}else {
			return "/loginFail";
		}
	}
	
	@GetMapping("/boardList")
	public ModelAndView boardList(ModelAndView mv) {
		
		ArrayList<Board> blist = commonService.boardList();
		
		if(blist.isEmpty()) {
			System.out.println("게시글 없음");
		}else {
			mv.addObject("blist", blist);	
		}
		mv.setViewName("boardListView");
		return mv;
	}
	
	@GetMapping("/boardWritePage")
	public String boardWritePage() {
		return "boardInsertView";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, ModelAndView mv, HttpSession session) {
		
		Member m = (Member) session.getAttribute("loginUser");
		board.setMid(m.getMid());
		
		int bd = commonService.insertBoard(board);
		
		return "redirect:/boardList";
	}
	
	@GetMapping("/detailBoard")
	public ModelAndView detailBoard(Board board, ModelAndView mv) {
		
		
		Board detailBoard = commonService.detailBoard(board);
		
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardDetailView");
		
		
		return mv;
		
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		System.out.println(board);
		int result = commonService.deleteBoard(board);
		System.out.println("g");
		System.out.println(result);
		return "redirect:/boardList";
	}

	
	@GetMapping("updateBoardPage")
	public ModelAndView updateBoardPage(Board board, ModelAndView mv) {
		
		
		Board detailBoard = commonService.detailBoard(board);
		System.out.println(detailBoard);
		System.out.println("넘어옴?");
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardDetailView");
		int result = commonService.updateBoard(board);
		
		return mv;
	}
	
	
	
	
}
