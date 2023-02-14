package com.mira.first.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 
	@DeleteMapping("/deleteBoard/{bno}") 
	public String deleteBoard(@PathVariable("bno") int bno) { 
		Board board = new Board();
		board.setBno(bno);
		int result = boardService.deleteBoard(board); 
		return "redirect:/boardList"; 
	}
	  
	  
	@PostMapping("/updateBoardPage/{bno}") 
	public ModelAndView updateBoardPage(@PathVariable("bno") int bno, ModelAndView mv) { 
		Board board = new Board();
		board.setBno(bno);
		Board detailBoard = boardService.detailBoard(board); 
		
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardUpdateView");
		 
		return mv; 
	}
		  
		  
	@PutMapping("/updateBoard") 
	public String updateBoard(Board board, ModelAndView mv) { 
		int result = boardService.updateBoard(board);		  
		return "redirect:/boardList"; 
	}
	 
}
