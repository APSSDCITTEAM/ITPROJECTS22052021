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
import com.alumni.Model.DiscussionModel;

@RestController
@RequestMapping("/Discussion")

public class DiscussionController {
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service
	private DiscussionService discussionService;
	
	@ResponseBody
	@RequestMapping(value = "postDiscussion", method = { RequestMethod.POST})
	public Response postDiscussion(@RequestBody DiscussionModel discussionModel) {
		return discussionService.postDiscussion(discussionModel);
	}
	
	
	
		

}
