package org.ak.bfe.item;

import org.ak.bfe.action.ActionResult;
import org.ak.bfe.statem.StateEnum;

public interface Item {

	boolean isInTerminalState();

	StateEnum getNextState();

	Item parent();

	void applyResult(ActionResult result);

}
