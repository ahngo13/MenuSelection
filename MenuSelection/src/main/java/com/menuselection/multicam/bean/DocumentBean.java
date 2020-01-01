package com.menuselection.multicam.bean;

public class DocumentBean {
	String placeName;
    String distance;
	String placeUrl;
    String categoryName;
	String addressName;
	String roadAddressName;
	String id;
	String phone;
	String categoryGroupCode;
	String categoryGroupName;
	String x;
	String y;
	
	//주소 검색 api로 인한 추가
	String addressType;
	AddressBean address;
	RoadAddressBean roadAddress;
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getPlaceUrl() {
		return placeUrl;
	}
	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getRoadAddressName() {
		return roadAddressName;
	}
	public void setRoadAddressName(String roadAddressName) {
		this.roadAddressName = roadAddressName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCategoryGroupCode() {
		return categoryGroupCode;
	}
	public void setCategoryGroupCode(String categoryGroupCode) {
		this.categoryGroupCode = categoryGroupCode;
	}
	public String getCategoryGroupName() {
		return categoryGroupName;
	}
	public void setCategoryGroupName(String categoryGroupName) {
		this.categoryGroupName = categoryGroupName;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public RoadAddressBean getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(RoadAddressBean roadAddress) {
		this.roadAddress = roadAddress;
	}
	
}
	