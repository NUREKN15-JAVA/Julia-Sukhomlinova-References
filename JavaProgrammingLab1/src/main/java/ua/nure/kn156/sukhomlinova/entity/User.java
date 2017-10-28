package ua.nure.kn156.sukhomlinova.entity;


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
	
	public User(){}
	public User(User user){
		id=user.id;
		firstName=user.firstName;
		lastName=user.lastName;
		date=user.date;
	}
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
