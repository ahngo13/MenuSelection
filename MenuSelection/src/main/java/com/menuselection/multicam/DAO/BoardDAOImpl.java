package com.menuselection.multicam.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.menuselection.multicam.bean.BoardBean;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final String namespace="com.menuselection.multicam.boardMapper";

	@Inject
	private SqlSession sqlSession;

	@Override

	public List<BoardBean> board() throws Exception{

		return sqlSession.selectList(namespace+".board");

	}
	
	public List<BoardBean> content(String bno) throws Exception{

		return sqlSession.selectList(namespace+".content", bno);

	}
	
	public String confirmPW(String bno) throws Exception {
		
		return sqlSession.selectOne(namespace+".confirmPW", bno);
	}

	public void update(String bno, String title, String content) throws Exception {
		BoardBean board = new BoardBean();
		board.setBno(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		sqlSession.update(namespace+".update", board);
	}
	
	public void delete(String bno) throws Exception {
		sqlSession.delete(namespace+".delete", bno);
	}
		
}
