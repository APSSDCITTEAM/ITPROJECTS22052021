package com.alumni.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;

//Local
import com.alumni.DAO.DiscussionDAO;
import com.alumni.DAO.IndexDAO;
import com.alumni.DAO.PostjobDAO;
import com.alumni.DAO.ViewJobDAO;
import com.alumni.Model.DiscussionModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.IndexModel;
import com.alumni.Model.PostjobModel;
import com.alumni.Model.ViewJobModel;
import com.alumni.Model.AlumniRegisterModel;

@Service
public class IndexService {

	Response response = new Response();

	@Autowired
//Discussion DAO
	private IndexDAO indexDAO;

	

	public Response getallRecentjobs() {
		response.setSuccessful(false);
		List<IndexModel> userdetails = indexDAO.getallRecentjobs();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* .............................. get members count ............................ */
	 public Response getMembersCount()
		{
			response.setSuccessful(false);
			IndexModel singleuserdetails = indexDAO.getMembersCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get jobs count ............................ */
	 public Response getJobsCount()
		{
			response.setSuccessful(false);
			IndexModel singleuserdetails = indexDAO.getJobsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get interns count ............................ */
	 public Response getInternsCount()
		{
			response.setSuccessful(false);
			IndexModel singleuserdetails = indexDAO.getInternsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	 
	 /* .............................. get events count ............................ */
	 public Response getEventsCount()
		{
			response.setSuccessful(false);
			IndexModel singleuserdetails = indexDAO.getEventsCount();
			response.setSuccessful(true);
			response.setResponseObject(singleuserdetails);
			return response;
		}
	

}
