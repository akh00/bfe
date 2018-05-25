package org.ak.bfe.exec;

import org.ak.bfe.action.ActionItem;

public interface Executor {

	void execute(ActionItem actItem, Notifiable execution);

}
