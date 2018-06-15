package org.ak.bfe.statem;

import java.util.List;
import java.util.Map;

public class State {
	private String stateId;
	private Map<String, List<Transition>> actionStateMap;
	
	public State(String stateId, Map<String, List<Transition>> actionStateMap)
	{
		super();
		this.stateId = stateId;
		this.actionStateMap = actionStateMap;
	}

	public String transit(String actionId, Map<String, Object> env) throws IncorrectTransitionException{
		List<Transition> transitions = actionStateMap.get(actionId);
		if (transitions == null)
			throw new IncorrectTransitionException(actionId);
		for (Transition tran : transitions) {
			if(tran.condition(env))
			{
				return tran.stateId();
			}
		}
		return this.stateId;
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
}
