package org.ak.bfe.exec;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.ak.bfe.action.Action;
import org.ak.bfe.action.ActionData;
import org.ak.bfe.action.ActionItem;
import org.ak.bfe.action.ActionResult;
import org.ak.bfe.item.Item;
import org.ak.bfe.item.ItemFactory;
import org.ak.bfe.statem.StateEnum;

public class Execution implements Notifiable {

	private Set<Item> items;
	private Set<ActionItem> inProgress;
	private Set<Action> actions;
	private Executor executor;
	private BlockingQueue<ActionItem> finishedActions = new LinkedBlockingQueue<>();
	private ItemFactory itemFactory;

	public Execution(Set<Item> items, Set<Action> actions, ItemFactory itemFactory)
	{
		this.actions = actions;
		this.items = items;
		this.itemFactory = itemFactory;
	}

	void run() throws InterruptedException
	{
		while (true) {
			for (Item item : items) {
				if (!item.isInTerminalState()) {
					StateEnum nextState = item.getNextState();
					for (Action action : actions) {
						if (action.targetState() == nextState) {
							ActionItem actItem = action.bind(item);
							if (actItem.condition())
								inProgress.add(executor.execute(actItem, this));
						}
					}
				}
			}
			if (inProgress.isEmpty())
				break;
			ActionItem finished = this.finishedActions.poll();
			inProgress.remove(applyActionResult(finished));
		}
	}

	private ActionItem applyActionResult(ActionItem finished)
	{
		ActionResult result = finished.result();
		finished.item().applyResult(result);
		addItems(result.data());
		return finished;
	}

	private void addItems(List<ActionData> data)
	{
		for (ActionData actionData : data) {
			if (actionData.isForNewItem()) {
				this.items.add(this.itemFactory.createItem(actionData));
			}
		}
	}

	@Override
	public void actionFinished(ActionItem item)
	{
		finishedActions.add(item);
	}

}
