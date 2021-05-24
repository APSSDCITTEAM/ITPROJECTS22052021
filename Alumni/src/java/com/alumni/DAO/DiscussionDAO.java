package com.alumni.DAO;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.andromeda.commons.model.Response;
//Local
import com.alumni.Model.DiscussionModel;

@Repository
public class DiscussionDAO {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public int postDiscussion(DiscussionModel discussionModel) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", discussionModel);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("AlumniDiscussion.postDiscussion", params);
		sqlSession.close();
		return result;
	}

}
