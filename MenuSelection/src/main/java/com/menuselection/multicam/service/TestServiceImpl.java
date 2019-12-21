package com.menuselection.multicam.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.menuselection.multicam.DAO.TestDAO;
import com.menuselection.multicam.bean.TestBean;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;

	@Override
	public List<TestBean> test() throws Exception {
		// TODO Auto-generated method stub
		return dao.test();
	}




}
