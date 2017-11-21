package ua.nure.kn156.sukhomlinova.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ua.nure.kn156.sukhomlinova.User;


public class BrowseServletTest extends MockServletTestCase {

	protected void setUp() throws Exception {
		super.setUp();
		createServlet(BrowseServlet.class);
	}
	
	public void testBrowse(){
		User user = new User(new Long(1000), "John", "Cena", new Date());
		List<User> list=Collections.singletonList(user);
		getMockUserDao().expectAndReturn("findAll", list);
		doGet();
		Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
		assertNotNull("Could not find list of users", collection);
		assertSame(list, collection);
	}
	
	public void testEdit(){
		User user = new User(new Long(1000), "John", "Cena", new Date());
		addRequestParameter("editButton", "Edit");
		addRequestParameter("id", "1000");
		getMockUserDao().expectAndReturn("find", new Long(1000), user);
		doPost();
		User userInSession = (User) getWebMockObjectFactory().getMockSession().getAttribute("user");
		assertNotNull("Could not find user to edit", user);
		assertSame(user, userInSession);
		
	}
	

}
