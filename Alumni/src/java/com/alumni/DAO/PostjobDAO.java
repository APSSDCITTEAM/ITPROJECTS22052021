package com.alumni.DAO;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.andromeda.commons.model.Response;
//Local

import com.alumni.Model.PostjobModel;

@Repository
public class PostjobDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public void CreateJob(PostjobModel finance) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Post.AddJob", params);
		sqlSession.close();
	}
	
	public void CreateInternship(PostjobModel finance) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Post.AddInternship", params);
		sqlSession.close();
	}

}
