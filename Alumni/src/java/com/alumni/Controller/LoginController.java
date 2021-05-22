package com.alumni.Controller;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;

import com.alumni.Model.Login;
import com.alumni.Service.LoginService;                

@RestController
@RequestMapping("/logins")
public class LoginController
{    
	@Autowired    
	private LoginService loginService;

	@ResponseBody
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public Response login(@RequestBody Login login, HttpServletRequest httpServletRequest)
			throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		/* System.out.println(login); */
		//String clientProxyIp = HttpUtils.getClientProxyAddress(httpServletRequest);
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp ;//+ ", CLIENT_PROXY:" + clientProxyIp;
		login.setIpaddress(ipaddress);
		return loginService.login(login);
	}        

	@ResponseBody
	@RequestMapping(value = "loggedin", method = { RequestMethod.POST })
	public Boolean isUserLoggedIn(@RequestBody Login login)
	{
		Boolean status = loginService.isUserLoggedIn(login);
		return status;
	}
	@ResponseBody
	@RequestMapping(value = "validateAadhaar", method = { RequestMethod.POST })
	public Response validateAadhaar(@RequestBody String aadhaar)
	{
		System.out.println("--AADHAAR--");
		System.out.println(aadhaar);
		return loginService.validateAadhaar(aadhaar);
	}
	@ResponseBody
	@RequestMapping(value = "/logout", method = { RequestMethod.POST })
	public void logout(@RequestBody String user_id)
	{
			//System.out.println("Controller"+user_id);
			loginService.logout(user_id);
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/createLogin", method = { RequestMethod.POST })
	private Response createLogin(@RequestBody Login login,
			HttpServletRequest httpServletRequest) throws JarException
	{
		String clientIp = HttpUtils.getClientAddress(httpServletRequest);
		String ipaddress = "CLIENT:" + clientIp;
		login.setIpaddress(ipaddress);
		return loginService.createLogin(login);
	}
	
	
	
	/* .............................................. employee login ................................... */
	@ResponseBody
	@RequestMapping(value = { "/saveLoginDetails" }, method = { RequestMethod.POST })
	public Response saveLoginDetails(@RequestBody Login login) throws ParseException {
		return loginService.saveLoginDetails(login);
	}
	
	@ResponseBody
	@RequestMapping(value={"getLoginDetails"}, method={ RequestMethod.POST, RequestMethod.GET })
	public Response getLoginDetails(@RequestBody Login login)
	{
	   return this.loginService.getLoginDetails(login);
	} 
	
	@ResponseBody   
	@RequestMapping(value = { "/saveLogoutDetails" }, method = { RequestMethod.POST })
	public Response saveLogoutDetails(@RequestBody Login login) throws ParseException {
		return loginService.saveLogoutDetails(login);
	}
	
	@ResponseBody
	@RequestMapping(value = "GetLoginData", method = { RequestMethod.POST, RequestMethod.GET })
	public Response GetLoginData(@RequestBody Login Data)
	{
		return loginService.GetLoginData(Data);
	}
	
	@ResponseBody
	@RequestMapping(value = "gettodayLogins", method = { RequestMethod.POST, RequestMethod.GET })
	public Response gettodayLogins()
	{
		return loginService.gettodayLogins();
	}
	
	

	

}