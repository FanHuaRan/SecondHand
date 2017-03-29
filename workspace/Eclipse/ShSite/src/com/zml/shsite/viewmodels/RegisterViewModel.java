package com.zml.shsite.viewmodels;

import org.springframework.web.multipart.MultipartFile;

import com.zml.shsite.models.Shuser;

public class RegisterViewModel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5164200378794949862L;
	// Fields
	private Integer shUserId;
	private String shUserName;
	private String password;
	private Short gender;
	private String introduce;
	private String phone;
	private String address;
    private MultipartFile imgFile;
	public String getShUserName() {
		return shUserName;
	}
	public void setShUserName(String shUserName) {
		this.shUserName = shUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Short getGender() {
		return gender;
	}
	public void setGender(Short gender) {
		this.gender = gender;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public Shuser toShuser(){
		Shuser shuser=new Shuser(shUserName, password, gender, introduce, phone, address);
		shuser.setShUserId(this.shUserId);
		return shuser;
	}
	public Integer getShUserId() {
		return shUserId;
	}
	public void setShUserId(Integer shUserId) {
		this.shUserId = shUserId;
	}
}
