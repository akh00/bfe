package org.ak.bfe.statem;

public class IncorrectTransitionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8698998991059756392L;

	public IncorrectTransitionException(String actionId)
	{
		super("Incvalid action:"+actionId);
	}

}
