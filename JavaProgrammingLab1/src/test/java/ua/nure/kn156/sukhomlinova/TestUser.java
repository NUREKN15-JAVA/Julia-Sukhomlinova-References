package ua.nure.kn156.sukhomlinova;


import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import ua.nure.kn156.sukhomlinova.User;

public class TestUser extends TestCase {
	private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "First and last name shouldn't be empty";
	/**
	 * Excpected age for my birthday.
	 * Should be updated if any changes(birthday) in setUp() method are made.
	 */
	private static final int AGE = 19;
	private User user;
	private Date date;
	private final Long id=1L;

	@Override
	protected void setUp() throws Exception {
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, Calendar.APRIL, 7);
		date = calendar.getTime();
	}

	public void testGetFullName() {
		user.setFirstName("Julia");
		user.setLastName("Sukhomlinova");
		assertEquals("Sukhomlinova Julia", user.getFullName());
	}

	public void testGetAse() {
		user.setDate(date);
		assertEquals(AGE, user.getAge());
	}
	
	public void testGetId(){
		user.setId(id);
		assertEquals(id, user.getId());
	}
	
	public void testGetFullNameExc(){
		try{
			user.getFullName();
		}catch(IllegalArgumentException e){
			assertEquals(EMPTY_NAME_EXCEPTION_MESSAGE, e.getMessage());
		}
	}
}
