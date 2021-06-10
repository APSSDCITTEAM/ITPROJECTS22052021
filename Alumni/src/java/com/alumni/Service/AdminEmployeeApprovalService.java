package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

import com.alumni.DAO.AdminEmployeeApprovalDAO;
//Local
import com.alumni.Model.AdminEmployeeApprovalModel;

@Service
public class AdminEmployeeApprovalService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private AdminEmployeeApprovalDAO adminEmployeeApprovalDAO;

	
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
