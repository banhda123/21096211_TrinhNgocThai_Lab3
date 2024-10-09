package iuh.fit.se.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import iuh.fit.se.entities.ExamDetails;
import iuh.fit.se.entities.QualificationDetails;
import iuh.fit.se.entities.Student;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet(urlPatterns =  "/registration-form")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("txtFName");
		String lname = request.getParameter("txtLName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String email = request.getParameter("txtEmail");
		String mobileNumber = request.getParameter("txtMobileNumber");
		String gender = request.getParameter("gender");
		String address = request.getParameter("txtAddress");
		String city = request.getParameter("txtCity");
		String pinCode = request.getParameter("txtPinCode");
		String state = request.getParameter("txtState");
		String country = request.getParameter("txtCountry");
		String[] hobbiesArr = request.getParameterValues("chkHobbies");
		String course = request.getParameter("txtCourse");
		String birthdate = day + " " + month + " " + year;
		
		List<String> hobbies = hobbiesArr != null ? List.of(hobbiesArr) : List.of();
		
		QualificationDetails qualificationDetails = new QualificationDetails();
		
		ExamDetails classX = new ExamDetails();
		classX.setBoard(request.getParameter("txtClassXBoard"));
		classX.setPercentage(Double.parseDouble(request.getParameter("txtClassXPercentage")));
		classX.setYearOfPassing(Integer.parseInt(request.getParameter("txtClassXYear")));
		qualificationDetails.setClassX(classX);
		
		ExamDetails classXII = new ExamDetails();
		classXII.setBoard(request.getParameter("txtClassXIIBoard"));
		classXII.setPercentage(Double.parseDouble(request.getParameter("txtClassXIIPercentage")));
		classXII.setYearOfPassing(Integer.parseInt(request.getParameter("txtClassXIIYear")));
		qualificationDetails.setClassXII(classXII);
		
		ExamDetails graduation = new ExamDetails();
        graduation.setBoard(request.getParameter("txtGraduationBoard"));
        graduation.setPercentage(Double.parseDouble(request.getParameter("txtGraduationPercentage")));
        graduation.setYearOfPassing(Integer.parseInt(request.getParameter("txtGraduationYear")));
        qualificationDetails.setGraduation(graduation);
        
        ExamDetails masters = new ExamDetails();
        masters.setBoard(request.getParameter("txtMastersBoard"));
        masters.setPercentage(Double.parseDouble(request.getParameter("txtMastersPercentage")));
        masters.setYearOfPassing(Integer.parseInt(request.getParameter("txtMastersYear")));
        qualificationDetails.setMasters(masters);
		
		Student student = new Student();
		student.setFirstName(fname);
		student.setLastName(lname);
		student.setEmail(email);
		student.setGender(gender);
		student.setBirthdate(birthdate);
		student.setMobileNumber(mobileNumber);
		student.setAddress(address);
		student.setCity(city);
		student.setPinCode(pinCode);
		student.setState(state);
		student.setCountry(country);
		student.setHobbies(hobbies);
		student.setCourseAppliedFor(course);
		student.setQualificationDetails(qualificationDetails);
		
		request.setAttribute("student", student);
		
		RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
