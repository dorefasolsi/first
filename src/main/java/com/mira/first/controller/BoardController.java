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
import com.mira.first.vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	
	@Autowired 
	private BoardService boardService;
	  
	@GetMapping("/board/list") 
	public ModelAndView boardList(ModelAndView mv) {
	  
		ArrayList<Board> blist = boardService.boardList();
		  
		if(blist.isEmpty()) { }else { mv.addObject("blist", blist); }
		mv.setViewName("boardListView"); return mv; 
		}
		  
		@GetMapping("/boardWritePage") public String boardWritePage() { 
		  
		return "boardInsertView"; 
	}
	  
	@PostMapping("/board/insert") 
	public String insertBoard(Board board, ModelAndView mv, HttpSession session) {
		  
		User m = (User) session.getAttribute("loginUser");
		board.setUserId(m.getUserId());
		 
		int bd = boardService.insertBoard(board);
		  
		return "redirect:/board/list"; 
	}
	  
	@GetMapping("/board/detail") 
	public ModelAndView detailBoard(Board board, ModelAndView mv) {
	  
		Board detailBoard = boardService.detailBoard(board);
			  
		mv.addObject("detailBoard", detailBoard); mv.setViewName("boardDetailView");
			  
			  
		return mv;
	  
	}
	 
	@DeleteMapping("/board/delete/{boardNo}") 
	public String deleteBoard(@PathVariable("boardNo") int boardNo) { 
		Board board = new Board();
		board.setBoardNo(boardNo);
		int result = boardService.deleteBoard(board); 
		return "redirect:/board/list"; 
	}
	  
	  
	@PostMapping("/board/updatePage/{boardNo}") 
	public ModelAndView updateBoardPage(@PathVariable("boardNo") int boardNo, ModelAndView mv) { 
		Board board = new Board();
		board.setBoardNo(boardNo);
		Board detailBoard = boardService.detailBoard(board); 
		
		mv.addObject("detailBoard", detailBoard);
		mv.setViewName("boardUpdateView");
		 
		return mv; 
	}
		  
		  
	@PutMapping("/board/update") 
	public String updateBoard(Board board, ModelAndView mv) { 
		int result = boardService.updateBoard(board);		  
		return "redirect:/board/list"; 
	}
	 
}
