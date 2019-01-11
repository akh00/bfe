package org.ak.bfe.action;

import org.ak.bfe.item.Item;

public interface ActionItem {

	boolean condition();

	Item item();

	ActionResult result();

	
}
