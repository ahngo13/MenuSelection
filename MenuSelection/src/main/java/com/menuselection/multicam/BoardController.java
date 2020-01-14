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
	public String action(Model model, HttpServletRequest httpServletRequest) throws Exception {
		
		String status="error";
		
		String bno = httpServletRequest.getParameter("bno");
		String title = httpServletRequest.getParameter("title");
		String content = httpServletRequest.getParameter("content");
		String passwd = httpServletRequest.getParameter("passwd");
		String action = httpServletRequest.getParameter("action");
		
		String confirmPw = service.confirmPW(bno);
		
		if(passwd.contentEquals(confirmPw)) {
			if(action.contentEquals("commit")) {
				service.update(bno, title, content);
				status="update";
			} else {
				service.delete(bno);
				status="delete";
			}
			
		} else {
			status="fail";
		}
		
		
		model.addAttribute("status", status);
		
		
		return "boardAction";
		
	}
		

}
