package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alumni.Model.AdminEmployeeApprovalModel;
//import com.andromeda.commons.model.Response;
//Local


@Repository
public class AdminEmployeeApprovalDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	
	
	public List<AdminEmployeeApprovalModel> getallusers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminEmployeeApprovalModel> userdetails = sqlSession.selectList("AdminEmployeeApproval.getallusers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminEmployeeApprovalModel> getallVerifiedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminEmployeeApprovalModel> userdetails = sqlSession.selectList("AdminEmployeeApproval.getallVerifiedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminEmployeeApprovalModel> getallApprovedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminEmployeeApprovalModel> userdetails = sqlSession.selectList("AdminEmployeeApproval.getallApprovedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public List<AdminEmployeeApprovalModel> getallRejectedUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AdminEmployeeApprovalModel> userdetails = sqlSession.selectList("AdminEmployeeApproval.getallRejectedUsers");
		sqlSession.close();
		return userdetails;
	}
	
	public void ApproveUser(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminEmployeeApproval.ApproveUser", id);
		sqlSession.close();
	}
	
	public void RejectUser(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AdminEmployeeApproval.RejectUser", id);
		sqlSession.close();
	}
	
	

}
