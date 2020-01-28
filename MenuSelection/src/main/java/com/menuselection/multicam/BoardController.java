package com.menuselection.multicam;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.menuselection.multicam.bean.BoardBean;
import com.menuselection.multicam.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping(value = "/board/main", method = RequestMethod.GET)
	public String board(Model model) throws Exception {
		List<BoardBean> list;
		list = service.board();
		
		model.addAttribute("list", list);
		return "board";
		
	}
	
	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(Model model, @RequestParam(required=true) String bno) throws Exception {
		List<BoardBean> list;
		list = service.content(bno);
		
		model.addAttribute("list", list);
		return "content";
		
	}
	
	@RequestMapping(value = "/board/action", method = RequestMethod.POST)
	public String action(Model model, HttpServletRequest req) throws Exception {
		
		String status="error";
		String confirmPw=null;
		req.setCharacterEncoding("UTF-8");
		
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String passwd = req.getParameter("passwd");
		String action = req.getParameter("action");
		
		
		
		BoardBean board = new BoardBean();
		if(bno != null) {
			board.setBno(Integer.parseInt(bno));
			confirmPw = service.confirmPW(bno);
		}
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setPasswd(passwd);
		
		if(confirmPw!=null) {
			if(passwd.contentEquals(confirmPw)) {
				if(action.contentEquals("commit")) {
					service.update(board);
					status="update";
				} else {
					service.delete(bno);
					status="delete";
				}
				
			} else {
				status="fail";
			}
			
		} else {
			if(action.contentEquals("insert")) {
				service.writeNew(board);
				status="insert";
			} else {
				status="fail";
			}
		}
		
		
		
		model.addAttribute("status", status);
		
		return "boardAction";
		
	}
	
	@RequestMapping(value = "/board/writeBoard", method = RequestMethod.GET)
	public String write(Model model) throws Exception {
		
		
		return "writeBoard";
	}
	
		

}
