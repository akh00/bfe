package org.ak.bfe.action;

import org.ak.bfe.item.Item;
import org.ak.bfe.statem.StateEnum;

public interface Action {

	StateEnum targetState();

	ActionItem bind(Item item);


}
