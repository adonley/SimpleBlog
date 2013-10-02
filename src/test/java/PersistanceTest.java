import static org.junit.Assert.*;

import org.junit.Test;

import com.KeepinItSimpleApps.Persistence;

public class PersistanceTest {

	@Test
	public void test() {
		try {
			Persistence db = new Persistence();
			db.getConnection();
			db.closeConnection();
		} catch (Exception E) {
			E.printStackTrace();
			fail("BAD DB CONNECTION");
		}
	}

}
