package project.healingcamp.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.healingcamp.vo.UserVo;



@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo login(UserVo vo) {
		return sqlSession.selectOne("project.hilingcamp.userMapper.login", vo);
	}
	public int selectById(String Id) {
		return sqlSession.selectOne("project.hilingcamp.userMapper.selectById", Id);
		
	}
	
}
