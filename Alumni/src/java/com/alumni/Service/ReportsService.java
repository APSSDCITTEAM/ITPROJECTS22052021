package com.alumni.Service;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

//Local
import com.alumni.DAO.DiscussionDAO;
import com.alumni.DAO.IndexDAO;
import com.alumni.DAO.PostjobDAO;
import com.alumni.DAO.ReportsDAO;
import com.alumni.DAO.ViewJobDAO;
import com.alumni.Model.DiscussionModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.IndexModel;
import com.alumni.Model.PostjobModel;
import com.alumni.Model.ReportsModel;
import com.alumni.Model.ViewJobModel;
import com.alumni.Model.AlumniRegisterModel;

@Service
public class ReportsService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private ReportsDAO reportsDAO;
	
	 /* .............................. get Employees count ............................ */
	 public Response getMembersCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getMembersCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 /* .............................. get Approved Employees count ............................ */
	 public Response getApprovedEmployeesCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getApprovedEmployeesCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 
	 /* .............................. get Rejected Employees count ............................ */
	 public Response getRejectedEmployeesCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getRejectedEmployeesCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Verified Employees count ............................ */
	 public Response getVerifiedEmployeesCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getVerifiedEmployeesCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Non-Verified Employees count ............................ */
	 public Response getnonVerifiedEmployeesCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getnonVerifiedEmployeesCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* getting approved employee data */
	 public Response getApprovedEmpData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getApprovedEmpData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}

	 /* getting rejected employee data */
	 public Response getRejectedEmpData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getRejectedEmpData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting verified employee data */
	 public Response getVerifiedEmpData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getVerifiedEmpData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting not verified employee data */
	 public Response getnotVerifiedEmpData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getnotVerifiedEmpData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting approved employee jobs data */
	 public Response getEmployeeJobsData(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getEmployeeJobsData(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting approved employee interns data */
	 public Response getEmployeeInternshipsData(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getEmployeeInternshipsData(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* .............................. get Students count ............................ */
	 public Response getStudentMembersCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getStudentMembersCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Approved Students count ............................ */
	 public Response getApprovedStudentsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getApprovedStudentsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Rejected Students count ............................ */
	 public Response getRejectedStudentsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getRejectedStudentsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Verified Students count ............................ */
	 public Response getVerifiedStudentsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getVerifiedStudentsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Non-Verified students count ............................ */
	 public Response getnonVerifiedStudentsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getnonVerifiedStudentsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get Non-Verified students count ............................ */
	 public Response getallStudentsCount() throws JSONException
		{
			response.setSuccessful(false);
			JSONObject user = reportsDAO.getallStudentsCount();
			response.setSuccessful(true);
			response.setResponseObject(user);
			return response;
		}
	 
	 /* getting approved std data */
	 public Response getApprovedStdData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getApprovedStdData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}

	 /* getting rejected std data */
	 public Response getRejectedStdData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getRejectedStdData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting verified std data */
	 public Response getVerifiedStdData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getVerifiedStdData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting not verified std data */
	 public Response getnotVerifiedStdData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getnotVerifiedStdData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting approved employee jobs data */
	 public Response getStudentsJobsData(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getStudentsJobsData(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting approved employee interns data */
	 public Response getStudentsInternshipsData(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getStudentsInternshipsData(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 public Response getEmployeeDetails(String user_id)
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getEmployeeDetails(user_id);
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* getting applied employee jobs data */
	 public Response getEmployeeappliedJobs(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getEmployeeappliedJobs(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting applied employee interns data */
	 public Response getEmployeeappliedInternships(String user_id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getEmployeeappliedInternships(user_id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 
	 /* ................................................... Events reports ................................................ */
	 public Response getEventsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getEventsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getOpenEventsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getOpenEventsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getClosedEventsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getClosedEventsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getOpenEventsData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getOpenEventsData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 public Response getClosedEventsData(Integer status) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getClosedEventsData(status);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 
	 /* ......................................... Job Reports ............................................. */
	 public Response getJobCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getJobCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 public Response getApprovedJobCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getApprovedJobCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 
	 public Response getRejectedJobsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getRejectedJobsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getClosedJobCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getClosedJobCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getPendingJobCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getPendingJobCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 
	 /* ......................................... Internship reports .................................... */
	 public Response getInternshipCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getInternshipCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 public Response getApprovedInternshipCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getApprovedInternshipCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}

	 public Response getRejectedInternshipsCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getRejectedInternshipsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getClosedInternshipCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getClosedInternshipCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getPendingInternshipCount()
		{
			response.setSuccessful(false);
			ReportsModel singleuserdetails = reportsDAO.getPendingInternshipCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 public Response getJobsData(Integer id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getJobsData(id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 public Response getInternsData(Integer id) {
			response.setSuccessful(false);
			Map<String, Object> list = reportsDAO.getInternsData(id);
			response.setSuccessful(true);
			response.setResponseObject(list);
			return response;
		}
	 
	 /* getting event applicants */
	 public Response getEventApplicants(Integer id) {
		response.setSuccessful(false);
		Map<String, Object> list = reportsDAO.getEventApplicants(id);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}
	 
	 

}
