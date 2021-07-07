package com.alumni.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alumni.Model.AdminApprovalModel;
import com.alumni.Model.AlumniRegisterModel;
import com.alumni.Model.EventsModel;
import com.alumni.Model.ViewJobModel;

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
	
	public void changeEventStatus(Integer id)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.changeEventStatus",id);
		sqlSession.close();
	}
	
	/* change event status by event by end date */
	public void UpdateEventStatusbyDate(EventsModel event)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", event);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.UpdateEventStatusbyDate",params);
		sqlSession.close();
	}
	
	/* apply events */
	public Integer checkEvent(EventsModel event) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", event);
		Integer userStatus = sqlSessionTemplate.selectOne("Event.checkEvent", map);
		
		System.out.println("88888888888888888888888888888");
		System.out.println(userStatus);
		System.out.println("999999999999999999999999999999");
		return userStatus;
	}
	
	public void InsertApplyEvent(EventsModel event) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", event);

		sqlSessionTemplate.insert("Event.InsertApplyEvent", map);
	}
	
	/* getting my Events */
	public List<EventsModel> getmyEvents(String std_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getmyEvents",std_id);
		sqlSession.close();
		return userdetails;
	}

	/* getting Events except mine */
	public List<EventsModel> getNotmyEvents(String std_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getNotmyEvents",std_id);
		sqlSession.close();
		return userdetails;
	}
	
	public List<EventsModel> getSubmittedevents() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EventsModel> userdetails = sqlSession.selectList("Event.getSubmittedevents");
		sqlSession.close();
		return userdetails;
	}
	
	public void ApproveEvent(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.ApproveEvent", id);
		sqlSession.close();
	}
	
	public void RejectEvent(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("p", id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("Event.RejectEvent", id);
		sqlSession.close();
	}
	
	
	

}
