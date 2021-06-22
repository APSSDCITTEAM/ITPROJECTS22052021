package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.AlumniRegisterDAO;
import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Service.EmailService;
import com.alumni.Model.Email;
import com.alumni.Model.Login;
import com.alumni.Model.PostjobModel;

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
				+ "Please click on the Below Link to verify your email.<br><br>"
				+ "http://103.44.12.218:8080/alumni/verify/" + alumniregisterModel.getToken();
		// + "http://localhost:8088/alumni/verify/" + alumniregisterModel.getToken();
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

	public Response CreateRole(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		alumniregisterDAO.CreateRole(alumniregisterModel);

//		Mail Service Starts
		Email email = new Email();
		email.setFrom("APSSDC Alumni Registration <siemensrecruitment@apssdc.in>");
		email.setTo(alumniregisterModel.getEmail().trim());
		email.setSubject("Email Verification for the Alumni Portal");
		String msg = "Dear Participant,<br><br>" + "<b>You have successfully Registered to Alumni.</b><br><br>"
				+ "<p>Your UserName is " + alumniregisterModel.getEmail() + "<br>Your Password is "
				+ alumniregisterModel.getMobile_no() + "</p><br><br>";
		email.setText(msg);

		this.emailService.sendHtmlMsg(email);

		this.response.setSuccessful(true);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	public Integer verifyToken(Integer token) {
		Integer status = alumniregisterDAO.verifyToken(token);

		String UserEmail = alumniregisterDAO.getUserEmail(token);
		String Password = alumniregisterDAO.getUserPassword(token);

		if (status == 1) {

//			Mail Service Starts
			Email email = new Email();
			email.setFrom("APSSDC Alumni Registration <siemensrecruitment@apssdc.in>");
			email.setTo(UserEmail.trim());
			email.setSubject("Email Verification for the Alumni Portal");
			String msg = "Dear Participant,<br><br>" + "<b>You have successfully Verified Your Email.</b><br><br>"
					+ "<p> Please Wait for the Admin Approval" + "</p><br><br>";
			email.setText(msg);

			this.emailService.sendHtmlMsg(email);

			this.response.setSuccessful(true);
		}
		return status;
	}

	public Response volunteershipRegister(AlumniRegisterModel finance) {
		response.setSuccessful(false);
		alumniregisterDAO.volunteershipRegister(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}

	public Response checkMail(AlumniRegisterModel job) {
		response.setSuccessful(false);
		/* login.setPassword(CryptoUtils.getMD5Hash(login.getPassword())); */
		Integer mailStatus = alumniregisterDAO.checkMail(job);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(mailStatus);
		if (mailStatus == 0) {
			response.setSuccessful(false);
		} else if (mailStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}

	public Response checkMobile(AlumniRegisterModel job) {
		response.setSuccessful(false);
		/* login.setPassword(CryptoUtils.getMD5Hash(login.getPassword())); */
		Integer phoneStatus = alumniregisterDAO.checkMobile(job);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(phoneStatus);
		if (phoneStatus == 0) {
			response.setSuccessful(false);
		} else if (phoneStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}

	public Response AddRole(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		alumniregisterDAO.AddRole(alumniregisterModel);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	/* getting all roles */
	public Response getallroles() {
		response.setSuccessful(false);
		List<AlumniRegisterModel> userdetails = alumniregisterDAO.getallroles();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	/* getting role data to pop up */
	public Response getRoleData(Integer role_id) {
		response.setSuccessful(false);
		AlumniRegisterModel singleuserdetails = alumniregisterDAO.getRoleData(role_id);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		return response;
	}

	/* update role data */
	public Response updateRole(AlumniRegisterModel alumniregisterModel) {
		response.setSuccessful(false);
		alumniregisterDAO.updateRole(alumniregisterModel);
		response.setSuccessful(true);
		response.setResponseObject(alumniregisterModel);
		return response;
	}

	/* delete role data */
	public Response remove(Integer role_id) {
		response.setSuccessful(false);
		alumniregisterDAO.remove(role_id);
		response.setSuccessful(true);
		response.setResponseObject(role_id);
		return response;
	}

}