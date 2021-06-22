package com.alumni.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
import com.alumni.Model.AlumniRegisterModel;

@RestController
@RequestMapping("/viewjob")

public class ViewJobController {    
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service    
	private ViewJobService viewjobService;
	
	
	@ResponseBody
	@RequestMapping(value = "getalljobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getalljobs(@RequestBody String std_id)
	{
		return viewjobService.getalljobs(std_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "getmyjobs", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getmyjobs(@RequestBody String std_id)
	{
		return viewjobService.getmyjobs(std_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "getallinternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallinternships(@RequestBody String std_id)
	{
		return viewjobService.getallinternships(std_id);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "getmyinternships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getmyinternships(@RequestBody String std_id)
	{
		return viewjobService.getmyinternships(std_id);
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
	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "Applyjob", method = { RequestMethod.POST }) public
	 * Response Applyjob(@RequestBody AlumniRegisterModel job) { return
	 * viewjobService.Applyjob(job); }
	 */
	
	@ResponseBody
	@RequestMapping(value = "/Applyjob", method = { RequestMethod.POST, RequestMethod.GET })
	public Response Applyjob(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return viewjobService.Applyjob(job);
	}

	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "ApplyInternship", method = { RequestMethod.POST })
	 * public Response ApplyInternship(@RequestBody AlumniRegisterModel job) {
	 * return viewjobService.ApplyInternship(job); }
	 */
	
	@ResponseBody
	@RequestMapping(value = "/ApplyInternship", method = { RequestMethod.POST, RequestMethod.GET })
	public Response ApplyInternship(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return viewjobService.ApplyInternship(job);
	}
	
	
	/* .................................. Interns Applicants ............................................ */
	@ResponseBody
	@RequestMapping(value = { "/InternshipApplicants" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response InternshipApplicants(@RequestBody Integer id) {
		return viewjobService.InternshipApplicants(id);
	}
	
	/* .................................. Interns Applicants ............................................ */
	@ResponseBody
	@RequestMapping(value = { "/JobApplicants" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response JobApplicants(@RequestBody Integer id) {
		return viewjobService.JobApplicants(id);
	}
	
	
	/* ............................... update job status based on end date ................................ */
	@ResponseBody
	@RequestMapping(value = "UpdateJobStatusbyDate", method = { RequestMethod.POST })
	public Response UpdateJobStatusbyDate(@RequestBody ViewJobModel event)
	{
		return viewjobService.UpdateJobStatusbyDate(event);
	}
	
	/* ............................... update job status based on end date ................................ */
	@ResponseBody
	@RequestMapping(value = "UpdateInternStatusbyDate", method = { RequestMethod.POST })
	public Response UpdateInternStatusbyDate(@RequestBody ViewJobModel event)
	{
		return viewjobService.UpdateInternStatusbyDate(event);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "getallvolunteerships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallvolunteerships(@RequestBody String std_id)
	{
		return viewjobService.getallvolunteerships(std_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "getmyvolunteerships", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getmyvolunteerships(@RequestBody String std_id)
	{
		return viewjobService.getmyvolunteerships(std_id);
	}
	@ResponseBody
	@RequestMapping(value = "getallvolunteershipshome", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallvolunteershipshome()
	{
		return viewjobService.getallvolunteershipshome();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/VolunteershipApplicants" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response VolunteershipApplicants(@RequestBody Integer id) {
		return viewjobService.VolunteershipApplicants(id);
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "Applyvolunteer", method = { RequestMethod.POST })
	 * public Response Applyvolunteer(@RequestBody AlumniRegisterModel job) { return
	 * viewjobService.Applyvolunteer(job); }
	 */

	@ResponseBody
	@RequestMapping(value = "/Applyvolunteer", method = { RequestMethod.POST, RequestMethod.GET })
	public Response Applyvolunteer(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return viewjobService.Applyvolunteer(job);
	}
	
		

}
