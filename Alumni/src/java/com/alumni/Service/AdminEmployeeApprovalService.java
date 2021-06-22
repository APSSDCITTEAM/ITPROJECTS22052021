package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

import com.alumni.DAO.AdminEmployeeApprovalDAO;
import com.alumni.DAO.AlumniRegisterDAO;
//Local
import com.alumni.Model.AdminEmployeeApprovalModel;
import com.alumni.Model.Email;

@Service
public class AdminEmployeeApprovalService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private AdminEmployeeApprovalDAO adminEmployeeApprovalDAO;
	
	@Autowired
	 private AlumniRegisterDAO alumniregisterDAO;
	
	@Autowired
	private EmailService emailService;

	
	public Response getallusers() {
		response.setSuccessful(false);
		List<AdminEmployeeApprovalModel> userdetails = adminEmployeeApprovalDAO.getallusers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallVerifiedUsers() {
		response.setSuccessful(false);
		List<AdminEmployeeApprovalModel> userdetails = adminEmployeeApprovalDAO.getallVerifiedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallunverifiedUsers() {
		response.setSuccessful(false);
		List<AdminEmployeeApprovalModel> userdetails = adminEmployeeApprovalDAO.getallunverifiedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallApprovedUsers() {
		response.setSuccessful(false);
		List<AdminEmployeeApprovalModel> userdetails = adminEmployeeApprovalDAO.getallApprovedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallRejectedUsers() {
		response.setSuccessful(false);
		List<AdminEmployeeApprovalModel> userdetails = adminEmployeeApprovalDAO.getallRejectedUsers();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response ApproveUser(Integer id) {
		response.setSuccessful(false);
		adminEmployeeApprovalDAO.ApproveUser(id);
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
		adminEmployeeApprovalDAO.RejectUser(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
		


}
