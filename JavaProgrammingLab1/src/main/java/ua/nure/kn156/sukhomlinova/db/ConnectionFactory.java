package ua.nure.kn156.sukhomlinova.db;

import ua.nure.kn156.sukhomlinova.exception.DatabaseException;

public interface ConnectionFactory {
	public java.sql.Connection createConnection() throws DatabaseException;
}
