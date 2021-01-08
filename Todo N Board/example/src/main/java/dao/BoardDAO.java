package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.BoardVO;

@Repository
public class BoardDAO {
	 @Autowired
	 private SqlSession session;
	 // 21.01.08 작성
	 public List<BoardVO> boardList() {
	     List<BoardVO> boardList = session.selectList("BoardMapper.boardListAll");
	     return boardList;
	 }	
}
