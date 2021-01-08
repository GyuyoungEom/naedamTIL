package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDAO;
import vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	
	@RequestMapping("/board")
	public ModelAndView getBoardList(BoardVO bvo) {
		ModelAndView mav = new ModelAndView();
		List<BoardVO> list = dao.boardList();
		mav.addObject("boardList", list);
		mav.setViewName("index");
		return mav;
	}
}
