package com.alumni.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class ViewJobModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String description;   
	public String title;
	public String company_name;   
	public String location;
	public String contact_email;
	public String min_exp;
	public String max_exp;
	public Integer std_id;
	public boolean status;    
	public String duration;
	public Timestamp created_date;    
	public Integer id;
	public String created_by;
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getMin_exp() {
		return min_exp;
	}
	public void setMin_exp(String min_exp) {
		this.min_exp = min_exp;
	}
	public String getMax_exp() {
		return max_exp;
	}
	public void setMax_exp(String max_exp) {
		this.max_exp = max_exp;
	}
	public Integer getStd_id() {
		return std_id;
	}
	public void setStd_id(Integer std_id) {
		this.std_id = std_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
	
	/*
	 * public Date getCreated_date() { return created_date; } public void
	 * setCreated_date(Date created_date) { this.created_date = created_date; }
	 */
	
	
}
