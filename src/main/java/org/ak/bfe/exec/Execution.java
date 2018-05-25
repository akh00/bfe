package org.ak.bfe.exec;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.ak.bfe.action.Action;
import org.ak.bfe.action.ActionItem;
import org.ak.bfe.item.Item;
import org.ak.bfe.item.State;

public class Execution implements Notifiable{
	
	private Set<Item> items;
	private Set<ActionItem> inProgress;
	private Set<Action> actions;
	private Action startAction;
	private Executor executor;
	private BlockingQueue<ActionItem> finishedActions = new LinkedBlockingQueue<>();
	private long timeout = 10;
	
	public Execution(Set<Item> items, Set<Action> actions, Action startAction){
		this.actions = actions;
		this.items = items;
		this.startAction = startAction;
	}
	
	void run() throws InterruptedException{
		while(true){
			for (Item item : items) {
				if(item.isInTerminalState())
				{
					State nextState = item.getNextState();
					for (Action action : actions) {
						if(action.targetState() == nextState){
							ActionItem actItem =  action.bind(item);
							if(actItem.condition())	{
								inProgress.add(actItem);
								executor.execute(actItem, this);
							}
						}
					}
				}
			}
			ActionItem finished = this.finishedActions.poll(timeout , TimeUnit.SECONDS);
			Item item = finished.item();
			State newTargetState = item.newTargetState(finished.result());
			Item parent = item.parent();
			if(parent != null)
			{
				parent.newTargetState(item);
			}
			Collection<Item> items = finished.resultItems();
			items.addAll(items);
		}
	}

	@Override
	public void actionFinished(ActionItem item) {
		
		finishedActions.add(item);
	}
	

}
