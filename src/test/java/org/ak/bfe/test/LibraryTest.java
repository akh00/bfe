package org.ak.bfe.test;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import static org.junit.Assert.*;

import java.io.IOException;

import org.ak.bfe.test.util.Order;
import org.ak.bfe.test.util.Utils;
public class LibraryTest {
	@Test
	public void testSomeLibraryMethod() throws JsonParseException, JsonMappingException, IOException
	{
		Order  order = Utils.readFromFile("/org.ak.bfe.test/order.json");
	}
}
