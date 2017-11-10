package ua.nure.kn156.sukhomlinova.db;

import junit.framework.TestCase;
import ua.nure.kn156.sukhomlinova.db.DAOFactory;
import ua.nure.kn156.sukhomlinova.db.UserDAO;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
		DAOFactory daoFactory = DAOFactory.getInstance();
		assertNotNull("DaoFactory instance is null", daoFactory);
		try {
			UserDAO userDao = daoFactory.getUserDao();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}

	}
}
