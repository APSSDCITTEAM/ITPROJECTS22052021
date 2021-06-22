package com.alumni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

//Local
import com.alumni.DAO.PostjobDAO;
import com.alumni.Model.PostjobModel;

@Service
public class PostjobService {
	
	Response response = new Response();
	
	@Autowired
//Discussion DAO
	private PostjobDAO postjobDAO;

	
	public Response CreateJob(PostjobModel finance) {		
		response.setSuccessful(false);
		postjobDAO.CreateJob(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}
	
	public Response CreateInternship(PostjobModel finance) {		
		response.setSuccessful(false);
		postjobDAO.CreateInternship(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}
	public Response CreateVolunteership(PostjobModel finance) {		
		response.setSuccessful(false);
		postjobDAO.CreateVolunteership(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}

}
