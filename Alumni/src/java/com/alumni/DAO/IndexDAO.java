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
import com.alumni.Model.IndexModel;
import com.alumni.Model.ViewJobModel;

import software.amazon.ion.Decimal;

@Repository
public class IndexDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;


	
	public List<IndexModel> getallRecentjobs() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<IndexModel> userdetails = sqlSession.selectList("Index.getallRecentjobs");
		sqlSession.close();
		return userdetails;
	}
	
	/* ................................ get members count ............................... */
	public IndexModel getMembersCount()
	{
		IndexModel index = sqlSessionTemplate.selectOne("Index.getMembersCount");
	    return index;
	}
	
	/* ................................ get members count ............................... */
	public IndexModel getJobsCount()
	{
		IndexModel index = sqlSessionTemplate.selectOne("Index.getJobsCount");
	    return index;
	}
	
	/* ................................ get interns count ............................... */
	public IndexModel getInternsCount()
	{
		IndexModel index = sqlSessionTemplate.selectOne("Index.getInternsCount");
	    return index;
	}
	
	/* ................................ get events count ............................... */
	public IndexModel getEventsCount()
	{
		IndexModel index = sqlSessionTemplate.selectOne("Index.getEventsCount");
	    return index;
	}
	

}
