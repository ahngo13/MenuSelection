package com.menuselection.multicam.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KakaoRestApiHelper {
	
	public String getAddressKakao(String keyword) {
		
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
			JsonArray jsonArray = (JsonArray) jsonObject.get("documents");
			
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
}