package com.alumni.Model;

import java.math.BigInteger;
import com.andromeda.commons.model.BaseModel;

public class AlumniRegisterModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String std_id;
	public String username;
	public String first_name;
	public String last_name;
	public String password;
	public String email;
	public BigInteger mobile_no;
	public String photo;
	public boolean status;
	public Integer mail_count;
	public Integer type;
	public String college_code;
	public String roll_number;
	public String organization_name;
	public String employee_id;

	public String user_id;
	public Integer count;
	public String statustype;
	public String qualification;
	public String branch;
	public Integer passed_out_year;
	public String district;
	public String other_qualifiction;
	public Integer role_id;
	public Integer token;
	public Integer id;
	public Integer job_id;
	public Integer intership_id;
	public boolean mentorship;
	public Integer technologies_id;
	public String role_name;
	public Integer otp;

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Integer getTechnologies_id() {
		return technologies_id;
	}

	public void setTechnologies_id(Integer technologies_id) {
		this.technologies_id = technologies_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public boolean isMentorship() {
		return mentorship;
	}

	public void setMentorship(boolean mentorship) {
		this.mentorship = mentorship;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public Integer getIntership_id() {
		return intership_id;
	}

	public void setIntership_id(Integer intership_id) {
		this.intership_id = intership_id;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getPassed_out_year() {
		return passed_out_year;
	}

	public void setPassed_out_year(Integer passed_out_year) {
		this.passed_out_year = passed_out_year;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getOther_qualifiction() {
		return other_qualifiction;
	}

	public void setOther_qualifiction(String other_qualifiction) {
		this.other_qualifiction = other_qualifiction;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCollege_code() {
		return college_code;
	}

	public void setCollege_code(String college_code) {
		this.college_code = college_code;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getMail_count() {
		return mail_count;
	}

	public void setMail_count(Integer mail_count) {
		this.mail_count = mail_count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(BigInteger mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getStatustype() {
		return statustype;
	}

	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

}
