package ua.nure.kn156.sukhomlinova.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn156.sukhomlinova.User;
import ua.nure.kn156.sukhomlinova.db.DAOFactory;

public class BrowseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("addButton") != null) {
			add(req, resp);
			return;
		} else if (req.getParameter("editButton") != null) {
			edit(req, resp);
			return;
		} else if (req.getParameter("deleteButton") != null) {
			delete(req, resp);
			return;
		} else if (req.getParameter("detailsButton") != null) {
			details(req, resp);
			return;
		} else {
			browse(req, resp);
			return;
		}

	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add").forward(req, resp);

	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		if (idStr == null || idStr.trim().isEmpty()) {
			req.setAttribute("error", "You have to select user to do this");
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		try {
			User user = DAOFactory.getInstance().getUserDao().find(new Long(idStr));
			req.getSession().setAttribute("user", user);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/browse.jsp").forward(req, resp);
		return;
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/delete").forward(req, resp);
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/details").forward(req, resp);

	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collection users;
		try {
			users = DAOFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute("users", users);
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
