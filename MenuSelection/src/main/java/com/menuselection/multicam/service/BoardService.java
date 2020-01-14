package com.menuselection.multicam.service;

import java.util.List;
import com.menuselection.multicam.bean.BoardBean;

public interface BoardService {

	public List<BoardBean> board() throws Exception;

	public List<BoardBean> content(String bno) throws Exception;
	
	public String confirmPW(String bno) throws Exception;

	public void update(String bno, String title, String content) throws Exception;

	public void delete(String bno) throws Exception;
	
}

