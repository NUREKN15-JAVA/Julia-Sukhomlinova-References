package ua.nure.kn156.sukhomlinova.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import ua.nure.kn156.sukhomlinova.User;
import ua.nure.kn156.sukhomlinova.db.DAOFactory;
import ua.nure.kn156.sukhomlinova.db.DatabaseException;

public class DeleteServlet extends EditServlet {

	@Override
	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/delete.jsp").forward(req, resp);
	}

	@Override
	protected void processUser(User user) throws DatabaseException {
		DAOFactory.getInstance().getUserDao().delete(user);
	}

	@Override
	protected User getUser(HttpServletRequest req) throws ValidationException {
		User user = new User();
		String idStr = req.getParameter("id");
		if (idStr != null) {
			user.setId(new Long(idStr));
		} else {
			throw new ValidationException("You have to select user");
		}
		return user;
	}

}
