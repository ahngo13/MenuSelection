package com.menuselection.multicam.common;

import java.net.URI;
import java.net.URLEncoder;

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
	public ResponseEntity<String> getKeywordMap(String keyword) throws Exception{
		
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
			
	        String queryString = "?query="+URLEncoder.encode(keyword, "UTF-8"); //+"&page="+searchVO.getCurrentPage()+"&size="+searchVO.getPageSize();
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();

	        headers.add("Authorization", "KakaoAK " + restApiKey);
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

	        URI url = URI.create(API_SERVER_HOST+SEARCH_PLACE_KEYWORD_PATH+queryString);
	        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
	        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);
			return re;
		
	}
	
}