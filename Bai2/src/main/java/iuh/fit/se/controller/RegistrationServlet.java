package iuh.fit.se.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iuh.fit.se.dao.UserDAO;
import iuh.fit.se.daoImpl.UserDAOImpl;
import iuh.fit.se.models.User;
import iuh.fit.se.utils.EntityMangerFactoryUtil;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(name = "registration-form", urlPatterns =  {"/views/user/registration-form"})
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<User> users = new ArrayList();
    private EntityMangerFactoryUtil entityMangerFactoryUtil;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	users = new ArrayList<User>();
    	this.entityMangerFactoryUtil = new EntityMangerFactoryUtil();
    	this.userDAO = new UserDAOImpl(entityMangerFactoryUtil.getEntityManager());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/user/registration-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String reemail = request.getParameter("reemail");
		String password = request.getParameter("password");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String gender = request.getParameter("gender");
		
		if (Integer.parseInt(day) < 10) {
	        day = "0" + day;
	    }
	    if (Integer.parseInt(month) < 10) {
	        month = "0" + month;
	    }
		
		String birthDateStr = day + "/" + month + "/" + year;
		Date birthDate = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			birthDate = format.parse(birthDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (!email.equals(reemail)) {
	        request.setAttribute("errorMessage", "Email nhập lại không trùng khớp.");
	        RequestDispatcher rd = request.getRequestDispatcher("/views/user/registration-form.jsp");
	        rd.forward(request, response);
	        return;
	    }
	
		if(userDAO.isEmailExists(email)) {
			request.setAttribute("errorMessage", "Email đã được đăng ký với một tài khoản khác.");
			RequestDispatcher rd = request.getRequestDispatcher("/views/user/registration-form.jsp");
	        rd.forward(request, response);
	        return;
		}
		
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setPassword(password);
		newUser.setBirthDay(birthDate);
		newUser.setGender(gender);
		newUser.setEmail(email);
		users.add(newUser);
		
		userDAO.add(newUser);
		List<User> allUsers = userDAO.getAllUsers();
		request.setAttribute("users", allUsers);
		request.getRequestDispatcher("/views/common/accountList.jsp").forward(request, response);
	}
	
	@Override
	public void destroy() {
		this.entityMangerFactoryUtil.close();
		super.destroy();	
	}

}
