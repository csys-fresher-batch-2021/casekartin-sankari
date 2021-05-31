package in.casekartin.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterManager {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RegistrationModel [name=" + name + ", email=" + email + ", mobileNum=" + mobileNum + ", address="
				+ address + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", userName=" + userName
				+ ", password=" + password + ", id=" + id + "]";
	}

	public RegisterManager(int id, String name, String userName, String password, String mobileNum,
			LocalDate createdDate, LocalDateTime modifiedDate, String email, String address) {
		super();
		setId(id);
		setName(name);
		setUserName(userName);
		setPassword(password);
		setMobileNum(mobileNum);
		setCreatedDate(createdDate);
		setModifiedDate(modifiedDate);
		setEmail(email);
		setAddress(address);
	}
	private int id;
	private String name;	
	private String userName;
	private String password;
	private String mobileNum;
	private LocalDate createdDate;
	private LocalDateTime modifiedDate;
	private String email;
	private String address;
	

}