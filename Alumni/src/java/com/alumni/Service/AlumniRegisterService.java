package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.AlumniRegisterDAO;
import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.EventsModel;

@Service
public class AlumniRegisterService {
	@Autowired
	private AlumniRegisterDAO alumniregisterDAO;

	Response response = new Response();

	public Response Registeralumni(AlumniRegisterModel finance) {		
		response.setSuccessful(false);
		alumniregisterDAO.Registeralumni(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}
	
	
	/* ...................................... assaign role ....................................... */
	/*
	 * public Response CreateRole(AlumniRegisterModel finance) {
	 * response.setSuccessful(false); alumniregisterDAO.CreateRole(finance);
	 * response.setSuccessful(true); System.out.println("hi1");     
	 * response.setResponseObject(finance); return response; }
	 */
	
	
	public Response CreateRole(AlumniRegisterModel finance) {		
		response.setSuccessful(false);
		alumniregisterDAO.CreateRole(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}

	public Response getAllAlumnisData() {
		response.setSuccessful(false);
		List<AlumniRegisterModel> userdetails = alumniregisterDAO.getAllAlumnisData();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

}