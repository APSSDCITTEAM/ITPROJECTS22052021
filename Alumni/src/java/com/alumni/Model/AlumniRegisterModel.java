package com.alumni.Model;


import java.math.BigInteger;

import java.util.List;

import com.andromeda.commons.model.BaseModel;
import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.FileModel;

@SuppressWarnings({ "unused", "serial" })
public class AlumniRegisterModel extends BaseModel {    
	
	private static long serialVersionUID = 1L;
	public Integer std_id;
	public String username;
	public String first_name; 
	public String last_name; 
	public String password; 
	public String email;
	public BigInteger mobile_no; 
	public String  photo;
	public boolean status;
	public String fileName;
	public String base64String;
	public Integer type;
	public String college_code;
	public String roll_number;
	public String organization_name;
	public String employee_id;
	public String filepath;             
	
	public List<AlumniRegisterModel>uploadfiles;
	public String folderName;
	public String filePaths;
	public String[] filePathsArr;
	public List<FileModel> files;
	public String image;    
	public String file;
	public String file_name;
	public String statustype;
	public String qualification;
	public String branch;
	public Integer passed_out_year;
	public String district;
	public String other_qualifiction;
	
	
	
	
	
	
	
	
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Integer getPassed_out_year() {
		return passed_out_year;
	}
	public void setPassed_out_year(Integer passed_out_year) {
		this.passed_out_year = passed_out_year;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOther_qualifiction() {
		return other_qualifiction;
	}
	public void setOther_qualifiction(String other_qualifiction) {
		this.other_qualifiction = other_qualifiction;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		AlumniRegisterModel.serialVersionUID = serialVersionUID;
	}
	public String getUsername() {
		return username;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCollege_code() {
		return college_code;
	}
	public void setCollege_code(String college_code) {
		this.college_code = college_code;
	}
	public String getRoll_number() {
		return roll_number;
	}
	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(BigInteger mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBase64String() {
		return base64String;
	}
	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public List<AlumniRegisterModel> getUploadfiles() {
		return uploadfiles;
	}
	public void setUploadfiles(List<AlumniRegisterModel> uploadfiles) {
		this.uploadfiles = uploadfiles;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFilePaths() {
		return filePaths;
	}
	public void setFilePaths(String filePaths) {
		this.filePaths = filePaths;
	}
	public String[] getFilePathsArr() {
		return filePathsArr;
	}
	public void setFilePathsArr(String[] filePathsArr) {
		this.filePathsArr = filePathsArr;
	}
	public List<FileModel> getFiles() {
		return files;
	}
	public void setFiles(List<FileModel> files) {
		this.files = files;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setFile_Name(String file) {
		this.file=file;
		
	}
	public String getFile() {
		return file;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Integer getStd_id() {
		return std_id;
	}
	public void setStd_id(Integer std_id) {
		this.std_id = std_id;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getStatustype() {
		return statustype;
	}
	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}
		
	
	
	
		
}
	
	
	