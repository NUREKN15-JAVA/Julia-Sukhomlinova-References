package ua.nure.kn156.sukhomlinova.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ua.nure.kn156.sukhomlinova.User;
import ua.nure.kn156.sukhomlinova.util.Messages;

public class UserTableModel extends AbstractTableModel {

	private List<User> users = new ArrayList<>();
	private String[] COLUMN_NAMES = { Messages.getString("UserTableModel.id"), 
			Messages.getString("UserTableModel.first_name"), Messages.getString("UserTableModel.last_name") };
	private Class[] COLUMN_CLASSES = { Long.class, String.class, String.class };

	public UserTableModel(Collection<User> users) {
		super();
		this.users = new ArrayList(users);
	}
	
	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = (User) users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getId();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		}
		return null;
	}
	
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}


	public Class getColumnClass(int columnIndex) {
		return COLUMN_CLASSES[columnIndex];
	}

	
	public User getUser(int index) {
		return (User) users.get(index);
	}

	public void addUsers(Collection users) {
		this.users.addAll(users);

	}

	public void clearUsers() {
		this.users = new ArrayList<User>();
	}

}
