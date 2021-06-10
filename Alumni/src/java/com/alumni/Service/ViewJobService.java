package com.alumni.Service;

import java.util.List;
import java.util.Map;

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
import com.alumni.Model.AlumniRegisterModel;

@Service
public class ViewJobService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private ViewJobDAO viewjobDAO;

	public Response getalljobs(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getalljobs(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getmyjobs(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getmyjobs(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	public Response getallinternships(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallinternships(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getmyinternships(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getmyinternships(std_id);
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

	
	
	public Response Applyjob(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		viewjobDAO.Applyjob(alumniregisterModel);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	
	public Response ApplyInternship(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		viewjobDAO.ApplyInternship(alumniregisterModel);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	/*
	 * public Response InternshipApplicants(ViewJobModel job) {
	 * response.setSuccessful(false); List<Map<String, Object>> list =
	 * viewjobDAO.InternshipApplicants(job); response.setSuccessful(true);
	 * response.setResponseObject(list); return response; }
	 */

	public Response InternshipApplicants(Integer id) {
		response.setSuccessful(false);
		Map<String, Object> list = viewjobDAO.InternshipApplicants(id);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}
	

}
