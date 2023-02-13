package com.mira.first;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mira.first.mapper.BoardMapper;
import com.mira.first.mapper.MemberMapper;
import com.mira.first.vo.Board;
import com.mira.first.vo.Member;

@SpringBootTest
public class MapperTest {

	@Autowired
	private MemberMapper memberMapper;
	private BoardMapper boardMapper;
	
//	@Test
//	public void testInsert() {
//		Board b1 = new Board();
//		b1.setBtitle("TITLE");
//		b1.setBcontent("content");
//		System.out.println(b1);
//		
//		memberMapper.insertBoard(b1);		
//		System.out.println("----------------");
//	}
	
//	@Test
//	public void TestMemberInsert() {
//		Member m1 = new Member();
//		m1.setMid("dddasdfasdfadf");
//		m1.setMpw("ddd");
//		m1.setMname("ddd");
//		System.out.println(m1);
//		
//		memberMapper.insertMember(m1);
//		System.out.println("----");
//	}
//	
//	@Test
//	public void testLogin() {
//		Member m1 = new Member();
//		m1.setMid("aaa");
//		m1.setMpw("aaa");
//		m1.setMname("aaa");
//		System.out.println(m1);
//		
//		Member m2 = memberMapper.loginMember(m1);
//		
//		System.out.println(m2);
//	}
//	
//	@Test
//	public void testViewBoard() {
//		Board b1 = new Board();
//		
//		ArrayList<Board> list = memberMapper.boardList();
//		
//		System.out.println(list.size());
//		
//	}
//	
//	@Test
//	public void testDelete() {
//		Board b1 = new Board();
//		b1.setBno(4);
//		
//		int result = memberMapper.deleteBoard(b1);
//		
//		System.out.println(result);
//	}
//	
//	@Test
//	public void testUpdate() {
//		Board b1 = new Board();
//		b1.setBno(6);
//		b1.setBtitle("dd");
//		b1.setBcontent("dd");
//		
//		int result = memberMapper.updateBoard(b1);
//		System.out.println(result);
//	}
	
}
