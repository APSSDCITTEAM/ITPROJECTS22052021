package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;
import com.alumni.DAO.AdminApprovalDAO;
import com.alumni.DAO.AlumniRegisterDAO;
//Local
import com.alumni.Model.AdminApprovalModel;
import com.alumni.Model.Email;

@Service
public class AdminApprovalService {

	Response response = new Response();
	
	@Autowired
	private EmailService emailService;

	@Autowired
	//Discussion DAO
	private AdminApprovalDAO adminApprovalDAO;
	@Autowired
	private AlumniRegisterDAO alumniregisterDAO;

	
	public Response getallusers() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallusers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallVerifiedUsers() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallVerifiedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getinActiveJobs() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getinActiveJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getinActiveInternships() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getinActiveInternships();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallApprovedUsers() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallApprovedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallRejectedUsers() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallRejectedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallunverifiedUsers() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallunverifiedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response ApproveUser(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveUser(id);
		
		
		String UserEmail = alumniregisterDAO.getUserEmailbyId(id);
		String Password = alumniregisterDAO.getUserPasswordbyId(id);
//		Mail Service Starts
		Email email = new Email();
		email.setFrom("APSSDC Alumni Registration <siemensrecruitment@apssdc.in>");
		email.setTo(UserEmail.trim());
		email.setSubject("Email Verification for the Alumni Portal");
		String msg = "Dear Participant,<br><br>" + "<b>You are approved as APSSDC Alumni.</b><br><br>"
				+ "<p>Your UserName is " + UserEmail + "<br>Your Password is "
				+ Password + "</p><br><br>";
		email.setText(msg);

		this.emailService.sendHtmlMsg(email);
		
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	public Response RejectUser(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.RejectUser(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	
	/* ........................................... Job Approvals .............................................. */
	/* all Jobs */
	public Response getallJobs() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* submitted Jobs */
	public Response getSubmittedJobs() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getSubmittedJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* approved Jobs */
	public Response getApprovedJobs() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getApprovedJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* Rejected Jobs */
	public Response getRejectedJobs() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getRejectedJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* Approve Jobs */
	public Response ApproveJob(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveJob(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	/* Reject Jobs */
	public Response RejectJob(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.RejectJob(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	
	/* ........................................... Internship Approvals .............................................. */
	/* all Jobs */
	public Response getallInternships() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getallInternships();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* submitted Jobs */
	public Response getSubmittedInternships() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getSubmittedInternships();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getRejectedInternshipsData() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getRejectedInternshipsData();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* approved Jobs */
	public Response getApprovedInternships() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getApprovedInternships();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* Rejected Jobs */
	public Response getRejectedInternships() {
		response.setSuccessful(false);
		List<AdminApprovalModel> userdetails = adminApprovalDAO.getRejectedInternships();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* Approve Jobs */
	public Response ApproveInternships(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveInternships(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	/* Reject Jobs */
	public Response RejectInternships(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.RejectInternships(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	
	


}
