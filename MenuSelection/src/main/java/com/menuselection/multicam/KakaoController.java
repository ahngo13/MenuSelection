package com.menuselection.multicam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.menuselection.multicam.bean.KakaoBean;
import com.menuselection.multicam.common.KakaoRestApiHelper;

@Controller
public class KakaoController {
	
	//카카오맵 메인
	@RequestMapping(value = "/kakao/main", method = RequestMethod.GET)
	public String kakaoMain(Model model, @RequestParam(required=false) String keyword) throws Exception {

		KakaoRestApiHelper helper = new KakaoRestApiHelper();
		
		//키워드 값이 있을 경우
		if(keyword != null && "".equals(keyword)){
			KakaoBean result = helper.getKeywordMap(keyword);
			model.addAttribute("result", result);
		}
		return "kakao";
	}
	
	//카카오맵 주소 검색
	@RequestMapping(value = "/kakao/address-search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView kakaoAddressSearch(HttpServletRequest request,
    		HttpServletResponse response, Model model, 
    		@RequestParam(required=false) String keyword,
    		@RequestParam(required=false, defaultValue = "1") int page) throws Exception {
		KakaoRestApiHelper helper = new KakaoRestApiHelper();
		
		ModelAndView mv = null;
		
		//키워드 값이 있을 경우
		if(keyword != null && !"".equals(keyword)){
			KakaoBean kakaoBean = helper.getAddressMap(keyword, page);
			//지번주소와 도로명 주소 구분
			if(kakaoBean.getDocumentList().size()>0) {
				if("ROAD".equals(kakaoBean.getDocumentList().get(0).getAddressType())) {
					mv = new ModelAndView("roadAddressList");
				}else{
					mv = new ModelAndView("addressList");
				}
			}
			mv.addObject("kakaoBean", kakaoBean);
			mv.addObject("documentList", kakaoBean.getDocumentList());
			mv.addObject("page", page);
		}
		return mv;
	}
	
	//카카오맵 카테고리 검색
	@RequestMapping(value = "/kakao/category-search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView kakaoCategorySearch(HttpServletRequest request,
    		HttpServletResponse response, Model model, 
    		@RequestParam(required=true) String x,
    		@RequestParam(required=true) String y,
    		@RequestParam(required=true, defaultValue = "1000") String radius,
    		@RequestParam(required=false, defaultValue = "1") int page) throws Exception {
		KakaoRestApiHelper helper = new KakaoRestApiHelper();
		
		ModelAndView mv = null;
		
			KakaoBean kakaoBean = helper.getCategoryMap(x, y, Integer.parseInt(radius));
			mv = new ModelAndView("placeList");
			
			mv.addObject("placeBean", kakaoBean);
			mv.addObject("placeList", kakaoBean.getDocumentList());
		
		return mv;
	}
}