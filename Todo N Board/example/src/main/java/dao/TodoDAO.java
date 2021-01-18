package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TodoVO2;

@Repository
public class TodoDAO {
	
	@Autowired
	SqlSession session;
	
	// 21.01.14 작성
	public List<TodoVO2> getList(){
		List<TodoVO2> list = session.selectList("TodoMapper.todoList");
		return list;
	}
	
//	public void insertTodo(TodoVO2 vo) {
//		int result = session.insert("TodoMapper.insertTodo", vo);
//		if (result==1) {
//			session.insert("TodoMapper.insertTodo", vo);
//		} else {
//			System.out.println("todo insert 오류");
//		}
//	}
//	
	public void insertTodo(String content) {
		session.insert("TodoMapper.insertTodo", content);
	}
	
	public void deleteTodo(int id) {
		session.delete("TodoMapper.deleteTodo",id);
	}
	
	public void deleteAllTodo() {
		session.delete("TodoMapper.deleteAllTodo");

	}
	public int todoSize() {
		return session.selectOne("TodoMapper.size");
	}
}
