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
import com.alumni.Service.IndexService;


@RestController
@RequestMapping("/index")

public class IndexController {    
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service    
	private IndexService indexService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "getallRecentjobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallRecentjobs()
	{
		return indexService.getallRecentjobs();
	}
	
	/* .................................. getting count of members ................................ */
	@ResponseBody
	@RequestMapping(value = "getMembersCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getMembersCount()
	{
		return indexService.getMembersCount();
	}
	
	/* .................................. getting count of Jobs ................................ */
	@ResponseBody
	@RequestMapping(value = "getJobsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getJobsCount()
	{
		return indexService.getJobsCount();
	}
	
	/* .................................. getting count of Interns ................................ */
	@ResponseBody
	@RequestMapping(value = "getInternsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getInternsCount()
	{
		return indexService.getInternsCount();
	}
	
	/* .................................. getting count of Events ................................ */
	@ResponseBody
	@RequestMapping(value = "getEventsCount", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getEventsCount()
	{
		return indexService.getEventsCount();
	}
	
	
		

}
