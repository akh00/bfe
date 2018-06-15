package org.ak.bfe.statem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.ak.bfe.action.Result;
import org.ak.bfe.item.Item;

public class StateMachineImpl implements StateMachine{

	private Map<String, State> states;
	private String curState;
	private Map<String, Object>  extState = new HashMap<>();
	public StateMachineImpl(Set<State> states, String initialState, Item item)
	{
		super();
		this.states = states.stream().collect(Collectors.toMap(State::getStateId, st -> st));
		this.curState = initialState;
		this.extState.put("item", item);
	}

	@Override
	public String state()
	{
		return curState;
	}

	@Override
	public boolean isTerminal()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String transition(String action, Map<String, Object> env) throws IncorrectTransitionException
	{
		this.curState = this.states.get(this.curState).transit(action, env);
		return this.curState;
	}

	@Override
	public StateMachine parent()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
