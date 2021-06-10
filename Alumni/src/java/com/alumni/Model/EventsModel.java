package com.alumni.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class EventsModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String event_title;
	public Date start_date;
	public Date end_date;
	public String location;
	public String organizer;
	public String organizer_designation;
	public String description;
	public boolean status;
	public Integer id;
	public String status_type;
	public Date created_date;
	public Timestamp date_created;
	public String std_id;
	
	
	
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Timestamp getDate_created() {
		return date_created;
	}
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getOrganizer_designation() {
		return organizer_designation;
	}
	public void setOrganizer_designation(String organizer_designation) {
		this.organizer_designation = organizer_designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus_type() {
		return status_type;
	}
	public void setStatus_type(String status_type) {
		this.status_type = status_type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	
			
	
}
