package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alumni.Model.AdminApprovalModel;
//import com.andromeda.commons.model.Response;
//Local


@Repository
public class AdminApprovalDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	
	
	public List<AdminApprovalModel> getallusers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getallusers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminApprovalModel> getallVerifiedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getallVerifiedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminApprovalModel> getallApprovedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getallApprovedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminApprovalModel> getallRejectedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getallRejectedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public void ApproveUser(AdminApprovalModel faculty) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", faculty);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminApproval.ApproveUser", params);
		sqlSession.close();
	}
	
	public void RejectUser(AdminApprovalModel faculty) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", faculty);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminApproval.RejectUser", params);
		sqlSession.close();
	}
	
	
	/* .................................................. Job Approvals .................................. */
	/* Getting all jobs */
	public List<AdminApprovalModel> getallJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getallJobs");
		sqlSession.close();
		return userdetails;
	}
	
	/* Getting Submitted jobs */
	public List<AdminApprovalModel> getSubmittedJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getSubmittedJobs");
		sqlSession.close();
		return userdetails;
	}
	
	/* Getting Approved jobs */
	public List<AdminApprovalModel> getApprovedJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getApprovedJobs");
		sqlSession.close();
		return userdetails;
	}
	
	/* Getting Rejected jobs */
	public List<AdminApprovalModel> getRejectedJobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminApprovalModel> userdetails = sqlSession.selectList("AdminApproval.getRejectedJobs");
		sqlSession.close();
		return userdetails;
	}
	
	/* Approve Jobs */
	public void ApproveJob(AdminApprovalModel faculty) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", faculty);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminApproval.ApproveJob", params);
		sqlSession.close();
	}
	
	/* Reject Jobs */
	public void RejectJob(AdminApprovalModel faculty) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", faculty);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminApproval.RejectJob", params);
		sqlSession.close();
	}

}
