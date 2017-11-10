package ua.nure.kn156.sukhomlinova.db;

import java.util.Collection;

import ua.nure.kn156.sukhomlinova.User;

public interface UserDAO {
	User create(User user) throws DatabaseException;

	User find(Long id) throws DatabaseException;

	void update(User user) throws DatabaseException;

	void delete(User user) throws DatabaseException;

	Collection<User> findAll() throws DatabaseException;

	void setConnectionFactory(ConnectionFactory connectionFactory);
}