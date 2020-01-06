package com.menuselection.multicam.DAO;

import java.util.List;

import com.menuselection.multicam.bean.BoardBean;

public interface BoardDAO {

	public List<BoardBean> board() throws Exception;
	
}
