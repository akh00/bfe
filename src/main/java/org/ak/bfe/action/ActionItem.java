package org.ak.bfe.action;

import java.util.Collection;

import org.ak.bfe.item.Item;

public interface ActionItem {

	boolean condition();

	Collection<Item> resultItems();

	Item item();

	Object result();

}
