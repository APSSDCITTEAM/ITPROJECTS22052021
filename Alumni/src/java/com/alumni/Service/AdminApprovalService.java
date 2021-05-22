package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;
import com.alumni.DAO.AdminApprovalDAO;
//Local
import com.alumni.Model.AdminApprovalModel;

@Service
public class AdminApprovalService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private AdminApprovalDAO adminApprovalDAO;

	
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
	
	public Response ApproveUser(AdminApprovalModel faculty) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveUser(faculty);
		response.setSuccessful(true);
		response.setResponseObject(faculty);
		return response;
	}
	
	public Response RejectUser(AdminApprovalModel faculty) {
		response.setSuccessful(false);
		adminApprovalDAO.RejectUser(faculty);
		response.setSuccessful(true);
		response.setResponseObject(faculty);
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
	public Response ApproveJob(AdminApprovalModel faculty) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveJob(faculty);
		response.setSuccessful(true);
		response.setResponseObject(faculty);
		return response;
	}
	
	/* Reject Jobs */
	public Response RejectJob(AdminApprovalModel faculty) {
		response.setSuccessful(false);
		adminApprovalDAO.RejectJob(faculty);
		response.setSuccessful(true);
		response.setResponseObject(faculty);
		return response;
	}
	


}
