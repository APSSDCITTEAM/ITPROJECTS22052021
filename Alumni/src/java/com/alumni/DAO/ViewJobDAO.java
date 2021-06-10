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
	
	public void Applyjob(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("ViewJob.InsertApplyjob", params);
		sqlSession.close();
	}
	
	
	
	public void ApplyInternship(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("ViewJob.InsertApplyinternship", params);
		sqlSession.close();
	}
	
	
	public Map<String, Object> InternshipApplicants(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("ViewJob.InternshipApplicants", id);
		Map<String, Object> map = new HashMap();
		map.put("appliedInterns", list);
		return map;
	}
	
	

}
