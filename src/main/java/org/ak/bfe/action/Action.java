package org.ak.bfe.action;

import org.ak.bfe.item.Item;
import org.ak.bfe.item.State;

public interface Action {

	State targetState();

	ActionItem bind(Item item);


}
