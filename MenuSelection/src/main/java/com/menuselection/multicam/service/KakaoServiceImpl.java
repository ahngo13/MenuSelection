package com.menuselection.multicam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.menuselection.multicam.DAO.KakaoDAO;
import com.menuselection.multicam.bean.KakaoBean;

@Service
public class KakaoServiceImpl implements KakaoService{
	
	@Inject
	private KakaoDAO dao;

	@Override
	public List<KakaoBean> kakao() throws Exception {
		return dao.kakao();
	}
}
