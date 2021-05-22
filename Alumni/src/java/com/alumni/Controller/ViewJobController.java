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
import com.alumni.Model.PostjobModel;

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
		

}
