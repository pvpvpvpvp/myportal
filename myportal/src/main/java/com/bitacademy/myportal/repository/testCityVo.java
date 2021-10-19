package com.bitacademy.myportal.repository;

import java.util.Date;

public class testCityVo {
	private int cityId;
	private String city;
	private int countryId;
	@Override
	public String toString() {
		return "testCityVo [cityId=" + cityId + ", city=" + city + ", countryId=" + countryId + ", regDate=" + regDate
				+ "]";
	}
	private Date regDate;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
