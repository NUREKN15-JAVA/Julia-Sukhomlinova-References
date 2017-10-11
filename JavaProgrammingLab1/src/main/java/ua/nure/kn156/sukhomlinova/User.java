package ua.nure.kn156.sukhomlinova;


import java.util.Calendar;
import java.util.Date;

public class User {
	private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "First and last name shouldn't be empty";
	private Long id;
	private String firstName;
	private String lastName;
	/**
	 * Date of birth
	 */
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFullName() throws IllegalArgumentException {
		if (lastName==null || firstName==null || lastName.isEmpty() || firstName.isEmpty()){
			throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE);
			
		}
		return new StringBuilder(getLastName()).append(" ").append(getFirstName()).toString(); 
	}
	public long getAge() {
		Calendar calendar = Calendar.getInstance();
		long currentYear=calendar.get(Calendar.YEAR);
		calendar.setTime(getDate());
		long yearOfBirth=calendar.get(Calendar.YEAR);
		return currentYear-yearOfBirth;
	}

}
