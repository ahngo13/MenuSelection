package com.menuselection.multicam.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WorldCupController {

	@RequestMapping(value = "/worldcup/main", method = RequestMethod.GET)

	public String worldcupmain(Model model) throws Exception {

		return "worldcupmain";

	}

}
