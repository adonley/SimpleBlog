package com.KeepinItSimpleApps;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersistanceTest {

	@Test
	public void test() {
		try {
			Persistence db = new Persistence();
			db.getConnection();
			db.closeConnection();
			System.out.print("WAS ABLE TO CONNECT?\n");
		} catch (Exception E) {
			E.printStackTrace();
			fail("Connection Call sucks");
		}
	}

}
