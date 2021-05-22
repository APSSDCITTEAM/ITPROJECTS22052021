package com.alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;

// Local
import com.alumni.Service.PostjobService;
import com.alumni.Model.PostjobModel;

@RestController
@RequestMapping("/postjob")

public class PostjobController {
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service
	private PostjobService postjobService;
	
	
	@ResponseBody
	@RequestMapping(value = "CreateJob", method = { RequestMethod.POST })
	public Response CreateJob(@RequestBody PostjobModel job)
	{
		return postjobService.CreateJob(job);       
	}
	
	@ResponseBody
	@RequestMapping(value = "CreateInternship", method = { RequestMethod.POST })
	public Response CreateInternship(@RequestBody PostjobModel job)
	{
		return postjobService.CreateInternship(job);       
	}
	
	
		

}
