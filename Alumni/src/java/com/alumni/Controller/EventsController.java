package com.alumni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.andromeda.commons.model.Response;
import com.alumni.Service.EventsService;
// Local
import com.alumni.Model.EventsModel;

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
	public Response changeEventStatus(@RequestBody EventsModel event)
	{
		return eventsService.changeEventStatus(event);
	}
	
	
	
	

}
