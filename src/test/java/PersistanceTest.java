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
		} catch (Exception E) {
			E.printStackTrace();
			fail("Fucked DB");
		}
	}

}
