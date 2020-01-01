package com.menuselection.multicam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NaverController {
	
	@RequestMapping(value = "/naver", method = RequestMethod.GET)
	public String kakao(Model model, @RequestParam String value) throws Exception {

		model.addAttribute("value", value);
		return "naver";
		
	}
}
