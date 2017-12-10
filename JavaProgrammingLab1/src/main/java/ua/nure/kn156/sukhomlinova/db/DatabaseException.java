package ua.nure.kn156.sukhomlinova.db;

public class DatabaseException extends RuntimeException {

	public DatabaseException(Exception e) {
		super(e);
	}

	public DatabaseException(String string) {
		super(string);
	}

}
