package org.ak.bfe.item;

public interface Item {

	boolean isInTerminalState();

	State getNextState();

	State newTargetState(Object result);

	Item parent();

}
