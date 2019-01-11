package org.ak.bfe.test.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	private static ObjectMapper mapper = new ObjectMapper();
	public static Order readFromFile(String string) throws JsonParseException, JsonMappingException, IOException
	{
		return mapper.readValue(Utils.class.getResourceAsStream(string), Order.class);
	}

}
