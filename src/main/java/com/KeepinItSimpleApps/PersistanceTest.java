package com.KeepinItSimpleApps;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersistanceTest {

	@Test
	public void test() {
		try {
			Persistance db = new Persistance();
			db.getConnection();
			db.closeConnection();
			System.out.print("WAS ABLE TO CONNECT?\n");
		} catch (Exception E) {
			E.printStackTrace();
			fail("Connection Call sucks");
		}
	}

}
