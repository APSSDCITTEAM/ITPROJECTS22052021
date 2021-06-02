package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

//Local
import com.alumni.DAO.DiscussionDAO;
import com.alumni.DAO.PostjobDAO;
import com.alumni.DAO.ViewJobDAO;
import com.alumni.Model.DiscussionModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.PostjobModel;
import com.alumni.Model.ViewJobModel;

@Service
public class ViewJobService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private ViewJobDAO viewjobDAO;

	public Response getalljobs(Integer std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getalljobs(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response getallinternships(Integer std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallinternships(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response getalljobshome() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getalljobshome();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response getallinternshipshome() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallinternshipshome();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* .......................................... Job Action ......................................... */
	
	public Response getallOpenJobs() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallOpenJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallClosedJobs() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallClosedJobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response changeJobStatus(ViewJobModel finance)
	{
		response.setSuccessful(false);
		viewjobDAO.changeJobStatus(finance);
		response.setSuccessful(true);
		response.setResponseObject(finance);
		return response;
	}
	
/* .......................................... Interns Action ......................................... */
	
	public Response getallOpenInterns() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallOpenInterns();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallClosedInterns() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallClosedInterns();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response changeInternStatus(ViewJobModel finance)
	{
		response.setSuccessful(false);
		viewjobDAO.changeInternStatus(finance);
		response.setSuccessful(true);
		response.setResponseObject(finance);
		return response;
	}
	
	

}
