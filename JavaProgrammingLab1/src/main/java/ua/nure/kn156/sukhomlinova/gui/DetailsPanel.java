package ua.nure.kn156.sukhomlinova.gui;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JPanel;

import ua.nure.kn156.sukhomlinova.User;
import ua.nure.kn156.sukhomlinova.db.DatabaseException;
import ua.nure.kn156.sukhomlinova.util.Messages;

public class DetailsPanel extends AddPanel {

	private User user;
	private JButton backButton;

	public DetailsPanel(MainFrame mainFrame) {
		super(mainFrame);
		setName("detailsPanel"); 
	}

	protected void doAction(ActionEvent e) throws ParseException {
		if ("ok".equalsIgnoreCase(e.getActionCommand())) { 
			user.setFirstName(getFirstNameField().getText());
			user.setLastName(getLastNameField().getText());
			DateFormat format = DateFormat.getDateInstance();
		}
	}

	public void setUser(User user) {
		DateFormat format = DateFormat.getDateInstance();
		this.user = user;
		getFirstNameField().setText(user.getFirstName());
		getFirstNameField().setEditable(false);
		getLastNameField().setText(user.getLastName());
		getLastNameField().setEditable(false);
		getDateOfBirthField().setText(format.format(user.getDate()));
		getDateOfBirthField().setEditable(false);
	}

	protected JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getBackButton(), null);
		}
		return buttonPanel;
	}

	private JButton getBackButton() {
		if (backButton == null) {
			backButton = new JButton();
			backButton.setText(Messages.getString("DetailsPanel.back")); 
			backButton.setName("backButton"); 
			backButton.setActionCommand("back"); 
			backButton.addActionListener(this);
		}
		return backButton;
	}

}
