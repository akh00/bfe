package org.ak.bfe.exec;

import org.ak.bfe.action.ActionItem;

public interface Executor {

	ActionItem execute(ActionItem actItem, Notifiable execution);

}
