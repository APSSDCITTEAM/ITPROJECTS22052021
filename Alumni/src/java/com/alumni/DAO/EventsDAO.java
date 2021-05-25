package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumni.Model.EventsModel;

import software.amazon.ion.Decimal;

@Repository
public class EventsDAO extends BaseDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public void CreateEvent(EventsModel finance) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("Event.CreateEvent", params);
		sqlSession.close();
	}
	
	public List<EventsModel> getallEvents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getallEvents");
		sqlSession.close();
		return userdetails;
	}
	
	/* .................................................... Event page View Data ........................................... */
	public EventsModel vieweventData(Integer id) {
		EventsModel list = this.sqlSessionTemplate.selectOne("Event.vieweventData", id);
		return list;
	}
	
	/* .......................................... get pop event view data ......................................... */
	public EventsModel getEventPopdata(Integer id)  
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EventsModel singleuserdetails=sqlSession.selectOne("Event.getEventPopdata",id);
		sqlSession.close();
		return singleuserdetails;
		
	}
	
	/* ............................................... update event data ........................................ */
	public void UpdateEventData(EventsModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.UpdateEventData",params);
		sqlSession.close();
	}
	
	/* ......................................delete event .......................................... */
	public void remove(Integer id)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("Event.DeleteEvent",id);
		sqlSession.close();
	}
	
	/* ........................................... change event status ....................................... */
	public List<EventsModel> getallOpenEvents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getallOpenEvents");
		sqlSession.close();
		return userdetails;
	}
	
	public List<EventsModel> getallClosedEvents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getallClosedEvents");
		sqlSession.close();
		return userdetails;
	}
	
	public void changeEventStatus(EventsModel finance)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", finance);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.changeEventStatus",params);
		sqlSession.close();
	}
	

}
