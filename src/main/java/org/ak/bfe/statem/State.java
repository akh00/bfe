package org.ak.bfe.statem;

import java.util.Map;

public class State {
	private String stateId;
	private String machineId;
	private Event defaultEvent; //event to be sent automatically in this state 
	private Map<String, String> eventState;

	public State(String stateId, Map<String, String> actionStateMap, String machineId, Event defaultEvent)
	{
		super();
		this.stateId = stateId;
		this.eventState = actionStateMap;
		this.machineId = machineId;
		this.defaultEvent = defaultEvent;
	}

	public State(String stateId, Map<String, String> actionStateMap, String machineId)
	{
		super();
		this.stateId = stateId;
		this.eventState = actionStateMap;
		this.machineId = machineId;
	}

	public String transit(String eventId, Map<String, Object> env) throws IncorrectTransitionException
	{
		String stateId = eventState.get(eventId);
		return stateId == null ? this.stateId : stateId;
	}

	boolean isTerminal()
	{
		return eventState == null || eventState.isEmpty();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	public String getStateId()
	{
		return stateId;
	}

	public String getMachineId()
	{
		return machineId;
	}

	public Event getDefaultEvent()
	{
		return defaultEvent;
	}
}
