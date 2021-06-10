package com.alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;
import com.alumni.Model.AdminEmployeeApprovalModel;

// Local
import com.alumni.Service.AdminEmployeeApprovalService;


@RestController
@RequestMapping("/empapproval")

public class AdminEmployeeApprovalController {    
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service    
	private AdminEmployeeApprovalService adminEmployeeApprovalService;
	
	   
	      
	@ResponseBody
	@RequestMapping(value = "getallusers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallusers()
	{
		return adminEmployeeApprovalService.getallusers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallVerifiedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallVerifiedUsers()
	{
		return adminEmployeeApprovalService.getallVerifiedUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallApprovedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallApprovedUsers()
	{
		return adminEmployeeApprovalService.getallApprovedUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallRejectedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallRejectedUsers()
	{
		return adminEmployeeApprovalService.getallRejectedUsers();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "ApproveUser", method = { RequestMethod.POST })
	public Response ApproveUser(@RequestBody Integer id) {
		return adminEmployeeApprovalService.ApproveUser(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "RejectUser", method = { RequestMethod.POST })
	public Response RejectUser(@RequestBody Integer id) {
		return adminEmployeeApprovalService.RejectUser(id);
	}
	
		

}
