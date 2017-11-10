package ua.nure.kn156.sukhomlinova;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import ua.nure.kn156.sukhomlinova.User;

public class TestUser extends TestCase {
	private static final int YEAR_OF_BIRTH = 1998;
	private static final int BIRHDAY = 7;
	private static final int AGE = 19;
	private User user;
	private Date date;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, Calendar.MARCH, BIRHDAY);
		date = calendar.getTime();
		
	}
	
	public void testGetFullName() {
		user.setFirstName("Julia");
		user.setLastName("Sukhomlinova");
		assertEquals("Sukhomlinova, Julia", user.getFullName());
		user.setFirstName(null);
		try {
			user.getFullName();
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        	assertEquals(e.getMessage(), "FirstName or LastName is null");
        }
	}

	public void testGetAge() {
		user.setDate(date);
		assertEquals(AGE, user.getAge());
	}
}
