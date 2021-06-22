package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.ViewJobModel;

import software.amazon.ion.Decimal;

@Repository
public class ViewJobDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

public List<ViewJobModel> getalljobs(String std_id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getalljobs",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getmyjobs(String std_id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getmyjobs",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getallinternships(String std_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallinternships",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getmyinternships(String std_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getmyinternships",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getalljobshome() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getalljobshome");
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getallinternshipshome() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallinternshipshome");
		sqlSession.close();
		return userdetails;
	}
	
	/* .......................................... Job Action ....................................... */
	
	public List<ViewJobModel> getallOpenJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallOpenJobs");
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getallClosedJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallClosedJobs");
		sqlSession.close();
		return userdetails;
	}
	
	public void changeJobStatus(ViewJobModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("ViewJob.changeJobStatus",params);
		sqlSession.close();
	}
	
	/* .......................................... interns Action ....................................... */
	
	public List<ViewJobModel> getallOpenInterns() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallOpenInterns");
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getallClosedInterns() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallClosedInterns");
		sqlSession.close();
		return userdetails;
	}
	
	public void changeInternStatus(ViewJobModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("ViewJob.changeInternStatus",params);
		sqlSession.close();
	}
	
	/*
	 * public void Applyjob(AlumniRegisterModel alumniregisterModel) { Map<String,
	 * Object> params = new HashMap<String, Object>(); params.put("p",
	 * alumniregisterModel); SqlSession sqlSession =
	 * sqlSessionFactory.openSession(); sqlSession.insert("ViewJob.InsertApplyjob",
	 * params); sqlSession.close(); }
	 */
	
	public Integer checkJob(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);
		Integer userStatus = sqlSessionTemplate.selectOne("ViewJob.checkJob", map);
		
		System.out.println("88888888888888888888888888888");
		System.out.println(userStatus);
		System.out.println("999999999999999999999999999999");
		return userStatus;
	}

	public void InsertApplyjob(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);

		sqlSessionTemplate.insert("ViewJob.InsertApplyjob", map);
	}	
	
	/*
	 * public void ApplyInternship(AlumniRegisterModel alumniregisterModel) {
	 * Map<String, Object> params = new HashMap<String, Object>(); params.put("p",
	 * alumniregisterModel); SqlSession sqlSession =
	 * sqlSessionFactory.openSession();
	 * sqlSession.insert("ViewJob.InsertApplyinternship", params);
	 * sqlSession.close(); }
	 */
	
	public Integer checkInternship(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);
		Integer userStatus = sqlSessionTemplate.selectOne("ViewJob.checkInternship", map);
		
		System.out.println("88888888888888888888888888888");
		System.out.println(userStatus);
		System.out.println("999999999999999999999999999999");
		return userStatus;
	}
	
	public void InsertApplyInternship(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);

		sqlSessionTemplate.insert("ViewJob.InsertApplyInternship", map);
	}
	
	
	/* Internship Applicants */
	public Map<String, Object> InternshipApplicants(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("ViewJob.InternshipApplicants", id);
		Map<String, Object> map = new HashMap();
		map.put("appliedInterns", list);
		return map;
	}
	
	/* Job Applicants */
	public Map<String, Object> JobApplicants(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("ViewJob.JobApplicants", id);
		Map<String, Object> map = new HashMap();
		map.put("appliedJobs", list);
		return map;
	}
	
	/* .......................................... update job status based on end date .............................. */
	public void UpdateJobStatusbyDate(ViewJobModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("ViewJob.UpdateJobStatusbyDate",params);
		sqlSession.close();   
	}
	
	/* .......................................... update job status based on end date .............................. */
	public void UpdateInternStatusbyDate(ViewJobModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("ViewJob.UpdateInternStatusbyDate",params);
		sqlSession.close();
	}
	
	
	/*
	 * public void Applyvolunteer(AlumniRegisterModel alumniregisterModel) {
	 * Map<String, Object> params = new HashMap<String, Object>(); params.put("p",
	 * alumniregisterModel); SqlSession sqlSession =
	 * sqlSessionFactory.openSession();
	 * sqlSession.insert("ViewJob.InsertApplyvolunteership", params);
	 * sqlSession.close(); }
	 */
	public List<ViewJobModel> getallvolunteerships(String std_id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallvolunteerships",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getmyvolunteerships(String std_id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getmyvolunteerships",std_id);
		sqlSession.close();
		return userdetails;
	}

	public List<ViewJobModel> getallvolunteershipshome() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallvolunteershipshome");
		sqlSession.close();
		return userdetails;
	}
	public Map<String, Object> VolunteershipApplicants(Integer id) {
		List<Map<String, Object>> list = ((SqlSession) this.sqlSessionTemplate).selectList("ViewJob.VolunteershipApplicants", id);
		Map<String, Object> map = new HashMap();
		map.put("appliedInterns", list);
		return map;
	}


	public Integer checkVolunteer(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);
		Integer userStatus = sqlSessionTemplate.selectOne("ViewJob.checkVolunteer", map);
		
		System.out.println("88888888888888888888888888888");
		System.out.println(userStatus);
		System.out.println("999999999999999999999999999999");
		return userStatus;
	}
	
	public void InsertApplyvolunteer(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", alumniregisterModel);

		sqlSessionTemplate.insert("ViewJob.InsertApplyvolunteer", map);
	}
	
	
	


}
