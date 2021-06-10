package com.alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andromeda.commons.model.Response;
import com.alumni.Service.AlumniRegisterService;

@Controller

public class AlumniVerifyUserController {

	Response response = new Response();

	@Autowired
//	Discussion Service    
	private AlumniRegisterService alumniregisterService;

	/* @ResponseBody */
	@RequestMapping("/verify/{token}")
	public String verifyToken(@PathVariable Integer token) {
		System.out.println(token);
		Integer status = alumniregisterService.verifyToken(token);

		if (status == 1) {
			String verify_token = "Verify";
			return verify_token;
		} else {
			String verify_token = "Failed";
			return verify_token;
		}
		
	}

}
