package com.menuselection.multicam;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.menuselection.multicam.bean.FoodBean;
import com.menuselection.multicam.service.FoodService;

@Controller
public class FoodController {
	
	@Inject
	FoodService service;

	@RequestMapping(value = "/food", method = RequestMethod.GET)

	public String Food(Model model) throws Exception {
		List<FoodBean> list;
		list = service.food();
		
		model.addAttribute("list", list);
		return "foodMain";
		
	}

}


