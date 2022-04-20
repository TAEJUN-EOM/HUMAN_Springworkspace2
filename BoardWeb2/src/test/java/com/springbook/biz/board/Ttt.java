package com.springbook.biz.board;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ttt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService)factory.getBean("boardService");
		
		Scanner sc = new Scanner(System.in);
		
		String title = "";
		String writer = "";
		String content = "";

		
		BoardVO vo = new BoardVO();
		
		System.out.println("새로은 글등록하기");
		
		System.out.println("제 목 : ");
		title = sc.nextLine();
		System.out.println("작성자 : ");
		writer = sc.nextLine();
		System.out.println("내 용 : ");
		content = sc.nextLine();
		
		//vo.setSeq(100);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		boardService.insertBoard(vo);
		
//		System.out.println("글 수정하기");
//		
//		vo.setSeq(26);
//		vo.setTitle("제목 글수정20210826");
//		vo.setContent("내용 글수정20210826");
//		boardService.updateBoard(vo);
		
//		System.out.println("글 삭제하기");
//		vo.setSeq(26);
//		boardService.deleteBoard(vo);
		
//		System.out.println("글 삭제하기");
//		vo.setSeq(25);
//		vo = boardService.getBoard(vo);
//		System.out.println(vo.toString());
		
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		for (BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
		
		factory.close();
	}

}
