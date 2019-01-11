package org.ak.bfe.action;

public class ActionData {
	private String itemId; 
	private Object data;
	private String actionId;
	private Result result;
	private String type; //type of item to be created
	public ActionData(String itemId, Object data, String actionId, Result result) {
		super();
		this.itemId = itemId;
		this.data = data;
		this.actionId = actionId;
		this.result = result;
	}
	public ActionData(Object data, String actionId, String type, Result result) {
		this(null, data, actionId, result);
		this.type = type;
	}
	public String getItemId() {
		return itemId;
	}
	public Object getData() {
		return data;
	}
	public String getActionId() {
		return actionId;
	}
	public Result getResult() {
		return result;
	}
	public boolean isForNewItem() {
		return this.itemId == null;
	}
	public String getType()
	{
		return type;
	}
}
