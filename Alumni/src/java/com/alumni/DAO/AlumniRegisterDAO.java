package com.alumni.DAO;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.Login;
import com.alumni.Model.PostjobModel;

@Repository
public class AlumniRegisterDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void Registeralumni(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Integer id = sqlSession.selectOne("AlumniRegister.getAlumniCount");
		params.put("id", id);
		if (alumniregisterModel.getType() == 0) {
			sqlSession.insert("AlumniRegister.InsertAlumniStudent", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserStudent", params);
		} else if (alumniregisterModel.getType() == 1) {
			sqlSession.insert("AlumniRegister.InsertAlumniEmployee", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserEmployee", params);
		}
		sqlSession.close();
	}

	/*
	 * public void RegisteralumniEmail(String token) { Map<String, Object> params =
	 * new HashMap<String, Object>(); params.put("p", token); SqlSession sqlSession
	 * = sqlSessionFactory.openSession();
	 * sqlSession.update("AlumniRegister.updateToken", token); sqlSession.close(); }
	 */

	public List<AlumniRegisterModel> getAllAlumnisData() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AlumniRegisterModel> userdetails = sqlSession.selectList("AlumniRegister.getAllAlumnisData");
		sqlSession.close();
		return userdetails;
	}

	/*
	 * ................................................. assign role
	 * ...................................
	 */
	public void CreateRole(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Integer id = sqlSession.selectOne("AlumniRegister.getAlumniCount");
		params.put("id", id);

		if (alumniregisterModel.getRole_id() == 1) {
			sqlSession.insert("AlumniRegister.InsertAlumniAdmin", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserAdmin", params);
		}
		if (alumniregisterModel.getRole_id() == 2) {
			sqlSession.insert("AlumniRegister.InsertAlumniMdCEO", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserMdCEO", params);
		}
		if (alumniregisterModel.getRole_id() == 3) {
			sqlSession.insert("AlumniRegister.InsertAlumniED", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserED", params);
		}
		if (alumniregisterModel.getRole_id() == 4) {
			sqlSession.insert("AlumniRegister.InsertAlumniCGM", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserCGM", params);
		}
		sqlSession.close();
	}

	public Integer verifyToken(Integer token) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Integer status = 0;
		status = sqlSession.update("AlumniRegister.verifyToken", token);

//		String email = sqlSession.selectOne("AlumniRegister.getEmail", token);
//		String password = sqlSession.selectOne("AlumniRegister.getPassword", token).toString();

		sqlSession.close();
		return status;
	}

	public String getUserEmail(Integer token) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String email = sqlSession.selectOne("AlumniRegister.getEmail", token);
		sqlSession.close();
		return email;
	}

	public String getUserPassword(Integer token) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String password = sqlSession.selectOne("AlumniRegister.getPassword", token);
		sqlSession.close();
		return password;
	}
	
	public String getUserEmailbyId(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String email = sqlSession.selectOne("AlumniRegister.getEmailbyId", id);
		sqlSession.close();
		return email;
	}

	public String getUserPasswordbyId(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String password = sqlSession.selectOne("AlumniRegister.getPasswordbyId", id);
		sqlSession.close();
		return password;
	}

	public void volunteershipRegister(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("AlumniRegister.AddvolunteershipRegister", params);
		sqlSession.close();
	}

	public Integer checkMail(AlumniRegisterModel login) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		Integer userStatus = sqlSessionTemplate.selectOne("AlumniRegister.checkMail", map);
		return userStatus;
	}

	public Integer checkMobile(AlumniRegisterModel login) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		Integer userStatus = sqlSessionTemplate.selectOne("AlumniRegister.checkMobile", map);
		System.out.println(userStatus);
		return userStatus;
	}

	public void AddRole(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("AlumniRegister.AddRole", params);
		sqlSession.close();
	}

	/* getting all roles */
	public List<AlumniRegisterModel> getallroles() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AlumniRegisterModel> userdetails = sqlSession.selectList("AlumniRegister.getallroles");
		sqlSession.close();
		return userdetails;
	}

	/* getting role data to popup */
	public AlumniRegisterModel getRoleData(Integer role_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AlumniRegisterModel singleuserdetails = sqlSession.selectOne("AlumniRegister.getRoleData", role_id);
		sqlSession.close();
		return singleuserdetails;
	}

	/* update role data */
	public void updateRole(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AlumniRegister.updateRole", params);
		sqlSession.close();
	}

	/* delete role data */
	public void remove(Integer role_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("AlumniRegister.DeleteRoleData", role_id);
		sqlSession.close();
	}

	public void sendOtp(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AlumniRegister.updateotp", params);
		sqlSession.close();		
	}
	
	public Integer verifyotp(AlumniRegisterModel login) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		Integer userStatus = sqlSessionTemplate.selectOne("AlumniRegister.verifyOtp", map);
		return userStatus;
	}
	
	/* update role data */
	public void updatePassword(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("AlumniRegister.updatePassword", params);
		sqlSession.close();
	}


}
