package org.ak.bfe.action;

import java.util.List;

public interface ActionResult {
	List<ActionData> data();
	Result state();
}
