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
	 * īī���� ī�װ��� ��� �˻�
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
			documentBean.setPlaceName(documents.get("place_name").toString().replace("\"", ""));
			documentBean.setDistance(documents.get("distance").toString().replace("\"", ""));
			documentBean.setPlaceUrl(documents.get("place_url").toString().replace("\"", ""));
			documentBean.setCategoryName(documents.get("category_name").toString().replace("\"", ""));
			documentBean.setAddressName(documents.get("address_name").toString().replace("\"", ""));
			documentBean.setRoadAddressName(documents.get("road_address_name").toString().replace("\"", ""));
			documentBean.setId(documents.get("id").toString().replace("\"", ""));
			documentBean.setPhone(documents.get("phone").toString().replace("\"", ""));
			documentBean.setCategoryGroupCode(documents.get("category_group_code").toString().replace("\"", ""));
			documentBean.setCategoryGroupName(documents.get("category_group_name").toString().replace("\"", ""));
			documentBean.setX(documents.get("x").toString().replace("\"", ""));
			documentBean.setY(documents.get("y").toString().replace("\"", ""));
			
			documentList.add(documentBean);
		}
		
		kakaoBean.setDocumentList(documentList);
		
		return kakaoBean;
		
	}
	
	/*
	 * īī���� Ű����� ��� �˻�
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
				documentBean.setPlaceName(documents.get("place_name").toString().replace("\"", ""));
				documentBean.setDistance(documents.get("distance").toString().replace("\"", ""));
				documentBean.setPlaceUrl(documents.get("place_url").toString().replace("\"", ""));
				documentBean.setCategoryName(documents.get("category_name").toString().replace("\"", ""));
				documentBean.setAddressName(documents.get("address_name").toString().replace("\"", ""));
				documentBean.setRoadAddressName(documents.get("road_address_name").toString().replace("\"", ""));
				documentBean.setId(documents.get("id").toString().replace("\"", ""));
				documentBean.setPhone(documents.get("phone").toString().replace("\"", ""));
				documentBean.setCategoryGroupCode(documents.get("category_group_code").toString().replace("\"", ""));
				documentBean.setCategoryGroupName(documents.get("category_group_name").toString().replace("\"", ""));
				documentBean.setX(documents.get("x").toString().replace("\"", ""));
				documentBean.setY(documents.get("y").toString().replace("\"", ""));
				
				documentList.add(documentBean);
			}
			
			kakaoBean.setDocumentList(documentList);
			
			return kakaoBean;
		
	}
	
	/*
	 * īī���� �ּ� �˻�
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
				
				String getAddress = documents.get("address").toString().replace("\"", "");			
				if(getAddress != null && !"".equals(getAddress) && !"null".equals(getAddress)) {
					documentAddress = (JsonObject) documents.get("address");
				}
				
				String getRoadAddress = documents.get("road_address").toString().replace("\"", "");
				if(getRoadAddress != null && !"".equals(getRoadAddress) && !"null".equals(getRoadAddress)) {
					documentRoadAddress = (JsonObject) documents.get("road_address");
				}
				
				documentBean.setAddressName(documents.get("address_name").toString().replace("\"", ""));
				documentBean.setAddressType(documents.get("address_type").toString().replace("\"", ""));
				documentBean.setX(documents.get("x").toString().replace("\"", ""));
				documentBean.setY(documents.get("y").toString().replace("\"", ""));
				
				AddressBean address = new AddressBean();
				RoadAddressBean roadAddress = new RoadAddressBean();
				
				if(documentAddress != null && !"".equals(documentAddress.toString()) && !"null".equals(documentAddress.toString())) {
					address.setAddressName(documentAddress.get("address_name").toString().replace("\"", ""));
					address.setRegion1depthName(documentAddress.get("region_1depth_name").toString().replace("\"", ""));
					address.setRegion2depthName(documentAddress.get("region_2depth_name").toString().replace("\"", ""));
					address.setRegion3depthName(documentAddress.get("region_3depth_name").toString().replace("\"", ""));
					address.setRegion3depthHName(documentAddress.get("region_3depth_h_name").toString().replace("\"", ""));
					address.sethCode(documentAddress.get("h_code").toString().replace("\"", ""));
					address.setbCode(documentAddress.get("b_code").toString().replace("\"", ""));
					address.setMountainYn(documentAddress.get("mountain_yn").toString().replace("\"", ""));
					address.setMainAddressNo(documentAddress.get("main_address_no").toString().replace("\"", ""));
					address.setSubAddressNo(documentAddress.get("sub_address_no").toString().replace("\"", ""));
					address.setZipCode(documentAddress.get("zip_code").toString().replace("\"", ""));
					address.setX(documentAddress.get("x").toString().replace("\"", ""));
					address.setY(documentAddress.get("y").toString().replace("\"", ""));
					
					documentBean.setAddress(address);
				}
				
				if(documentRoadAddress != null && !"".equals(documentRoadAddress.toString()) && !"null".equals(documentRoadAddress.toString())) {
					roadAddress.setAddressName(documentRoadAddress.get("address_name").toString().replace("\"", ""));
					roadAddress.setRegion1depthName(documentRoadAddress.get("region_1depth_name").toString().replace("\"", ""));
					roadAddress.setRegion2depthName(documentRoadAddress.get("region_2depth_name").toString().replace("\"", ""));
					roadAddress.setRegion3depthName(documentRoadAddress.get("region_3depth_name").toString().replace("\"", ""));
					roadAddress.setRoadName(documentRoadAddress.get("road_name").toString().replace("\"", ""));
					roadAddress.setUndergroundYn(documentRoadAddress.get("underground_yn").toString().replace("\"", ""));
					roadAddress.setMainBuildingNo(documentRoadAddress.get("main_building_no").toString().replace("\"", ""));
					roadAddress.setSubBuildingNo(documentRoadAddress.get("sub_building_no").toString().replace("\"", ""));
					roadAddress.setBuildingName(documentRoadAddress.get("building_name").toString().replace("\"", ""));
					roadAddress.setZoneNo(documentRoadAddress.get("zone_no").toString().replace("\"", ""));
					roadAddress.setX(documentRoadAddress.get("x").toString().replace("\"", ""));
					roadAddress.setY(documentRoadAddress.get("y").toString().replace("\"", ""));
					
					documentBean.setRoadAddress(roadAddress);
				}
				
				documentList.add(documentBean);
			}
			
			kakaoBean.setDocumentList(documentList);
			
			return kakaoBean;
		
	}
	
}