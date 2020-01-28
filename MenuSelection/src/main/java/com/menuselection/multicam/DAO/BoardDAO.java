package com.menuselection.multicam.DAO;

import java.util.List;

import com.menuselection.multicam.bean.BoardBean;

public interface BoardDAO {

	public List<BoardBean> board() throws Exception;
	
	public List<BoardBean> content(String bno) throws Exception;
	
	public String confirmPW(String bno) throws Exception;
	
	public void update(BoardBean board) throws Exception;
	
	public void delete(String bno) throws Exception;
	
	public void writeNew(BoardBean board) throws Exception;
}
