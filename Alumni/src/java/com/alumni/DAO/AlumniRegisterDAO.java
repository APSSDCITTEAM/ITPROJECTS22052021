package com.alumni.DAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;           
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alumni.Model.AlumniRegisterModel;


@Repository
public class AlumniRegisterDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void Registeralumni(AlumniRegisterModel alumniregisterModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", alumniregisterModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Integer id  =sqlSession.selectOne("AlumniRegister.getAlumniCount");
		params.put("id",id);
		
		if (alumniregisterModel.getType() == 0) {
			sqlSession.insert("AlumniRegister.InsertAlumniStudent", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserStudent", params);
		}
		if (alumniregisterModel.getType() == 1) {
			sqlSession.insert("AlumniRegister.InsertAlumniEmployee", params);
			sqlSession.insert("AlumniRegister.InsertAlumniUserEmployee", params);
		}
		sqlSession.close();
	}
	
	public List<AlumniRegisterModel> getAllAlumnisData() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AlumniRegisterModel> userdetails=sqlSession.selectList("AlumniRegister.getAllAlumnisData");
		sqlSession.close();
		return userdetails;
	}

			
}
