package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.AppUserVO;

@Repository
public class AppUserDAO {
	@Autowired
	private SqlSession session;
	
	// 21.01.12 작성
	public void signup(AppUserVO vo) {
		if(session.insert("AppUserMapper.insertUser",vo)!=1) {
			System.out.println("User insert 실패");
		}else{
			session.insert("AppUserMapper.insertUser",vo);
		}
	}
}
