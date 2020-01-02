package com.menuselection.multicam;


import javax.inject.Inject;
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
import com.menuselection.multicam.service.KakaoService;

@Controller
public class KakaoController {
	
	@Inject
	KakaoService service;
	
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
    		HttpServletResponse response, Model model, @RequestParam(required=false) String keyword) throws Exception {
		KakaoRestApiHelper helper = new KakaoRestApiHelper();
		
		ModelAndView mv = new ModelAndView("addressList");
		
		//키워드 값이 없을 경우
		if(keyword != null || "".equals(keyword)){
			KakaoBean kakaoBean = helper.getAddressMap(keyword);
			/*for(int i=0; i<kakaoBean.getDocumentList().size(); i++) {
				kakaoBean.getDocumentList().get(i).getAddress();
				kakaoBean.getDocumentList().get(i).getAddressName();
			}*/
			
			mv.addObject("kakaoBean", kakaoBean);
			mv.addObject("documentList", kakaoBean.getDocumentList());
		}
		
		return mv;
	}
	
	/* @RequestMapping(value="/hospital-list")
	    public ModelAndView getHospitalList(HttpServletRequest request, HttpServletResponse response,
	    		@RequestParam(value="currentPage", defaultValue ="1" ) int currentPage,
	    		@RequestParam(value="rowsPerPage", defaultValue ="5" ) int rowsPerPage,
	    		@RequestParam(value="orderType", defaultValue ="1" ) String orderType,
	    		@RequestParam(value="searchKeyword", defaultValue ="" ) String searchKeyword) throws Exception{
	    	
	    	ModelAndView mv = new ModelAndView("list/hospitalList");
	    	HashMap<String, Object>paramMap = new HashMap<String, Object>();
	    	int startCount = (currentPage - 1) * rowsPerPage ;
	    	String totalRowCnt = "";
	    	paramMap.put("startCount", startCount);
	    	paramMap.put("orderType", orderType);
	    	searchKeyword = URLDecoder.decode(searchKeyword, "UTF-8");
	    	paramMap.put("searchKeyword", searchKeyword);
	    	
	    	List<HospitalVO> list = mainService.selectHospitalList(paramMap);
	    	
	    	if(list.size() > 0){
	    		totalRowCnt = list.get(0).getTotalCount() + "";
	    	}
	    	mv.addObject("list",list);
	    	mv.addObject("currentPage", currentPage);
	    	mv.addObject("rowsPerPage", rowsPerPage);
	    	mv.addObject("totalRowCnt", totalRowCnt);
	    	
	    	return mv;
	    }*/
	
	 /*	@RequestMapping("/login-submit")
 	@ResponseBody
    public String loginSubmit(HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam(value="email") String email,
 			@RequestParam(value="password") String password,
 			Model model)
            throws ServletException, IOException {
 		String result = "";
 		HashMap<String, Object> paramMap = new HashMap<String, Object>();
 		
 		try {
 			paramMap.put("email", email);
 			paramMap.put("password", CryptoUtil.SHA256(password));
				HttpSession session = request.getSession();
			memberVO user = memberService.selectMember(paramMap);
			if(user != null || "".equals(user)){
				session.setAttribute("user", user);
				model.addAttribute("user", user);
				model.addAttribute("email", email);
				result = "200";
			}else{
				result = "401";
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
 		return result;	
    }*/
	
	
}