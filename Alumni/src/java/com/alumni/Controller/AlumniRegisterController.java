package com.alumni.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	
	@ResponseBody
	@RequestMapping(value = "studentRegister", method = { RequestMethod.POST })

	public Response Registeralumni(@RequestBody AlumniRegisterModel alumniregisterModel) {

		return alumniregisterService.Registeralumni(alumniregisterModel);
	}
	
	*/

	/* for file upload */
	/*
	public Response Registeralumni(@RequestBody List<AlumniRegisterModel> alumniregisterModel) {
		for (AlumniRegisterModel alumnifile : alumniregisterModel) {
			handleFileUpload(alumnifile);
			alumnifile.setImage(file);
		}

		return alumniregisterService.Registeralumni(alumniregisterModel);
	}

	public String handleFileUpload(AlumniRegisterModel alumniregisterModel) {
		FileOutputStream fos = null;

		try {
			String folderName = "alumniphotos";
			String imageValue = alumniregisterModel.getBase64String();
			byte[] imageByteArray = decodeImage(imageValue);

			String baseDir = System.getProperty("catalina.base") + "/webapps/uploads/" + "alumniphotos" + "/"
					+ folderName;
			File dir = new File(baseDir);
			if (!Files.isDirectory(Paths.get(baseDir))) {
				dir.mkdirs();
			}

			String alumniphotoFileName = UUID.randomUUID().toString();

			fos = new FileOutputStream(baseDir + "/" + alumniphotoFileName + ".png");
			file = "/uploads/" + "alumniphotos" + "/" + folderName + "/" + alumniphotoFileName + ".png";
			fos.write(imageByteArray);
			fos.close();

			System.out.println("---Path--> " + file);
			alumniregisterModel.setFile_Name(file);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return file.trim();
	}

	public static byte[] decodeImage(String imageValue) {
		return Base64.decode(imageValue);
	}
	
	
	
	*/
	
	@ResponseBody
	@RequestMapping(value = "getAllAlumnisData", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getAllAlumnisData()
	{
		return alumniregisterService.getAllAlumnisData();
	}        
	
	
	
	@ResponseBody
	@RequestMapping(value = "studentRegister", method = { RequestMethod.POST })
	public Response Registeralumni(@RequestBody AlumniRegisterModel job)
	{
		return alumniregisterService.Registeralumni(job);       
	}
	

}