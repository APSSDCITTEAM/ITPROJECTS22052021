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

	
	
	/*
	 * public Response Applyjob(AlumniRegisterModel alumniregisterModel) {
	 * response.setSuccessful(false); viewjobDAO.Applyjob(alumniregisterModel);
	 * response.setSuccessful(true);
	 * response.setResponseObject(alumniregisterModel); return response; }
	 */
	
	
	public Response Applyjob(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		Integer jobStatus = viewjobDAO.checkJob(alumniregisterModel);

		if (jobStatus == 0) {
			viewjobDAO.InsertApplyjob(alumniregisterModel);
			response.setSuccessful(false);
			response.setResponseObject(alumniregisterModel);
		} else if (jobStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}
	
	
	/*
	 * public Response ApplyInternship(AlumniRegisterModel alumniregisterModel) {
	 * response.setSuccessful(false);
	 * viewjobDAO.ApplyInternship(alumniregisterModel);
	 * response.setSuccessful(true);
	 * response.setResponseObject(alumniregisterModel); return response; }
	 */
	
	
	public Response ApplyInternship(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		Integer internStatus = viewjobDAO.checkInternship(alumniregisterModel);

		if (internStatus == 0) {
			viewjobDAO.InsertApplyInternship(alumniregisterModel);
			response.setSuccessful(false);
			response.setResponseObject(alumniregisterModel);
		} else if (internStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}
	
	

	public Response InternshipApplicants(Integer id) {
		response.setSuccessful(false);
		Map<String, Object> list = viewjobDAO.InternshipApplicants(id);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}
	
	
	public Response JobApplicants(Integer id) {
		response.setSuccessful(false);
		Map<String, Object> list = viewjobDAO.JobApplicants(id);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}
	
	
	
	/* ..................................... update job status based on end date ............................. */
	public Response UpdateJobStatusbyDate(ViewJobModel finance)
	{
		response.setSuccessful(false);
		viewjobDAO.UpdateJobStatusbyDate(finance);
		response.setSuccessful(true);
		response.setResponseObject(finance);
		return response;
	}
	
	/* ..................................... update job status based on end date ............................. */
	public Response UpdateInternStatusbyDate(ViewJobModel finance)
	{
		response.setSuccessful(false);
		viewjobDAO.UpdateInternStatusbyDate(finance);
		response.setSuccessful(true);
		response.setResponseObject(finance);
		return response;
	}
	
	public Response getallvolunteerships(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallvolunteerships(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getmyvolunteerships(String std_id) {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getmyvolunteerships(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallvolunteershipshome() {
		response.setSuccessful(false);
		List<ViewJobModel> userdetails = viewjobDAO.getallvolunteershipshome();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	/*
	 * public Response Applyvolunteer(AlumniRegisterModel alumniregisterModel) {
	 * response.setSuccessful(false);
	 * viewjobDAO.Applyvolunteer(alumniregisterModel); response.setSuccessful(true);
	 * response.setResponseObject(alumniregisterModel); return response; }
	 */
	
	public Response Applyvolunteer(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		Integer internStatus = viewjobDAO.checkVolunteer(alumniregisterModel);

		if (internStatus == 0) {
			viewjobDAO.InsertApplyvolunteer(alumniregisterModel);
			response.setSuccessful(false);
			response.setResponseObject(alumniregisterModel);
		} else if (internStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}
	
	
	
	public Response VolunteershipApplicants(Integer id) {
		response.setSuccessful(false);
		Map<String, Object> list = viewjobDAO.VolunteershipApplicants(id);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}



	

}
