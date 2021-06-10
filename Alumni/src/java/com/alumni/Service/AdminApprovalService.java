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
	
	public Response ApproveUser(Integer id) {
		response.setSuccessful(false);
		adminApprovalDAO.ApproveUser(id);
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
