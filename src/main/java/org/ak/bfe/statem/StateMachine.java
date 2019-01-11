package org.ak.bfe.statem;

import java.util.Map;

public interface StateMachine {
	State state();
	boolean isTerminal();
	StateMachine getParent();
	void setParent(StateMachine parent);
	State transition(String event, Map<String, Object> env) throws IncorrectTransitionException;
}
