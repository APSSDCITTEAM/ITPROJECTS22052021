package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.AlumniRegisterDAO;
import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Service.EmailService;
import com.alumni.Model.Email;

@Service
public class AlumniRegisterService {

	Response response = new Response();

	@Autowired
	private EmailService emailService;

	@Autowired
	private AlumniRegisterDAO alumniregisterDAO;

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

//		Mail Service Starts
		Email email = new Email();
		email.setFrom("APSSDC Alumni Registration <siemensrecruitment@apssdc.in>");
		email.setTo(alumniregisterModel.getEmail().trim());
		email.setSubject("Email Verification for the Alumni Portal");
		String msg = "Dear Participant,<br><br>" + "<b>You have successfully registered for the Alumni.</b><br><br>"
				+ "<p>Your UserName is " + alumniregisterModel.getUsername() + "<br>Your Password is "
				+ alumniregisterModel.getPassword() + "</p><br><br>"
				+ "Please click on the Below Link to verify your email.<br><br>"
				+ "http://localhost:8088/alumni/verify/" + alumniregisterModel.getToken();
		email.setText(msg);

		this.emailService.sendHtmlMsg(email);

		this.response.setSuccessful(true);

//		alumniregisterDAO.RegisteralumniEmail(token);

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

	/*
	 * ...................................... assaign role
	 * .......................................
	 */
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
		response.setResponseObject(finance);
		return response;
	}

	public Integer verifyToken(Integer token) {
		Integer status = alumniregisterDAO.verifyToken(token);
		return status;
	}

}