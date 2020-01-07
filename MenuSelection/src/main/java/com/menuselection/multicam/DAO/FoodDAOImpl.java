package com.menuselection.multicam.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.menuselection.multicam.bean.FoodBean;

@Repository
public class FoodDAOImpl implements FoodDAO {

	private static final String namespace="com.menuselection.multicam.foodMapper";

	@Inject
	private SqlSession sqlSession;

	@Override

	public List<FoodBean> food() throws Exception{

		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".food");

	}

}
