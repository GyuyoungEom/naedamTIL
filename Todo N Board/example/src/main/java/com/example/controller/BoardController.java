package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.BoardDAO;
import vo.BoardVO;


@RestController
@SpringBootApplication(scanBasePackages = {"dao"})
@CrossOrigin(origins = "*")
public class BoardController {
	
	@Autowired(required=true)
	BoardDAO dao;

	@RequestMapping("/board")
	public List<BoardVO> getBoardList(BoardVO bvo) {
		List<BoardVO> list = dao.boardList();	
		return list;
	}
	
//	@RequestMapping(value="/board/insert/{id}/{title}/{content}", method=RequestMethod.POST)
//	public List<BoardVO> boardInsert(@PathVariable String id, @PathVariable String title, @PathVariable String content){
//		BoardVO bvo = new BoardVO();
//		bvo.setId(id);
//		bvo.setTitle(title);
//		bvo.setContent(content);
//		dao.insertBoard(bvo);
//		return dao.boardList();
//	}
	@RequestMapping(value="/board/insert/{id}/{title}/{content}", method=RequestMethod.POST)
	public void boardInsert(@PathVariable String id, @PathVariable String title, @PathVariable String content){
		BoardVO bvo = new BoardVO();
		bvo.setId(id);
		bvo.setTitle(title);
		bvo.setContent(content);
		dao.insertBoard(bvo);
	}
	
	@RequestMapping(value="/board/delete/{boardNum}", method=RequestMethod.POST)
	public void boardDelete(@PathVariable int boardNum) {
		dao.deleteBoard(boardNum);
	}
	
	@RequestMapping(value="/board/detail/{boardNum}", method=RequestMethod.GET)
	public BoardVO boardDetail(@PathVariable int boardNum) {
		return dao.getOne(boardNum);
	}
	
	@RequestMapping(value="/board/update/{boardNum}/{title}/{content}", method=RequestMethod.POST)
	public void boardUpdate(@PathVariable int boardNum, @PathVariable String title, @PathVariable String content) {
		BoardVO vo = new BoardVO();
		vo.setBoardNum(boardNum);
		vo.setContent(content);
		vo.setTitle(title);
		dao.updateBoard(vo);
	}
	
	@RequestMapping(value="/board/{searchType}/{keyword}", method=RequestMethod.GET)
	public List<BoardVO> searchBoard(@PathVariable String searchType, @PathVariable String keyword){
		return dao.searchBoard(searchType, keyword);
	}

}
