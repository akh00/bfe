package org.ak.bfe.statem;

import java.util.Map;

public interface Transition {

	boolean condition(Map<String, Object> env);

	String stateId();

}
