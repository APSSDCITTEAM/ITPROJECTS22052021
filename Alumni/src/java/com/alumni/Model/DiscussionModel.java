package com.alumni.Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class DiscussionModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String discussionTilte;
	public Date date;
	public Time time;
	public Timestamp timestamp;
	public String std_id;
	
	
	
	public String getDiscussionTilte() {
		return discussionTilte;
	}
	public void setDiscussionTilte(String discussionTilte) {
		this.discussionTilte = discussionTilte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
