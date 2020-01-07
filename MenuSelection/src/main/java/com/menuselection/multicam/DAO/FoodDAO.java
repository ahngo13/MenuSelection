package com.menuselection.multicam.DAO;

import java.util.List;

import com.menuselection.multicam.bean.FoodBean;

public interface FoodDAO {

	public List<FoodBean> food() throws Exception;
	
}
