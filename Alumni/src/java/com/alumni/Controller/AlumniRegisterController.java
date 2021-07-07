package com.alumni.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;

import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.Login;
import com.alumni.Model.PostjobModel;
import com.alumni.Service.AlumniRegisterService;

import org.json.JSONException;
import org.postgresql.util.Base64;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/register")
public class AlumniRegisterController {

	@Autowired
	private AlumniRegisterService alumniregisterService;
	String file = null;

	/*
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "studentRegister", method = { RequestMethod.POST })
	 * 
	 * public Response Registeralumni(@RequestBody AlumniRegisterModel
	 * alumniregisterModel) {
	 * 
	 * return alumniregisterService.Registeralumni(alumniregisterModel); }
	 * 
	 */

	/* for file upload */
	/*
	 * public Response Registeralumni(@RequestBody List<AlumniRegisterModel>
	 * alumniregisterModel) { for (AlumniRegisterModel alumnifile :
	 * alumniregisterModel) { handleFileUpload(alumnifile);
	 * alumnifile.setImage(file); }
	 * 
	 * return alumniregisterService.Registeralumni(alumniregisterModel); }
	 * 
	 * public String handleFileUpload(AlumniRegisterModel alumniregisterModel) {
	 * FileOutputStream fos = null;
	 * 
	 * try { String folderName = "alumniphotos"; String imageValue =
	 * alumniregisterModel.getBase64String(); byte[] imageByteArray =
	 * decodeImage(imageValue);
	 * 
	 * String baseDir = System.getProperty("catalina.base") + "/webapps/uploads/" +
	 * "alumniphotos" + "/" + folderName; File dir = new File(baseDir); if
	 * (!Files.isDirectory(Paths.get(baseDir))) { dir.mkdirs(); }
	 * 
	 * String alumniphotoFileName = UUID.randomUUID().toString();
	 * 
	 * fos = new FileOutputStream(baseDir + "/" + alumniphotoFileName + ".png");
	 * file = "/uploads/" + "alumniphotos" + "/" + folderName + "/" +
	 * alumniphotoFileName + ".png"; fos.write(imageByteArray); fos.close();
	 * 
	 * System.out.println("---Path--> " + file);
	 * alumniregisterModel.setFile_Name(file); } catch (Exception e) {
	 * System.out.println("Exception: " + e.getMessage()); } return file.trim(); }
	 * 
	 * public static byte[] decodeImage(String imageValue) { return
	 * Base64.decode(imageValue); }
	 * 
	 * 
	 * 
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = { "/checkAadhaar" }, method = {
	 * org.springframework.web.bind.annotation.RequestMethod.POST }) public Response
	 * checkAadhaar(@RequestBody String aadhaar) { return
	 * this.alumniregisterService.checkAadhaar(aadhaar); }
	 */

	@ResponseBody
	@RequestMapping(value = "getAllAlumnisData", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAllAlumnisData() {
		return alumniregisterService.getAllAlumnisData();
	}

	@ResponseBody
	@RequestMapping(value = "studentRegister", method = { RequestMethod.POST })
	public Response Registeralumni(@RequestBody AlumniRegisterModel job) {
		String token = job.getFirst_name() + job.getMobile_no() + job.getEmail() + job.getCollege_code();
		Integer hashToken = token.hashCode();
		if (hashToken < 0) {
			hashToken = Math.abs(hashToken);
		}
		job.setToken(hashToken);
		System.out.println(hashToken);
		String username = job.getEmail();
		String password = job.getMobile_no().toString();
		job.setPassword(password);
		job.setUsername(username);
		return alumniregisterService.Registeralumni(job);
	}

	/*
	 * .......................................... Role creation
	 * ..........................................
	 */
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "CreateRole", method = { RequestMethod.POST }) public
	 * Response CreateRole(@RequestBody AlumniRegisterModel job) {
	 * System.out.println("hi2"); return alumniregisterService.CreateRole(job); }
	 */

	@ResponseBody
	@RequestMapping(value = "CreateRole", method = { RequestMethod.POST })
	public Response CreateRole(@RequestBody AlumniRegisterModel job) {
		String username = job.getEmail();
		String password = job.getMobile_no().toString();
		job.setPassword(password);
		job.setUsername(username);
		return alumniregisterService.CreateRole(job);
	}

	@ResponseBody
	@RequestMapping(value = "volunteershipRegister", method = { RequestMethod.POST })
	public Response volunteershipRegister(@RequestBody AlumniRegisterModel job) {
		return alumniregisterService.volunteershipRegister(job);
	}

	@ResponseBody
	@RequestMapping(value = "/checkMail", method = { RequestMethod.POST, RequestMethod.GET })
	public Response checkMail(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return alumniregisterService.checkMail(job);
	}

	@ResponseBody
	@RequestMapping(value = "/checkMobile", method = { RequestMethod.POST, RequestMethod.GET })
	public Response checkMobile(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return alumniregisterService.checkMobile(job);
	}

	/* creating roles */
	@ResponseBody
	@RequestMapping(value = "AddRole", method = { RequestMethod.POST })
	public Response AddRole(@RequestBody AlumniRegisterModel role) {
		return alumniregisterService.AddRole(role);
	}

	/* getting all roles */
	@ResponseBody
	@RequestMapping(value = "getallroles", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallroles() {
		return alumniregisterService.getallroles();
	}

	/* getting data to pop up in create role */
	@ResponseBody
	@RequestMapping(value = "getRoleData", method = { RequestMethod.POST })
	public Response getRoleData(@RequestBody Integer role_id) {
		return alumniregisterService.getRoleData(role_id);
	}

	/* update role data */
	@ResponseBody
	@RequestMapping(value = "updateRole", method = { RequestMethod.POST })
	public Response updateRole(@RequestBody AlumniRegisterModel role) {
		return alumniregisterService.updateRole(role);
	}

	/* delete role data */
	@ResponseBody
	@RequestMapping(value = "DeleteRoleData", method = { RequestMethod.POST })
	public Response remove(@RequestBody Integer role_id) {
		return alumniregisterService.remove(role_id);
	}
	
	/* Forgot Password */
	@ResponseBody
	@RequestMapping(value = "sendotp", method = { RequestMethod.POST, RequestMethod.GET })
	public Response sendotp(@RequestBody AlumniRegisterModel job) {
		return alumniregisterService.sendotp(job);
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyotp", method = { RequestMethod.POST, RequestMethod.GET })
	public Response verifyotp(@RequestBody AlumniRegisterModel job)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return alumniregisterService.verifyotp(job);
	}
	
	/* Update Password */
	
	@ResponseBody
	@RequestMapping(value = "updatePassword", method = { RequestMethod.POST, RequestMethod.GET })
	public Response updatePassword(@RequestBody AlumniRegisterModel job) {
		return alumniregisterService.updatePassword(job);
	}
}