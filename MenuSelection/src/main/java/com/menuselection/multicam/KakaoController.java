package com.menuselection.multicam;


import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.menuselection.multicam.bean.KakaoBean;
import com.menuselection.multicam.common.KakaoRestApiHelper;
import com.menuselection.multicam.service.KakaoService;

@Controller
public class KakaoController {
	
	@Inject
	KakaoService service;

	@RequestMapping(value = "/kakao", method = RequestMethod.GET)
	public String kakao(Model model, @RequestParam String keyword) throws Exception {
//		List<KakaoBean> list;
//		list = service.kakao();
		KakaoRestApiHelper helper = new KakaoRestApiHelper();
//		ResponseEntity<String> result = helper.getKeywordMap(keyword);
		KakaoBean result = helper.getKeywordMap(keyword);
		model.addAttribute("result", result);
		return "kakao";
		
	}
}
