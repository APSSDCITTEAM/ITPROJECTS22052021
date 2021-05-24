package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.AlumniRegisterDAO;
import com.alumni.Model.AlumniRegisterModel;

@Service
public class AlumniRegisterService {
	@Autowired
	private AlumniRegisterDAO alumniregisterDAO;

	Response response = new Response();

	/* for file upload */

	public Response Registeralumni(List<AlumniRegisterModel> alumniregisterModel) {
		response.setSuccessful(false);

		for (AlumniRegisterModel alumnifile : alumniregisterModel)
			alumniregisterDAO.Registeralumni(alumnifile);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	public Response Registeralumni(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);

		alumniregisterDAO.Registeralumni(alumniregisterModel);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
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