package com.alumni.DAO;

import com.alumni.Model.Login;
import java.util.List;
import java.util.HashMap;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.commons.util.CryptoUtils;

@Repository
public class LoginDAO extends BaseDAO {

	public Integer checkUser(Login login) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);
		Integer userStatus = sqlSessionTemplate.selectOne("Login.checkUser", map);
		return userStatus;
	}

	public void saveToLogins(Login login) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		sqlSessionTemplate.insert("Login.saveLogins", map);
	}

	public Login getUserDetails(Login login) {
		/* System.out.println(login); */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", login.getUsername());
		map.put("password", login.getPassword());
		int roleid = sqlSessionTemplate.selectOne("Login.getRole", map);
		Login details = sqlSessionTemplate.selectOne("Login.getUserDetails", map);
		details.setRoleid(roleid);
		return details;

	}

	public Integer isUserLoggedIn(Login login) {
		Integer loginStatus = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", login);

		loginStatus = sqlSessionTemplate.selectOne("Login.isUserLoggedIn", map);
		System.out.println("||============DAO=============||");
		System.out.println(loginStatus);
		System.out.println("||============DAO=============||");
		return loginStatus;
	}

	public void deleteLoginLog(String user_id) {
		sqlSessionTemplate.update("Login.deleteLoginLog", user_id);
	}

	public Login createLogin(Login login) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("p", login);
		sqlSessionTemplate.insert("Login.saveData", map);
		Login clgDetails = sqlSessionTemplate.selectOne("Login.getCollegeDetails", map);
		login.setUsername(clgDetails.getUsername());
		login.setPwd(clgDetails.getPassword());
		login.setPassword(clgDetails.getPassword());
		login.setUser_id(clgDetails.getUser_id());
		login.setFirst_name(clgDetails.getFirst_name());
		login.setPassword(CryptoUtils.getMD5Hash(clgDetails.getPassword()));
		map.put("p", login);
		sqlSessionTemplate.update("Login.saveLogins", map);

		map.put("p", login);
		Integer spocRoleStatus = sqlSessionTemplate.selectOne("Login.getStatus", map);
		if (spocRoleStatus == 1) {
			sqlSession.update("Login.assignRole", map);
		} else {
			login.setUserStatus("User already exists ");
		}
		return login;
	}

	/*
	 * ...................................................... employee login
	 * ........................................
	 */
	public boolean saveLoginDetails(Login login) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Login dbLogin = sqlSession.selectOne("Login.getLogin", login);

		if (dbLogin == null) {
			sqlSession.insert("Login.saveLoginDetails", login);
			return true;
		} else {
			return false;
		}
	}

	public Login getLoginDetails(Login login) {
		Login list = this.sqlSessionTemplate.selectOne("Login.getLoginDetails", login);
		System.out.println("=====================" + list + "===============q");
		return list;
	}

	public boolean saveLogoutDetails(Login login) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Login dbLogin = sqlSession.selectOne("Login.getLogin", login);
		System.out.println(dbLogin);
		if (dbLogin != null && (dbLogin.getLogout_time() == null || ((String) dbLogin.getLogout_time()).isEmpty())) {
			sqlSession.update("Login.saveLogoutDetails", login);
			return true;
		}
		return false;
	}

	public List<Map<String, Object>> GetLoginData(Login login) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", login);
		List<Map<String, Object>> list = this.sqlSessionTemplate.selectList("Login.GetLoginData", params);
		return list;
	}

	public List<Login> gettodayLogins() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Login> userdetails = sqlSession.selectList("Login.gettodayLogins");
		sqlSession.close();
		return userdetails;
	}

	public void ChangePassword(Login login) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", login);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Login.ChangePassword", params);
		sqlSession.close();
	}

}