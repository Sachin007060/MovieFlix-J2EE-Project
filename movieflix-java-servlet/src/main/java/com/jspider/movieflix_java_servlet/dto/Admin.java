package com.jspider.movieflix_java_servlet.dto;

/**
 * @author sachin
 * This is my encapsulation class
 * which will help me for admin login
 */
public class Admin {
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private long adminPhone;
		
	/**
	 * sort cut for creating constructor
	 * Alt + s + a
	 * 
	 * @param adminId
	 * @param adminName
	 * @param adminEmail
	 * @param adminPassword
	 * @param adminPhone
	 */
	
	public Admin(int adminId, String adminName, String adminEmail, String adminPassword, long adminPhone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminPhone = adminPhone;
	}

	public Admin(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public long getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(long adminPhone) {
		this.adminPhone = adminPhone;
	}
	
	/**
	 * Alt + s + r
	 * generate getter and setters
	 */
	
	
}
