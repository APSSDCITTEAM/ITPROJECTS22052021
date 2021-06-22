package com.alumni.Controller;

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


@RestController
@RequestMapping("/approval")

public class AdminApprovalController {    
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service    
	private AdminApprovalService adminApprovalService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "getallusers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallusers()
	{
		return adminApprovalService.getallusers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallVerifiedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallVerifiedUsers()
	{
		return adminApprovalService.getallVerifiedUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getinActiveJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getinActiveJobs()
	{
		return adminApprovalService.getinActiveJobs();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallApprovedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallApprovedUsers()
	{
		return adminApprovalService.getallApprovedUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallRejectedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallRejectedUsers()
	{
		return adminApprovalService.getallRejectedUsers();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallunverifiedUsers", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallunverifiedUsers()
	{
		return adminApprovalService.getallunverifiedUsers();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "ApproveUser", method = { RequestMethod.POST })
	public Response ApproveUser(@RequestBody Integer id) {
		return adminApprovalService.ApproveUser(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "RejectUser", method = { RequestMethod.POST })
	public Response RejectUser(@RequestBody Integer id) {
		return adminApprovalService.RejectUser(id);
	}
	
	
	
	/* .........................................Job Approvals................................... */
	/* Getting all jobs */
	@ResponseBody
	@RequestMapping(value = "getallJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallJobs()
	{
		return adminApprovalService.getallJobs();
	}
	
	/* getting submitted jobs */
	@ResponseBody
	@RequestMapping(value = "getSubmittedJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getSubmittedJobs()
	{
		return adminApprovalService.getSubmittedJobs();
	}
	
	/* getting Approved jobs */
	@ResponseBody
	@RequestMapping(value = "getApprovedJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedJobs()
	{
		return adminApprovalService.getApprovedJobs();
	}
	
	/* getting Rejected jobs */
	@ResponseBody
	@RequestMapping(value = "getRejectedJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedJobs()
	{
		return adminApprovalService.getRejectedJobs();
	}
	
	/* Approve jobs */ 
	@ResponseBody
	@RequestMapping(value = "ApproveJob", method = { RequestMethod.POST })
	public Response ApproveJob(@RequestBody Integer id) {
		return adminApprovalService.ApproveJob(id);
	}
	
	/* Reject Jobs */
	@ResponseBody
	@RequestMapping(value = "RejectJob", method = { RequestMethod.POST })
	public Response RejectJob(@RequestBody Integer id) {
		return adminApprovalService.RejectJob(id);
	}
	
	
	/* .........................................Internship Approvals................................... */
	@ResponseBody
	@RequestMapping(value = "getallInternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallInternships()
	{
		return adminApprovalService.getallInternships();
	}
	
	@ResponseBody
	@RequestMapping(value = "getSubmittedInternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getSubmittedInternships()
	{
		return adminApprovalService.getSubmittedInternships();
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "getApprovedInternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getApprovedInternships()
	{
		return adminApprovalService.getApprovedInternships();
	}
	
	@ResponseBody
	@RequestMapping(value = "getRejectedInternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getRejectedInternships()
	{
		return adminApprovalService.getRejectedInternships();
	}
	
	@ResponseBody
	@RequestMapping(value = "ApproveInternships", method = { RequestMethod.POST })
	public Response ApproveInternships(@RequestBody Integer id) {
		return adminApprovalService.ApproveInternships(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "RejectInternships", method = { RequestMethod.POST })
	public Response RejectInternships(@RequestBody Integer id) {
		return adminApprovalService.RejectInternships(id);
	}
	
	
		

}
