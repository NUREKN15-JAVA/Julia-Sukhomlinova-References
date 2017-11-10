package ua.nure.kn156.sukhomlinova.db;

import com.mockobjects.dynamic.Mock;

import ua.nure.kn156.sukhomlinova.db.DAOFactory;
import ua.nure.kn156.sukhomlinova.db.UserDAO;

public class MockDAOFactory extends DAOFactory {

	private Mock mockUserDAO;

	public MockDAOFactory() {
		mockUserDAO = new Mock(UserDAO.class);
	}

	public Mock getMockUserDAO() {
		return mockUserDAO;
	}

	@Override
	public UserDAO getUserDao() {
		return (UserDAO) mockUserDAO.proxy();
	}

}
