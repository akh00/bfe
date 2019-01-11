package org.ak.bfe.statem;

public class Event {
	public String eventId;
	public String machineId;
	public Event(String eventId, String machineId)
	{
		super();
		this.eventId = eventId;
		this.machineId = machineId;
	}
}
