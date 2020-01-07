package com.menuselection.multicam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.menuselection.multicam.DAO.FoodDAO;
import com.menuselection.multicam.bean.FoodBean;

@Service
public class FoodServiceImpl implements FoodService {

	@Inject
	private FoodDAO dao;

	@Override
	public List<FoodBean> food() throws Exception {
		// TODO Auto-generated method stub
		return dao.food();
	}




}
