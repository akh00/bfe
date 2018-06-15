package org.ak.bfe.statem;

import java.util.Map;

public interface StateMachine {
	String state();
	boolean isTerminal();
	StateMachine parent();
	String transition(String action, Map<String, Object> env) throws IncorrectTransitionException;
}
