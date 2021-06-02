package com.alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;

// Local
import com.alumni.Service.DiscussionService;
import com.alumni.Service.PostjobService;
import com.alumni.Service.ViewJobService;
import com.alumni.Model.DiscussionModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.PostjobModel;
import com.alumni.Model.ViewJobModel;

@RestController
@RequestMapping("/viewjob")

public class ViewJobController {    
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service    
	private ViewJobService viewjobService;
	
	
	@ResponseBody
	@RequestMapping(value = "getalljobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getalljobs(@RequestBody Integer std_id)
	{
		return viewjobService.getalljobs(std_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "getallinternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallinternships(@RequestBody Integer std_id)
	{
		return viewjobService.getallinternships(std_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "getalljobshome", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getalljobshome()
	{
		return viewjobService.getalljobshome();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallinternshipshome", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallinternshipshome()
	{
		return viewjobService.getallinternshipshome();
	}
	
	/* .................................. Job Actions ............................................ */
	@ResponseBody
	@RequestMapping(value = "getallOpenJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallOpenJobs()
	{
		return viewjobService.getallOpenJobs();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallClosedJobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallClosedJobs()
	{
		return viewjobService.getallClosedJobs();
	}
	
	@ResponseBody
	@RequestMapping(value = "changeJobStatus", method = { RequestMethod.POST })
	public Response changeJobStatus(@RequestBody ViewJobModel event)
	{
		return viewjobService.changeJobStatus(event);
	}
	
	/* .................................. Interns Actions ............................................ */
	@ResponseBody
	@RequestMapping(value = "getallOpenInterns", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallOpenInterns()
	{
		return viewjobService.getallOpenInterns();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallClosedInterns", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallClosedInterns()
	{
		return viewjobService.getallClosedInterns();
	}
	
	@ResponseBody
	@RequestMapping(value = "changeInternStatus", method = { RequestMethod.POST })
	public Response changeInternStatus(@RequestBody ViewJobModel event)
	{
		return viewjobService.changeInternStatus(event);
	}
		

}
