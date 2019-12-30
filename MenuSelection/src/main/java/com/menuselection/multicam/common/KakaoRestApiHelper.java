package com.menuselection.multicam.common;

import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.menuselection.multicam.bean.DocumentBean;
import com.menuselection.multicam.bean.KakaoBean;

public class KakaoRestApiHelper {
//	@Value("${kakao.restapi.key}")
	private static final String API_SERVER_HOST  = "https://dapi.kakao.com";
    private static final String SEARCH_PLACE_KEYWORD_PATH = "/v2/local/search/keyword.json";
    private String restApiKey = "600f124241db7f169bbb637ce49d6472";;
	
	/*
	 * 카카오맵 카테고리로 장소 검색
	 * */
	public String getCategoryMap() {
		
		try {
			final String APP_KEY = "600f124241db7f169bbb637ce49d6472";
//			final String API_URL = "https://dapi.kakao.com//v2/local/search/" + keyword;
			final String API_URL = "https://dapi.kakao.com/v2/local/search/category.json?category_group_code=PM9&rect=127.0561466,37.5058277,127.0602340,37.5142554";
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK " + APP_KEY);
			
			MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
	//		parameters.add("X", longi);
	//		parameters.add("y", lati);
//			parameters.add("category_group_code", "FD6");
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate.exchange(API_URL, HttpMethod.GET, new HttpEntity(headers), String.class);
			
			System.out.println(result.getBody());
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(result.getBody());
//			JsonArray jsonArray = (JsonArray) jsonObject.get("documents");
			
//			JsonObject local = (JsonObject) jsonArray.get(0);
//			JsonObject jsonArray1 = (JsonObject) local.get("address");
//			String localAddress = (String)jsonArray1.get("address_name").toString();
			
			return "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}	
		
	}
	
	/*
	 * 카카오맵 키워드로 장소 검색
	 * */
	public KakaoBean getKeywordMap(String keyword) throws Exception{
		
			/*
			 * final String APP_KEY = "600f124241db7f169bbb637ce49d6472"; // final String
			 * API_URL = "https://dapi.kakao.com//v2/local/search/" + keyword; final String
			 * API_URL =
			 * "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000&query="+
			 * URLEncoder.encode(keyword, "UTF-8");
			 * 
			 * HttpHeaders headers = new HttpHeaders(); headers.add("Authorization",
			 * "KakaoAK " + APP_KEY); // headers.add("query", "카카오프렌즈");
			 * 
			 * // MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String,
			 * String>(); // parameters.add("X", longi); // parameters.add("y", lati); //
			 * parameters.add("category_group_code", "FD6"); // parameters.add("query",
			 * "카카오프렌즈");
			 * 
			 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<String> result
			 * = restTemplate.exchange(API_URL, HttpMethod.GET, new HttpEntity(headers),
			 * String.class);
			 * 
			 * System.out.println(result.getBody()); JsonParser jsonParser = new
			 * JsonParser(); JsonObject jsonObject = (JsonObject)
			 * jsonParser.parse(result.getBody()); // JsonArray jsonArray = (JsonArray)
			 * jsonObject.get("documents");
			 * 
			 * // JsonObject local = (JsonObject) jsonArray.get(0); // JsonObject jsonArray1
			 * = (JsonObject) local.get("address"); // String localAddress =
			 * (String)jsonArray1.get("address_name").toString();
			 */			
			KakaoBean kakaoBean = new KakaoBean();	
		
	        String queryString = "?query="+URLEncoder.encode(keyword, "UTF-8"); //+"&page="+searchVO.getCurrentPage()+"&size="+searchVO.getPageSize();
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();

	        headers.add("Authorization", "KakaoAK " + restApiKey);
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

	        URI url = URI.create(API_SERVER_HOST+SEARCH_PLACE_KEYWORD_PATH+queryString);
	        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
	        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);
	        
	        JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(re.getBody());
			JsonArray jsonArrayDocuments = (JsonArray) jsonObject.get("documents");
			JsonObject meta = (JsonObject)jsonObject.get("meta");
			JsonObject sameName = (JsonObject) meta.get("same_name");
			
			
			int pageableCount = 0;
			if(meta.get("pageable_count") != null && !"".equals(meta.get("pageable_count").toString())){
				pageableCount = Integer.parseInt(meta.get("pageable_count").toString());
			}
			
			int totalCount = 0; 
			if(meta.get("total_count") != null && !"".equals(meta.get("total_count").toString())) {
				totalCount = Integer.parseInt(meta.get("total_count").toString());
			}
			String isEndToString = "";
			if(meta.get("is_end") != null && !"".equals(meta.get("is_end").toString())) {
				isEndToString = meta.get("is_end").toString();
			}


			String keywordName = "";
			if(sameName.get("keyword") != null && !"".equals(sameName.get("keyword").toString())) {
				keywordName = sameName.get("keyword").toString();
			}
			String selectedRegion = "";
			if(sameName.get("selected_region") != null && !"".equals(sameName.get("selected_region").toString())) {
				selectedRegion = sameName.get("selected_region").toString();
			}
			String region = ""; 
			if(sameName.get("region") != null && !"".equals(sameName.get("region").toString())) {
				region = sameName.get("region").toString();
			}
			Boolean isEnd;
			
			kakaoBean.setRegion(region);			
			kakaoBean.setKeyword(keywordName);			
			kakaoBean.setSelectedRegion(selectedRegion);	
			kakaoBean.setPageableCount(pageableCount);
			kakaoBean.setTotalCount(totalCount);
			if("true".equals(isEndToString)){
				isEnd = true;
			}else{
				isEnd = false;
			}
			kakaoBean.setIsEnd(isEnd);
			
			
			ArrayList<DocumentBean> documentList = new ArrayList<DocumentBean>();

			for(int i=0; i < jsonArrayDocuments.size(); i++) {
				DocumentBean documentBean = new DocumentBean();
				JsonObject documents = (JsonObject) jsonArrayDocuments.get(i);
				documentBean.setPlaceName(documents.get("place_name").toString());
				documentBean.setDistance(documents.get("distance").toString());
				documentBean.setPlaceUrl(documents.get("place_url").toString());
				documentBean.setCategoryName(documents.get("category_name").toString());
				documentBean.setAddressName(documents.get("address_name").toString());
				documentBean.setRoadAddressName(documents.get("road_address_name").toString());
				documentBean.setId(documents.get("id").toString());
				documentBean.setPhone(documents.get("phone").toString());
				documentBean.setCategoryGroupCode(documents.get("category_group_code").toString());
				documentBean.setCategoryGroupName(documents.get("category_group_name").toString());
				documentBean.setX(documents.get("x").toString());
				documentBean.setY(documents.get("y").toString());
				
				documentList.add(documentBean);
			}
			

			
			kakaoBean.setDocumentList(documentList);
			
//			JsonObject jsonArray1 = (JsonObject) local.get("address");
//			String localAddress = (String)jsonArray1.get("address_name").toString();

			
			return kakaoBean;
		
	}
	
}