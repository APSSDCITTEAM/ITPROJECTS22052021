package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.andromeda.commons.model.Response;
//Local
import com.alumni.Model.DiscussionModel;
import com.alumni.Model.PostjobModel;
import com.alumni.Model.ViewJobModel;

@Repository
public class ViewJobDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public List<ViewJobModel> getalljobs(Integer std_id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getalljobs",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<ViewJobModel> getallinternships(Integer std_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ViewJobModel> userdetails = sqlSession.selectList("ViewJob.getallinternships",std_id);
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

}
