package com.alumni.Service;

import com.alumni.Model.Login;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
//import org.apache.commons.mail.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.LoginDAO;
import com.andromeda.commons.util.AadhaarUtils;
import com.andromeda.commons.util.CryptoUtils;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	Response response = new Response();

	public Response login(Login login) {
		response.setSuccessful(false);
		/* System.out.println(login); */

		/* login.setPassword(CryptoUtils.getMD5Hash(login.getPassword())); */
		Integer loginStatus = loginDAO.checkUser(login);

		if (loginStatus == 0) {
			response.setSuccessful(false);
		} else if (loginStatus == 1) {
			
			Login details = loginDAO.getUserDetails(login);
			details.setIpaddress(login.getIpaddress());
			// loginDAO.saveToLogins(details);
			response.setSuccessful(true);
			response.setResponseObject(details);
		}
		return response;
	}

	/*
	 * public Response login(Login login) { this.response.setSuccessful(false);
	 * 
	 * Integer userStatus = this.loginDAO.checkUser(login); if
	 * (userStatus.intValue() == 0) { this.response.setSuccessful(false); } else if
	 * (userStatus.intValue() > 0) { Login details =
	 * this.loginDAO.getUserDetails(login);
	 * details.setContext(IDGenerator.getUniqueID());
	 * details.setIpAddress(login.getIpAddress()); details.setIpAddress("");
	 * 
	 * this.loginDAO.saveToLogins(details);
	 * 
	 * this.response.setSuccessful(true); this.response.setResponseObject(details);
	 * } return this.response; }
	 */
	public Boolean isUserLoggedIn(Login login) {
		Boolean status = false;
		if ((!StringUtils.isEmpty(login.getUsername())) && (!StringUtils.isEmpty(login.getPassword()))) {
			Integer loginStatus = loginDAO.isUserLoggedIn(login);
			System.out.println("-------------------------");
			System.out.println(loginStatus);
			System.out.println("-------------------------");
			if (loginStatus == 0) {
				status = false;
			} else if (loginStatus > 0) {
				status = true;
			}
		}

		return status;
	}

	public Response validateAadhaar(String aadhaar) {
		response.setSuccessful(false);

		if (AadhaarUtils.isValidAadhaar(aadhaar)) {
			response.setSuccessful(true);
		} else {
			response.setSuccessful(false);
		}
		return response;
	}

	public void logout(String user_id) {
		// System.out.println("Service"+user_id);
		loginDAO.deleteLoginLog(user_id);
	}

	public Response createLogin(Login login) {
		response.setSuccessful(false);
		Login login1 = loginDAO.createLogin(login);
		response.setSuccessful(true);
		response.setResponseObject(login1);
		return response;
	}

	/*
	 * .............................................. employee login
	 * ....................................
	 */
	public Response saveLoginDetails(Login login) throws ParseException {
		response.setSuccessful(loginDAO.saveLoginDetails(login));
		return response;
	}

	public Response getLoginDetails(Login login) {
		this.response.setSuccessful(false);
		Login singleuserdetails = this.loginDAO.getLoginDetails(login);
		this.response.setSuccessful(true);
		this.response.setResponseObject(singleuserdetails);
		return this.response;
	}

	public Response saveLogoutDetails(Login login) throws ParseException {
		response.setSuccessful(loginDAO.saveLogoutDetails(login));
		return response;
	}

	public Response GetLoginData(Login login) {
		response.setSuccessful(false);
		List<Map<String, Object>> list = loginDAO.GetLoginData(login);
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}

	public Response gettodayLogins() {
		response.setSuccessful(false);
		List<Login> userdetails = loginDAO.gettodayLogins();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

}