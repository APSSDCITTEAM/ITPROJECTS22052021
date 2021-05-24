package com.alumni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

//Local
import com.alumni.DAO.DiscussionDAO;
import com.alumni.Model.DiscussionModel;

@Service
public class DiscussionService {
	
	Response response = new Response();
	
	@Autowired
//Discussion DAO
	private DiscussionDAO discussionDAO;

	public Response postDiscussion(DiscussionModel discussionModel) {
		response.setSuccessful(false);
		discussionDAO.postDiscussion(discussionModel);
		response.setSuccessful(true);
		response.setResponseObject(discussionModel);
		return response;
	}

}
