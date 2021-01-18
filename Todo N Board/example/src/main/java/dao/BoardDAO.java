package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	     return session.selectList("BoardMapper.boardListAll");
	 }	
	 // 21.01.15 작성
	 public void insertBoard(BoardVO vo) {
		 session.insert("BoardMapper.boardCreate",vo);
	 }
	 
	 public void deleteBoard(int boardNum) {
		 session.delete("BoardMapper.boardDelete",boardNum);
	 }
	 
	 public BoardVO getOne(int boardNum) {
		 return session.selectOne("BoardMapper.boardOne", boardNum);
	 }
	 
	 public void updateBoard(BoardVO vo) {
		 session.update("BoardMapper.updateBoard", vo);
	 }
	 
	 public List<BoardVO> searchBoard(String searchType, String keyword) {
		 Map<String,String> map = new HashMap<>();
		 map.put("searchType", searchType);
		 map.put("keyword", keyword);
		 return session.selectList("BoardMapper.searchBoard",map);
	 }
}
