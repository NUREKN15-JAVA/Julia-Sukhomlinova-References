package ua.nure.kn156.sukhomlinova.web;

import java.io.FileInputStream;
import java.util.Properties;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;

import ua.nure.kn156.sukhomlinova.db.DAOFactory;
import ua.nure.kn156.sukhomlinova.db.DaoFactoryTest;
import ua.nure.kn156.sukhomlinova.db.MockDAOFactory;



public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {
	private Mock mockUserDao;

	public Mock getMockUserDao() {
		return mockUserDao;
	}

	public void setMockUserDao(Mock mockUserDao) {
		this.mockUserDao = mockUserDao;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();
		//properties.load(new FileInputStream("settings.properties"));
		properties.setProperty("dao.factory", MockDAOFactory.class.getName());
		DAOFactory.init(properties);
		setMockUserDao(((MockDAOFactory) DAOFactory.getInstance()).getMockUserDAO());
		
	}

	@Override
	protected void tearDown() throws Exception {
		getMockUserDao().verify();
		
		super.tearDown();
	}
	

}
