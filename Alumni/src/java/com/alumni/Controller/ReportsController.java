package com.alumni.Controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;
import com.alumni.Model.AdminApprovalModel;
import com.alumni.Service.AdminApprovalService;
// Local
import com.alumni.Service.IndexService;
import com.alumni.Service.ReportsService;


@RestController
@RequestMapping("/report")

public class ReportsController {    
	
	Response response = new Response();
	
	@Autowired   
//	Discussion Service    
	private ReportsService reportsService;
	
	/* .................................. getting count of Employees ................................ */
	@ResponseBody
	@RequestMapping(value = "getMembersCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getMembersCount()
	{
		return reportsService.getMembersCount();
	}
	
	/* .................................. getting count of Approved Employees ................................ */
	@ResponseBody
	@RequestMapping(value = "getApprovedEmployeesCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedEmployeesCount()
	{
		return reportsService.getApprovedEmployeesCount();
	}
	
	/* .................................. getting count of Rejected Employees ................................ */
	@ResponseBody
	@RequestMapping(value = "getRejectedEmployeesCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedEmployeesCount()
	{
		return reportsService.getRejectedEmployeesCount();
	}
	
	/* .................................. getting count of Verified Employees ................................ */
	@ResponseBody
	@RequestMapping(value = "getVerifiedEmployeesCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getVerifiedEmployeesCount()
	{
		return reportsService.getVerifiedEmployeesCount();
	}
	
	/* .................................. getting count of Non-Verified Employees ................................ */
	@ResponseBody
	@RequestMapping(value = "getnonVerifiedEmployeesCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getnonVerifiedEmployeesCount()
	{
		return reportsService.getnonVerifiedEmployeesCount();
	}
	
	/* getting approved employee data */
	@ResponseBody
	@RequestMapping(value = { "/getApprovedEmpData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedEmpData(@RequestBody Integer status) {
		return reportsService.getApprovedEmpData(status);
	}
	
	/* getting rejected employee data */
	@ResponseBody
	@RequestMapping(value = { "/getRejectedEmpData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedEmpData(@RequestBody Integer status) {
		return reportsService.getRejectedEmpData(status);
	}
	
	/* getting verified employee data */
	@ResponseBody
	@RequestMapping(value = { "/getVerifiedEmpData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getVerifiedEmpData(@RequestBody Integer status) {
		return reportsService.getVerifiedEmpData(status);
	}
	
	/* getting not verified employee data */
	@ResponseBody
	@RequestMapping(value = { "/getnotVerifiedEmpData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getnotVerifiedEmpData(@RequestBody Integer status) {
		return reportsService.getnotVerifiedEmpData(status);
	}
	
	/* getting approved employee jobs data */
	@ResponseBody
	@RequestMapping(value = { "/getEmployeeJobsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEmployeeJobsData(@RequestBody String user_id) {
		return reportsService.getEmployeeJobsData(user_id);
	}
	
	/* getting approved employee interns data */
	@ResponseBody
	@RequestMapping(value = { "/getEmployeeInternshipsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEmployeeInternshipsData(@RequestBody String user_id) {
		return reportsService.getEmployeeInternshipsData(user_id);
	}
	
	/* .................................. getting count of Students ................................ */
	@ResponseBody
	@RequestMapping(value = "getStudentMembersCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getStudentMembersCount()
	{
		return reportsService.getStudentMembersCount();
	}
	
	/* .................................. getting count of Approved Students ................................ */
	@ResponseBody
	@RequestMapping(value = "getApprovedStudentsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedStudentsCount()
	{
		return reportsService.getApprovedStudentsCount();
	}
	
	/* .................................. getting count of Rejected Student ................................ */
	@ResponseBody
	@RequestMapping(value = "getRejectedStudentsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedStudentsCount()
	{
		return reportsService.getRejectedStudentsCount();
	}
	
	/* .................................. getting count of Verified Students ................................ */
	@ResponseBody
	@RequestMapping(value = "getVerifiedStudentsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getVerifiedStudentsCount()
	{
		return reportsService.getVerifiedStudentsCount();
	}
	
	/* .................................. getting count of Non-Verified students ................................ */
	@ResponseBody
	@RequestMapping(value = "getnonVerifiedStudentsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getnonVerifiedStudentsCount()
	{
		return reportsService.getnonVerifiedStudentsCount();
	}
	
	/* .................................. getting all count of students ................................ */
	@ResponseBody
	@RequestMapping(value = "getallStudentsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallStudentsCount() throws JSONException
	{
		return reportsService.getallStudentsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getApprovedStdData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedStdData(@RequestBody Integer status) {
		return reportsService.getApprovedStdData(status);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getRejectedStdData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedStdData(@RequestBody Integer status) {
		return reportsService.getRejectedStdData(status);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getVerifiedStdData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getVerifiedStdData(@RequestBody Integer status) {
		return reportsService.getVerifiedStdData(status);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getnotVerifiedStdData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getnotVerifiedStdData(@RequestBody Integer status) {
		return reportsService.getnotVerifiedStdData(status);
	}
	
	/* getting approved employee jobs data */
	@ResponseBody
	@RequestMapping(value = { "/getStudentsJobsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getStudentsJobsData(@RequestBody String user_id) {
		return reportsService.getStudentsJobsData(user_id);
	}
	
	/* getting approved employee interns data */
	@ResponseBody
	@RequestMapping(value = { "/getStudentsInternshipsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getStudentsInternshipsData(@RequestBody String user_id) {
		return reportsService.getStudentsInternshipsData(user_id);
	}
	
	
	/* getting employee detials */
	@ResponseBody
	@RequestMapping(value = "getEmployeeDetails", method = { RequestMethod.POST })
	public Response getEmployeeDetails(@RequestBody String user_id)
	{
		return reportsService.getEmployeeDetails(user_id);
	}
	
	/* getting applied employee jobs data */
	@ResponseBody
	@RequestMapping(value = { "/getEmployeeappliedJobs" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEmployeeappliedJobs(@RequestBody String user_id) {
		return reportsService.getEmployeeappliedJobs(user_id);
	}
	
	/* getting applied employee interns data */
	@ResponseBody
	@RequestMapping(value = { "/getEmployeeappliedInternships" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEmployeeappliedInternships(@RequestBody String user_id) {
		return reportsService.getEmployeeappliedInternships(user_id);
	}
	
	
	/* .................................................. Events Reports .................................................. */
	@ResponseBody
	@RequestMapping(value = "getEventsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEventsCount()
	{
		return reportsService.getEventsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getOpenEventsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getOpenEventsCount()
	{
		return reportsService.getOpenEventsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getClosedEventsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getClosedEventsCount()
	{
		return reportsService.getClosedEventsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getOpenEventsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getOpenEventsData(@RequestBody Integer status) {
		return reportsService.getOpenEventsData(status);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getClosedEventsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getClosedEventsData(@RequestBody Integer status) {
		return reportsService.getClosedEventsData(status);
	}
	
	
	/* ....................................... Job reports ............................................... */
	@ResponseBody
	@RequestMapping(value = "getJobCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getJobCount()
	{
		return reportsService.getJobCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getApprovedJobCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedJobCount()
	{
		return reportsService.getApprovedJobCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getRejectedJobsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedJobsCount()
	{
		return reportsService.getRejectedJobsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getClosedJobCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getClosedJobCount()
	{
		return reportsService.getClosedJobCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getPendingJobCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getPendingJobCount()
	{
		return reportsService.getPendingJobCount();
	}
	
	
	/* .............................................. internship reports ................................... */
	@ResponseBody
	@RequestMapping(value = "getInternshipCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getInternshipCount()
	{
		return reportsService.getInternshipCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getApprovedInternshipCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedInternshipCount()
	{
		return reportsService.getApprovedInternshipCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getRejectedInternshipsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedInternshipsCount()
	{
		return reportsService.getRejectedInternshipsCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getClosedInternshipCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getClosedInternshipCount()
	{
		return reportsService.getClosedInternshipCount();
	}
	
	@ResponseBody
	@RequestMapping(value = "getPendingInternshipCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getPendingInternshipCount()
	{
		return reportsService.getPendingInternshipCount();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getJobsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getJobsData(@RequestBody Integer id) {
		return reportsService.getJobsData(id);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getInternsData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getInternsData(@RequestBody Integer id) {
		return reportsService.getInternsData(id);
	}
	
	/* getting event applicants */
	@ResponseBody
	@RequestMapping(value = { "/getEventApplicants" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEventApplicants(@RequestBody Integer id) {
		return reportsService.getEventApplicants(id);
	}
	
		

}
