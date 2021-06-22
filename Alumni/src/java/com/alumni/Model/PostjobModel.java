package com.alumni.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class PostjobModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String description;
	public String title;
	public String company_name;
	public String location;
	public String contact_email;
	public String min_exp;
	public String max_exp;
	public String std_id;
	public Date end_date;

	public String experience; 
	public String  hours ;
	public String  number_of_students;
	public String  technologies;
	public String user_id;
	public Date start_date;
	
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getNumber_of_students() {
		return number_of_students;
	}
	public void setNumber_of_students(String number_of_students) {
		this.number_of_students = number_of_students;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Timestamp getDate_added() {
		return date_added;
	}
	public void setDate_added(Timestamp date_added) {
		this.date_added = date_added;
	}
	public Timestamp  date_added;
	
	
	
	
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public Integer status;
	public String duration;
	
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

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	    
		
	
}
