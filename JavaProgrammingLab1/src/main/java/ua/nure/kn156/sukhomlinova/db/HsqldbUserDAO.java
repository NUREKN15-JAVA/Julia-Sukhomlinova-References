package ua.nure.kn156.sukhomlinova.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import ua.nure.kn156.sukhomlinova.entity.User;
import ua.nure.kn156.sukhomlinova.exception.DatabaseException;
/**
 * Class that provides access to User entity of HSQLDB 
 * @author Julia Sukhomlinova
 *
 */
class HsqldbUserDAO implements UserDAO {

	private static final String DATEOFBIRTH = "dateofbirth";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String ID = "id";
	private static final String SQL_CREATE_USER = "INSERT INTO users (firstname, lastname, dateofbirth) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE_USER = "UPDATE users SET firstname=?, lastname=?, dateofbirth=? WHERE id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
	private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";
	private static final String SQL_GET_ALL_USERS = "SELECT * FROM users";

	private ConnectionFactory connectionFactory;

	public HsqldbUserDAO() {

	}

	public HsqldbUserDAO(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	private void close(Connection e) {
		try {
			if (e != null) {
				e.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void close(Statement e) {
		try {
			if (e != null) {
				e.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void close(ResultSet e) {
		try {
			if (e != null) {
				e.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public User create(User user) throws DatabaseException {
		try (Connection connection = connectionFactory.createConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_CREATE_USER);
				CallableStatement callableStatement = connection.prepareCall("call IDENTITY()");
				ResultSet keys = callableStatement.executeQuery();) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setDate(3, new java.sql.Date(user.getDate().getTime()));
			int n = statement.executeUpdate();
			if (n != 1) {
				throw new DatabaseException("Error while creating user.");
			}
			User insertedUser = new User(user);
			if (keys.next()) {
				insertedUser.setId(keys.getLong(1));
			}
			return insertedUser;
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	@Override
	public User find(Long id) throws DatabaseException {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionFactory.createConnection();
			preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_ID);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getLong(ID));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setDate(resultSet.getDate(DATEOFBIRTH));
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		} finally {
			close(resultSet);
			close(preparedStatement);
			close(connection);
		}
		return user;
	}

	@Override
	public void update(User user) throws DatabaseException {
		try (Connection connection = connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDate().getTime()));
			preparedStatement.setLong(4, user.getId());
			int n = preparedStatement.executeUpdate();
			if (n <= 0) {
				throw new DatabaseException("Number of updated rows: " + n);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	@Override
	public void delete(User user) throws DatabaseException {
		try (Connection connection = connectionFactory.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);) {
			preparedStatement.setLong(1, user.getId());
			int n = preparedStatement.executeUpdate();
			if (n != 1) {
				throw new DatabaseException("Number of deleted rows: " + n);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	@Override
	public Collection<User> findAll() throws DatabaseException {
		Collection<User> result = new ArrayList<>();
		try (Connection connection = connectionFactory.createConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_USERS)) {
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong(ID));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setDate(resultSet.getDate(DATEOFBIRTH));
				result.add(user);
			}
		} catch (DatabaseException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return result;
	}

	@Override
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

}
