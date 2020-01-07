package com.menuselection.multicam;

import java.util.List;
import javax.inject.Inject;
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
	public String content(Model model, @RequestParam String bno) throws Exception {
		List<BoardBean> list;
		list = service.content(bno);
		
		model.addAttribute("list", list);
		return "content";
		
	}

}
