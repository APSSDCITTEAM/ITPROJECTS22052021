package com.alumni.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andromeda.commons.model.Response;
import com.alumni.DAO.EventsDAO;
import com.alumni.Model.AdminApprovalModel;
import com.alumni.Model.AlumniRegisterModel;
//Local
import com.alumni.Model.EventsModel;
import com.alumni.Model.ViewJobModel;

@Service
public class EventsService {
	
	Response response = new Response();
	
	@Autowired
//Discussion DAO
	private EventsDAO eventsDAO;

	
	public Response CreateEvent(EventsModel finance) {		
		response.setSuccessful(false);
		eventsDAO.CreateEvent(finance);
		response.setSuccessful(true);
		System.out.println("hi1");
		response.setResponseObject(finance);
		return response;
	}
	
	public Response getallEvents() {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getallEvents();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	/* ......................................... Event View page Data ........................................... */
	public Response vieweventData(Integer id) {
		this.response.setSuccessful(false);
		EventsModel singleuserdetails = this.eventsDAO.vieweventData(id);
		this.response.setSuccessful(true);
		this.response.setResponseObject(singleuserdetails);
		return this.response;
	}
	
	/* ................................ get pop up event data.................................... */
	public Response getEventPopdata(Integer id)
	{
		response.setSuccessful(false);
		EventsModel singleuserdetails = eventsDAO.getEventPopdata(id);
		response.setSuccessful(true);
		response.setResponseObject(singleuserdetails);
		return response;
	}
	
	/* ......................................... update event data ........................................... */
	public Response UpdateEventData(EventsModel finance)
	{
		response.setSuccessful(false);
		eventsDAO.UpdateEventData(finance);
		response.setSuccessful(true);
		response.setResponseObject(finance);
		return response;
	}
	
	/*..................................................... delete event ........................................ */
	public Response remove(Integer id)
	{
		response.setSuccessful(false);
		eventsDAO.remove(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	/* ............................................ Change event Status............................................ */
	public Response getallOpenEvents() {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getallOpenEvents();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getallClosedEvents() {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getallClosedEvents();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response changeEventStatus(Integer id)
	{
		response.setSuccessful(false);
		eventsDAO.changeEventStatus(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	/* Change event status by end date */
	public Response UpdateEventStatusbyDate(EventsModel event)
	{
		response.setSuccessful(false);
		eventsDAO.UpdateEventStatusbyDate(event);
		response.setSuccessful(true);
		response.setResponseObject(event);
		return response;
	}
	
	/* apply event */
	public Response ApplyEvent(EventsModel event) {
		response.setSuccessful(false);
		Integer eventStatus = eventsDAO.checkEvent(event);

		if (eventStatus == 0) {
			eventsDAO.InsertApplyEvent(event);
			response.setSuccessful(false);
			response.setResponseObject(event);
		} else if (eventStatus == 1) {
			response.setSuccessful(true);
		}
		return response;
	}
	
	/* getting my events */
	public Response getmyEvents(String std_id) {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getmyEvents(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}

	/* getting events except mine */
	public Response getNotmyEvents(String std_id) {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getNotmyEvents(std_id);
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response getSubmittedevents() {
		response.setSuccessful(false);
		List<EventsModel> userdetails = eventsDAO.getSubmittedevents();
		response.setSuccessful(true);
		response.setResponseObject(userdetails);
		return response;
	}
	
	public Response ApproveEvent(Integer id) {
		response.setSuccessful(false);
		eventsDAO.ApproveEvent(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	public Response RejectEvent(Integer id) {
		response.setSuccessful(false);
		eventsDAO.RejectEvent(id);
		response.setSuccessful(true);
		response.setResponseObject(id);
		return response;
	}
	
	
	
	
	
	
}
