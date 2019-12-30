package com.menuselection.multicam.bean;

import java.util.ArrayList;

public class KakaoBean {
	
	//same_name
	String region;
	String keyword;
    String selectedRegion;
	
	//meta
	int pageableCount;
	int totalCount;
	boolean isEnd;

	ArrayList<DocumentBean> documentList;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSelectedRegion() {
		return selectedRegion;
	}

	public void setSelectedRegion(String selectedRegion) {
		this.selectedRegion = selectedRegion;
	}

	public int getPageableCount() {
		return pageableCount;
	}

	public void setPageableCount(int pageableCount) {
		this.pageableCount = pageableCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public ArrayList<DocumentBean> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(ArrayList<DocumentBean> documentList) {
		this.documentList = documentList;
	}
    
		
}
