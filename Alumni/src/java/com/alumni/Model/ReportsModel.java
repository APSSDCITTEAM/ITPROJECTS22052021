package com.alumni.Model;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import com.andromeda.commons.model.BaseModel;

public class ReportsModel extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	public String description;   
	public String title;
	public String company_name;   
	public String location;
	public String contact_email;
	public String min_exp;
	public String max_exp;
	public String std_id;
	public Integer status;    
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
	public Integer approved_employee_count;
	public Integer verified_employee_count;
	public Integer nonverified_employee_count;
	public String name;
	public Date closeddate;
	public Integer approved_student_count;
	public Integer rejected_students_count;
	public Integer verified_student_count;
	public Integer nonverified_student_count;
	public Integer job_count;
	public Integer intern_count;
	public Integer closed_event_count;
	public Integer open_event_count;
	public Integer events_count;
	public String event_title;
	public Date start_date;
	public String organizer;
	public String eventtype;
	
	
	/* ...................................... jobs and internships ................................. */
	public Integer approved_job_count;
	public Integer rejected_job_count;
	public Integer closed_job_count;
	public Integer pending_job_count;
	
	
	public Integer internship_count;
	public Integer approved_internship_count;
	public Integer rejected_internship_count;
	public Integer closed_internship_count;
	public Integer pending_internship_count;
	
		
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
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getEventtype() {
		return eventtype;
	}
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	public Integer getJob_count() {
		return job_count;
	}
	public void setJob_count(Integer job_count) {
		this.job_count = job_count;
	}
	public Integer getIntern_count() {
		return intern_count;
	}
	public void setIntern_count(Integer intern_count) {
		this.intern_count = intern_count;
	}
	public Integer getApproved_student_count() {
		return approved_student_count;
	}
	public void setApproved_student_count(Integer approved_student_count) {
		this.approved_student_count = approved_student_count;
	}
	public Integer getRejected_students_count() {
		return rejected_students_count;
	}
	public Integer getClosed_event_count() {
		return closed_event_count;
	}
	public void setClosed_event_count(Integer closed_event_count) {
		this.closed_event_count = closed_event_count;
	}
	public Integer getOpen_event_count() {
		return open_event_count;
	}
	public Integer getApproved_job_count() {
		return approved_job_count;
	}
	public void setApproved_job_count(Integer approved_job_count) {
		this.approved_job_count = approved_job_count;
	}
	public Integer getRejected_job_count() {
		return rejected_job_count;
	}
	public void setRejected_job_count(Integer rejected_job_count) {
		this.rejected_job_count = rejected_job_count;
	}
	public Integer getClosed_job_count() {
		return closed_job_count;
	}
	public void setClosed_job_count(Integer closed_job_count) {
		this.closed_job_count = closed_job_count;
	}
	public Integer getPending_job_count() {
		return pending_job_count;
	}
	public void setPending_job_count(Integer pending_job_count) {
		this.pending_job_count = pending_job_count;
	}
	public Integer getInternship_count() {
		return internship_count;
	}
	public void setInternship_count(Integer internship_count) {
		this.internship_count = internship_count;
	}
	public Integer getApproved_internship_count() {
		return approved_internship_count;
	}
	public void setApproved_internship_count(Integer approved_internship_count) {
		this.approved_internship_count = approved_internship_count;
	}
	public Integer getRejected_internship_count() {
		return rejected_internship_count;
	}
	public void setRejected_internship_count(Integer rejected_internship_count) {
		this.rejected_internship_count = rejected_internship_count;
	}
	public Integer getClosed_internship_count() {
		return closed_internship_count;
	}
	public void setClosed_internship_count(Integer closed_internship_count) {
		this.closed_internship_count = closed_internship_count;
	}
	public Integer getPending_internship_count() {
		return pending_internship_count;
	}
	public void setPending_internship_count(Integer pending_internship_count) {
		this.pending_internship_count = pending_internship_count;
	}
	public void setOpen_event_count(Integer open_event_count) {
		this.open_event_count = open_event_count;
	}
	public Integer getEvents_count() {
		return events_count;
	}
	public void setEvents_count(Integer events_count) {
		this.events_count = events_count;
	}
	public void setRejected_students_count(Integer rejected_students_count) {
		this.rejected_students_count = rejected_students_count;
	}
	public Integer getVerified_student_count() {
		return verified_student_count;
	}
	public void setVerified_student_count(Integer verified_student_count) {
		this.verified_student_count = verified_student_count;
	}
	public Integer getNonverified_student_count() {
		return nonverified_student_count;
	}
	public void setNonverified_student_count(Integer nonverified_student_count) {
		this.nonverified_student_count = nonverified_student_count;
	}
	public Date getCloseddate() {
		return closeddate;
	}
	public void setCloseddate(Date closeddate) {
		this.closeddate = closeddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNonverified_employee_count() {
		return nonverified_employee_count;
	}
	public void setNonverified_employee_count(Integer nonverified_employee_count) {
		this.nonverified_employee_count = nonverified_employee_count;
	}
	public Integer getVerified_employee_count() {
		return verified_employee_count;
	}
	public void setVerified_employee_count(Integer verified_employee_count) {
		this.verified_employee_count = verified_employee_count;
	}
	public Integer getApproved_employee_count() {
		return approved_employee_count;
	}
	public void setApproved_employee_count(Integer approved_employee_count) {
		this.approved_employee_count = approved_employee_count;
	}
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
