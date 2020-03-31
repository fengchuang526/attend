package chuang.entity;

import java.sql.Timestamp;


/*
 *	用户实体类
 */
public class User extends IdEntity{
	/**
	 * 账号
	 */
	private String userAccount;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPwd;
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	/**
	 * 登录IP
	 */
	private String userLoginIp;
	/**
	 * 登录时间
	 */
	private Timestamp loginTime;
	/**
	 * 用户地址
	 */
	private String userAddress;
	/**
	 * 用户电话1
	 */
	private String userPhoneOne;
	/**
	 * 用户电话2
	 */
	private String userPhoneTwo;
	/**
	 * 用户电话3
	 */
	private String userPhoneThre;
	/**
	 * 用户状态
	 */
	private String userStatus;
	/**
	 * 角色ID
	 */
	private Role roleId;
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserLoginIp() {
		return userLoginIp;
	}
	public void setUserLoginIp(String userLoginIp) {
		this.userLoginIp = userLoginIp;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhoneOne() {
		return userPhoneOne;
	}
	public void setUserPhoneOne(String userPhoneOne) {
		this.userPhoneOne = userPhoneOne;
	}
	public String getUserPhoneTwo() {
		return userPhoneTwo;
	}
	public void setUserPhoneTwo(String userPhoneTwo) {
		this.userPhoneTwo = userPhoneTwo;
	}
	public String getUserPhoneThre() {
		return userPhoneThre;
	}
	public void setUserPhoneThre(String userPhoneThre) {
		this.userPhoneThre = userPhoneThre;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
}
