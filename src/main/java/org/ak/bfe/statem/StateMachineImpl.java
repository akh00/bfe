package org.ak.bfe.statem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.ak.bfe.item.Item;

public class StateMachineImpl implements StateMachine{

	private Map<String, State> states;
	private State curState;
	private Map<String, Object>  extState = new HashMap<>();
	private StateMachine parent;
	private Set<StateMachine> childs = new HashSet<>();
	public StateMachineImpl(Set<State> states, String initialState, Item item)
	{
		super();
		this.states = states.stream().collect(Collectors.toMap(State::getStateId, st -> st));
		this.curState = this.states.get("initialState");
		this.extState.put("item", item);
	}

	@Override
	public State state()
	{
		return curState;
	}

	@Override
	public boolean isTerminal()
	{
		return curState.isTerminal();
	}

	@Override
	public State transition(String action, Map<String, Object> env) throws IncorrectTransitionException
	{
		String newState = this.states.get(this.curState.getStateId()).transit(action, env);
		this.curState = states.get(newState);
		return this.curState;
	}
	
	public void addChild(StateMachine machine)
	{
		childs.add(machine);
		machine.setParent(machine);
	}

	public StateMachine getParent()
	{
		return parent;
	}

	public void setParent(StateMachine parent)
	{
		this.parent = parent;
	}

}
