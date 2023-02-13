package com.mira.first.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mira.first.service.BoardService;
import com.mira.first.vo.Board;
import com.mira.first.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	
	@Autowired 
	private BoardService boardService;
	  
	@GetMapping("/boardList") 
	public ModelAndView boardList(ModelAndView mv) {
		System.out.println("보드리스트");
	  
		ArrayList<Board> blist = boardService.boardList();
		  
		if(blist.isEmpty()) { }else { mv.addObject("blist", blist); }
		mv.setViewName("boardListView"); return mv; 
		}
		  
		@GetMapping("/boardWritePage") public String boardWritePage() { 
		  
		return "boardInsertView"; 
	}
	  
	@PostMapping("/insertBoard") 
	public String insertBoard(Board board, ModelAndView mv, HttpSession session) {
		  
		Member m = (Member) session.getAttribute("loginUser");
		board.setMid(m.getMid());
		 
		int bd = boardService.insertBoard(board);
		  
		return "redirect:/boardList"; 
	}
	  
	@GetMapping("/detailBoard") 
	public ModelAndView detailBoard(Board board, ModelAndView mv) {
	  
		Board detailBoard = boardService.detailBoard(board);
			  
		mv.addObject("detailBoard", detailBoard); mv.setViewName("boardDetailView");
			  
			  
		return mv;
	  
	}
	 
	@GetMapping("/deleteBoard") 
	public String deleteBoard(Board board) { 
		int result = boardService.deleteBoard(board); 
		return "redirect:/boardList"; 
	}
	  
	  
	@GetMapping("/updateBoardPage") 
	public ModelAndView updateBoardPage(Board board, ModelAndView mv) { 
		Board detailBoard = boardService.detailBoard(board); 
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardUpdateView");
		 
		return mv; 
	}
		  
		  
	@PostMapping("/updateBoard") 
	public String updateBoard(Board board,ModelAndView mv) { 
		System.out.println(board);
		  
		int result = boardService.updateBoard(board);
		System.out.println(result);
		  
		return "redirect:/boardList"; 
	}	
	 
}
