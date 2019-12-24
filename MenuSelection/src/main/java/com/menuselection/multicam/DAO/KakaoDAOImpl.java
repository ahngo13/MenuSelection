package com.menuselection.multicam.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.menuselection.multicam.bean.KakaoBean;

@Repository
public class KakaoDAOImpl implements KakaoDAO{
	private static final String namespace="com.menuselection.multicam.kakaoMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<KakaoBean> kakao() throws Exception{

		return sqlSession.selectList(namespace+".kakao");

	}
}
