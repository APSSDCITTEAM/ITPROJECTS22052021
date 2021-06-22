package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.IndexModel;
import com.alumni.Model.ReportsModel;
import com.alumni.Model.ViewJobModel;

import software.amazon.ion.Decimal;

@Repository
public class ReportsDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/*
	 * ................................ get employees count
	 * ...............................
	 */
	public ReportsModel getMembersCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getMembersCount");
		return report;
	}

	/*
	 * ................................ get approved employees count
	 * ...............................
	 */
	public ReportsModel getApprovedEmployeesCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getApprovedEmployeesCount");
		return report;
	}

	/*
	 * ................................ get rejected employees count
	 * ...............................
	 */
	public ReportsModel getRejectedEmployeesCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getRejectedEmployeesCount");
		return report;
	}

	/*
	 * ................................ get Verified employees count
	 * ...............................
	 */
	public ReportsModel getVerifiedEmployeesCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getVerifiedEmployeesCount");
		return report;
	}

	/*
	 * ................................ get Non-Verified employees count
	 * ...............................
	 */
	public ReportsModel getnonVerifiedEmployeesCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getnonVerifiedEmployeesCount");
		return report;
	}

	/* getting approved emp data */
	public Map<String, Object> getApprovedEmpData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getApprovedEmpData", status);
		Map<String, Object> map = new HashMap();
		map.put("approvedEmpData", list);
		return map;
	}

	/* getting rejected emp data */
	public Map<String, Object> getRejectedEmpData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getRejectedEmpData", status);
		Map<String, Object> map = new HashMap();
		map.put("RejectedEmpData", list);
		return map;
	}

	/* getting verified emp data */
	public Map<String, Object> getVerifiedEmpData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getVerifiedEmpData", status);
		Map<String, Object> map = new HashMap();
		map.put("VerifiedEmpData", list);
		return map;
	}

	/* getting not verified emp data */
	public Map<String, Object> getnotVerifiedEmpData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getnotVerifiedEmpData", status);
		Map<String, Object> map = new HashMap();
		map.put("notverifiedEmpData", list);
		return map;
	}

	/* getting approved emp jobs data */
	public Map<String, Object> getEmployeeJobsData(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getEmployeeJobsData", user_id);
		Map<String, Object> map = new HashMap();
		map.put("EmployeeJobData", list);
		return map;
	}

	/* getting approved emp interns data */
	public Map<String, Object> getEmployeeInternshipsData(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getEmployeeInternshipsData",
				user_id);
		Map<String, Object> map = new HashMap();
		map.put("EmployeeInternData", list);
		return map;
	}

	/*
	 * ................................ get students count
	 * ...............................
	 */
	public ReportsModel getStudentMembersCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getStudentMembersCount");
		return report;
	}

	/*
	 * ................................ get approved students count
	 * ...............................
	 */
	public ReportsModel getApprovedStudentsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getApprovedStudentsCount");
		return report;
	}

	/*
	 * ................................ get rejected Students count
	 * ...............................
	 */
	public ReportsModel getRejectedStudentsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getRejectedStudentsCount");
		return report;
	}

	/*
	 * ................................ get Verified students count
	 * ...............................
	 */
	public ReportsModel getVerifiedStudentsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getVerifiedStudentsCount");
		return report;
	}

	/*
	 * ................................ get Non-Verified students count
	 * ...............................
	 */
	public ReportsModel getnonVerifiedStudentsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getnonVerifiedStudentsCount");
		return report;
	}

	/*
	 * ................................ get Non-Verified students count
	 * ...............................
	 */
	public JSONObject getallStudentsCount() throws JSONException {
		
		Integer a1 = sqlSessionTemplate.selectOne("Report.getStudentMembersCount");
		Integer a2 = sqlSessionTemplate.selectOne("Report.getApprovedStudentsCount");
		Integer a3 = sqlSessionTemplate.selectOne("Report.getRejectedStudentsCount");
		Integer a4 = sqlSessionTemplate.selectOne("Report.getVerifiedStudentsCount");
		Integer a5 = sqlSessionTemplate.selectOne("Report.getnonVerifiedStudentsCount");
		
		JSONObject obj = new JSONObject();
		obj.put("a1", a1);
		obj.put("a2", a2);
		obj.put("a3", a3);
		obj.put("a4", a4);
		obj.put("a5", a5);
		System.out.print(obj);
		return obj;
	}

	/* getting approved std data */
	public Map<String, Object> getApprovedStdData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getApprovedStdData", status);
		Map<String, Object> map = new HashMap();
		map.put("approvedStdData", list);
		return map;
	}

	/* getting rejected std data */
	public Map<String, Object> getRejectedStdData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getRejectedStdData", status);
		Map<String, Object> map = new HashMap();
		map.put("rejectedStdData", list);
		return map;
	}

	/* getting verified std data */
	public Map<String, Object> getVerifiedStdData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getVerifiedStdData", status);
		Map<String, Object> map = new HashMap();
		map.put("verifiedStdData", list);
		return map;
	}

	/* getting not verified std data */
	public Map<String, Object> getnotVerifiedStdData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getnotVerifiedStdData", status);
		Map<String, Object> map = new HashMap();
		map.put("notVerifiedStdData", list);
		return map;
	}

	/* getting approved emp jobs data */
	public Map<String, Object> getStudentsJobsData(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getStudentsJobsData", user_id);
		Map<String, Object> map = new HashMap();
		map.put("StudentJobData", list);
		return map;
	}

	/* getting approved emp interns data */
	public Map<String, Object> getStudentsInternshipsData(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getStudentsInternshipsData",
				user_id);
		Map<String, Object> map = new HashMap();
		map.put("StudentInternData", list);
		return map;
	}

	public ReportsModel getEmployeeDetails(String user_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReportsModel singleuserdetails = sqlSession.selectOne("Report.getEmployeeDetails", user_id);
		sqlSession.close();
		return singleuserdetails;

	}

	/* getting approved emp jobs data */
	public Map<String, Object> getEmployeeappliedJobs(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getEmployeeappliedJobs", user_id);
		Map<String, Object> map = new HashMap();
		map.put("EmployeeJobsApplied", list);
		return map;
	}

	/* getting approved emp interns data */
	public Map<String, Object> getEmployeeappliedInternships(String user_id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getEmployeeappliedInternships",
				user_id);
		Map<String, Object> map = new HashMap();
		map.put("EmployeeInternApplied", list);
		return map;
	}

	/*
	 * ................................................. Events Reports
	 * .........................................
	 */
	public ReportsModel getEventsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getEventsCount");
		return report;
	}

	public ReportsModel getOpenEventsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getOpenEventsCount");
		return report;
	}

	public ReportsModel getClosedEventsCount() {
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getClosedEventsCount");
		return report;
	}

	public Map<String, Object> getOpenEventsData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getOpenEventsData", status);
		Map<String, Object> map = new HashMap();
		map.put("openEventsData", list);
		return map;
	}

	public Map<String, Object> getClosedEventsData(Integer status) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getClosedEventsData", status);
		Map<String, Object> map = new HashMap();
		map.put("closedEventData", list);
		return map;
	}
	
	/* ................................................. Job Reports ............................ */
	public ReportsModel getJobCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getJobCount");
	    return report;
	}

	public ReportsModel getApprovedJobCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getApprovedJobCount");
	    return report;
	}
	
	public ReportsModel getRejectedJobsCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getRejectedJobsCount");
	    return report;
	}

	public ReportsModel getClosedJobCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getClosedJobCount");
	    return report;
	}
	
	public ReportsModel getPendingJobCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getPendingJobCount");
	    return report;
	}
	
	
	/* ......................................... internship reports ......................................... */
	public ReportsModel getInternshipCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getInternshipCount");
	    return report;
	}

	public ReportsModel getApprovedInternshipCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getApprovedInternshipCount");
	    return report;
	}    
	
	public ReportsModel getRejectedInternshipsCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getRejectedInternshipsCount");
	    return report;
	}

	public ReportsModel getClosedInternshipCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getClosedInternshipCount");
	    return report;
	}
	
	public ReportsModel getPendingInternshipCount()
	{
		ReportsModel report = sqlSessionTemplate.selectOne("Report.getPendingInternshipCount");
	    return report;
	}
	
	public Map<String, Object> getJobsData(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getJobsData", id);
		Map<String, Object> map = new HashMap();
		map.put("JobData", list);
		return map;
	}

	public Map<String, Object> getInternsData(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getInternsData", id);
		Map<String, Object> map = new HashMap();
		map.put("InternData", list);
		return map;
	}
	
	/* getting event applicants */
	public Map<String, Object> getEventApplicants(Integer id) {
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Report.getEventApplicants", id);
		Map<String, Object> map = new HashMap();
		map.put("EventappliedData", list);
		return map;
	}
	

}
