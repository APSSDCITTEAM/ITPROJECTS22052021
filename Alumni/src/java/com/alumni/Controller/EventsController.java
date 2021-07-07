package com.alumni.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;
import com.alumni.Service.EventsService;
import com.alumni.Model.AlumniRegisterModel;
// Local
import com.alumni.Model.EventsModel;
import com.alumni.Model.ViewJobModel;

@RestController
@RequestMapping("/event")

public class EventsController {
	
	Response response = new Response();
	
	@Autowired
//	Discussion Service
	private EventsService eventsService;
	
	
	@ResponseBody
	@RequestMapping(value = "CreateEvent", method = { RequestMethod.POST })
	public Response CreateEvent(@RequestBody EventsModel event)
	{
		return eventsService.CreateEvent(event);       
	}
		
	@ResponseBody
	@RequestMapping(value = "getallEvents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallEvents()
	{
		return eventsService.getallEvents();
	}
	
	
	/* ................................................ Getting Event View page Data ............................................... */
	@ResponseBody
	@RequestMapping(value = { "vieweventData" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Response vieweventData(@RequestBody Integer id) {

		return this.eventsService.vieweventData(id);
	}
	
	/* ...................................... getting pop up data ............................................. */
	@ResponseBody
	@RequestMapping(value = "getEventPopdata", method = { RequestMethod.POST })
	public Response getEventPopdata(@RequestBody Integer id)
	{
		return eventsService.getEventPopdata(id);
	}
	
	/* ....................................... Update event data .......................................... */
	@ResponseBody
	@RequestMapping(value = "UpdateEventData", method = { RequestMethod.POST })
	public Response UpdateEventData(@RequestBody EventsModel event)
	{
		return eventsService.UpdateEventData(event);
	}
	
	/* ....................................... delete event .............................................. */
	@ResponseBody
	@RequestMapping(value = "DeleteEvent", method = { RequestMethod.POST })
	public Response remove(@RequestBody Integer id)
	{
		return eventsService.remove(id);
	}
	
	/* ..................................... change event status ............................................ */
	@ResponseBody
	@RequestMapping(value = "getallOpenEvents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallOpenEvents()
	{
		return eventsService.getallOpenEvents();
	}
	
	@ResponseBody
	@RequestMapping(value = "getallClosedEvents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getallClosedEvents()
	{
		return eventsService.getallClosedEvents();
	}
	
	@ResponseBody
	@RequestMapping(value = "changeEventStatus", method = { RequestMethod.POST })
	public Response changeEventStatus(@RequestBody Integer id)
	{
		return eventsService.changeEventStatus(id);
	}
	
	/* change event status by end date */
	@ResponseBody
	@RequestMapping(value = "UpdateEventStatusbyDate", method = { RequestMethod.POST })
	public Response UpdateEventStatusbyDate(@RequestBody EventsModel event)
	{
		return eventsService.UpdateEventStatusbyDate(event);
	}
	
	/* apply event */
	@ResponseBody
	@RequestMapping(value = "/ApplyEvent", method = { RequestMethod.POST, RequestMethod.GET })
	public Response ApplyEvent(@RequestBody EventsModel event)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		return eventsService.ApplyEvent(event);
	}
	
	/* getting my event */
	@ResponseBody
	@RequestMapping(value = "getmyEvents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getmyEvents(@RequestBody String std_id)
	{
		return eventsService.getmyEvents(std_id);
	}
	
	/* getting my events except mine */
	@ResponseBody
	@RequestMapping(value = "getNotmyEvents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getNotmyEvents(@RequestBody String std_id)
	{
		return eventsService.getNotmyEvents(std_id);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "getSubmittedevents", method = { RequestMethod.POST, RequestMethod.GET })
	public Response getSubmittedevents()
	{
		return eventsService.getSubmittedevents();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "ApproveEvent", method = { RequestMethod.POST })
	public Response ApproveEvent(@RequestBody Integer id) {
		return eventsService.ApproveEvent(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "RejectEvent", method = { RequestMethod.POST })
	public Response RejectEvent(@RequestBody Integer id) {
		return eventsService.RejectEvent(id);
	}
	
	

}
