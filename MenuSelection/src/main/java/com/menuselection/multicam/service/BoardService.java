package com.menuselection.multicam.service;

import java.util.List;
import com.menuselection.multicam.bean.BoardBean;

public interface BoardService {

	public List<BoardBean> board() throws Exception;

	public List<BoardBean> content(String bno) throws Exception;
	
}

