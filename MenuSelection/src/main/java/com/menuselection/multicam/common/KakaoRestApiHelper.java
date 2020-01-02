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
import com.menuselection.multicam.bean.AddressBean;
import com.menuselection.multicam.bean.DocumentBean;
import com.menuselection.multicam.bean.KakaoBean;
import com.menuselection.multicam.bean.RoadAddressBean;

public class KakaoRestApiHelper {
//	@Value("${kakao.restapi.key}")
	private static final String API_SERVER_HOST  = "https://dapi.kakao.com";
    private static final String SEARCH_PLACE_KEYWORD_PATH = "/v2/local/search/keyword.json";
    private static final String SEARCH_PLACE_ADDRESS_PATH = "/v2/local/search/address.json";
    private static final String SEARCH_PLACE__CATEGORY_ADDRESS_PATH = "/v2/local/search/category.json";
    private String restApiKey = "600f124241db7f169bbb637ce49d6472";;
	
	/*
	 * 카카오맵 카테고리로 장소 검색
	 * */
	public KakaoBean getCategoryMap() {
		
		KakaoBean kakaoBean = new KakaoBean();	
		
        String queryString = "?category_group_code=FD6"; //+"&page="+searchVO.getCurrentPage()+"&size="+searchVO.getPageSize();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "KakaoAK " + restApiKey);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        URI url = URI.create(API_SERVER_HOST+SEARCH_PLACE__CATEGORY_ADDRESS_PATH+queryString);
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
		
		return kakaoBean;
		
	}
	
	/*
	 * 카카오맵 키워드로 장소 검색
	 * */
	public KakaoBean getKeywordMap(String keyword) throws Exception{
		
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
			
			return kakaoBean;
		
	}
	
	/*
	 * 카카오맵 주소 검색
	 * */
	public KakaoBean getAddressMap(String keyword) throws Exception{
		
			KakaoBean kakaoBean = new KakaoBean();	
		
	        String queryString = "?query="+URLEncoder.encode(keyword, "UTF-8") +"&page=1"+"&size=30";
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();

	        headers.add("Authorization", "KakaoAK " + restApiKey);
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

	        URI url = URI.create(API_SERVER_HOST+SEARCH_PLACE_ADDRESS_PATH+queryString);
	        RequestEntity<String> rq = new RequestEntity<>(headers, HttpMethod.GET, url);
	        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);
	        
	        JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(re.getBody());
			JsonArray jsonArrayDocuments = (JsonArray) jsonObject.get("documents");
			JsonObject meta = (JsonObject)jsonObject.get("meta");
			
			
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

			Boolean isEnd;
			
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
				JsonObject documentAddress = null;
				JsonObject documentRoadAddress = null;
				
				if(documents.get("address") != null && !"null".equals(documents.get("address").toString()) && !"".equals(documents.get("address").toString())) {
					documentAddress = (JsonObject) documents.get("address");
				}
				
				if(documents.get("road_address") != null && !"".equals(documents.get("road_address").toString()) && !"null".equals(documents.get("road_address").toString())) {
					documentRoadAddress = (JsonObject) documents.get("road_address");
				}
				
				documentBean.setAddressName(documents.get("address_name").toString());
				documentBean.setAddressType(documents.get("address_type").toString());
				documentBean.setX(documents.get("x").toString());
				documentBean.setY(documents.get("y").toString());
				
				AddressBean address = new AddressBean();
				RoadAddressBean roadAddress = new RoadAddressBean();
				
				if(documentAddress != null && !"".equals(documentAddress.toString()) && !"null".equals(documentAddress.toString())) {
					address.setAddressName(documentAddress.get("address_name").toString());
					address.setRegion1depthName(documentAddress.get("region_1depth_name").toString());
					address.setRegion2depthName(documentAddress.get("region_2depth_name").toString());
					address.setRegion3depthName(documentAddress.get("region_3depth_name").toString());
					address.setRegion3depthHName(documentAddress.get("region_3depth_h_name").toString());
					address.sethCode(documentAddress.get("h_code").toString());
					address.setbCode(documentAddress.get("b_code").toString());
					address.setMountainYn(documentAddress.get("mountain_yn").toString());
					address.setMainAddressNo(documentAddress.get("main_address_no").toString());
					address.setSubAddressNo(documentAddress.get("sub_address_no").toString());
					address.setZipCode(documentAddress.get("zip_code").toString());
					address.setX(documentAddress.get("x").toString());
					address.setY(documentAddress.get("y").toString());
					
					documentBean.setAddress(address);
				}
				
				if(documentRoadAddress != null && !"".equals(documentRoadAddress.toString()) && !"null".equals(documentRoadAddress.toString())) {
					roadAddress.setAddressName(documentRoadAddress.get("address_name").toString());
					roadAddress.setRegion1depthName(documentRoadAddress.get("region_1depth_name").toString());
					roadAddress.setRegion2depthName(documentRoadAddress.get("region_2depth_name").toString());
					roadAddress.setRegion3depthName(documentRoadAddress.get("region_3depth_name").toString());
					roadAddress.setRoadName(documentRoadAddress.get("road_name").toString());
					roadAddress.setUndergroundYn(documentRoadAddress.get("underground_yn").toString());
					roadAddress.setMainBuildingNo(documentRoadAddress.get("main_building_no").toString());
					roadAddress.setSubBuildingNo(documentRoadAddress.get("sub_building_no").toString());
					roadAddress.setBuildingName(documentRoadAddress.get("building_name").toString());
					roadAddress.setZoneNo(documentRoadAddress.get("zone_no").toString());
					roadAddress.setX(documentRoadAddress.get("x").toString());
					roadAddress.setY(documentRoadAddress.get("y").toString());
					
					documentBean.setRoadAddress(roadAddress);
				}
				
				documentList.add(documentBean);
			}
			
			kakaoBean.setDocumentList(documentList);
			
			return kakaoBean;
		
	}
	
}