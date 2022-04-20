package com.springbook.biz.board;

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
		
		
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		boardService.insertBoard(vo);
		
		factory.close();
	}

}
