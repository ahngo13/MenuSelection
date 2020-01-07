package com.menuselection.multicam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.menuselection.multicam.DAO.BoardDAO;
import com.menuselection.multicam.bean.BoardBean;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardBean> board() throws Exception {
		// TODO Auto-generated method stub
		return dao.board();
	}

	@Override
	public List<BoardBean> content(String bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.content(bno);
	}


}
