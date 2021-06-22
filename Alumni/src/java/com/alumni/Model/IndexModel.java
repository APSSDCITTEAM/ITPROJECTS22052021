package com.alumni.Model;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class IndexModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String description;   
	public String title;
	public String company_name;   
	public String location;
	public String contact_email;
	public String min_exp;
	public String max_exp;
	public String std_id;
	public boolean status;    
	public String duration;
	public Timestamp created_date;    
	public Integer id;
	public String created_by;
	public String status_type;
	public String first_name;
	public String email;
	public BigInteger mobile_no;
	public Timestamp date_added;
	public Date date_created;
	public Date end_date;
	public String user_id;
	public Integer members_count;
	public Integer jobs_count;
	public Integer interns_count;
	public Integer events_data;
	
	
	
	
	
	
	
	
	
	
	public Integer getJobs_count() {
		return jobs_count;
	}
	public void setJobs_count(Integer jobs_count) {
		this.jobs_count = jobs_count;
	}
	public Integer getInterns_count() {
		return interns_count;
	}
	public void setInterns_count(Integer interns_count) {
		this.interns_count = interns_count;
	}
	public Integer getEvents_data() {
		return events_data;
	}
	public void setEvents_data(Integer events_data) {
		this.events_data = events_data;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMembers_count() {
		return members_count;
	}
	public void setMembers_count(Integer members_count) {
		this.members_count = members_count;
	}
	public BigInteger getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(BigInteger mobile_no) {
		this.mobile_no = mobile_no;
	}
	public Timestamp getDate_added() {
		return date_added;
	}
	public void setDate_added(Timestamp date_added) {
		this.date_added = date_added;
	}
	public String getStatus_type() {
		return status_type;
	}
	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}
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


	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
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
