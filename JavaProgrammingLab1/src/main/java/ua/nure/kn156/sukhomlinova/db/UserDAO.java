package ua.nure.kn156.sukhomlinova.db;

import java.util.Collection;

import ua.nure.kn156.sukhomlinova.entity.User;
import ua.nure.kn156.sukhomlinova.exception.DatabaseException;

public interface UserDAO {
	/**
	 * Saves information about new user into database
	 */
	User create(User user) throws DatabaseException;
	
	/**
	 *Finds user in database 
	 * @param id of user
	 * @return object representation of user's information from db
	 * @throws DatabaseException if any error occured
	 */
	User find(Long id) throws DatabaseException;
	
	
	/**
	 * Updates user's info
	 * @param user to be updated
	 * @throws DatabaseException if any error occured
	 */
	void update(User user) throws DatabaseException;

	
	/**
	 * Deletes user from db
	 * @param user to be deleted
	 * @throws DatabaseException if any error occured
	 */
	void delete(User user) throws DatabaseException;
	

	/**
	 * 
	 * @return info about all users
	 * @throws DatabaseException if any error occured
	 */
	Collection<User> findAll() throws DatabaseException;
	
	/**
	 * Sets factory for concret db
	 * @param connectionFactory
	 */

	void setConnectionFactory(ConnectionFactory connectionFactory);
}
