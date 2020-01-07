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

		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".board");

	}
	
	public List<BoardBean> content(String bno) throws Exception{

		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".content", bno);

	}

}
