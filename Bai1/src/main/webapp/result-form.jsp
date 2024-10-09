<%@page import="java.util.List"%>
<%@page import="iuh.fit.se.entities.QualificationDetails"%>
<%@page import="iuh.fit.se.entities.ExamDetails"%>
<%@page import="iuh.fit.se.entities.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result submit</title>
</head>
<body>
    <%
        Student student = (Student) request.getAttribute("student");
        if (student != null) {
    %>
        <h1>Registration Details</h1>
        <p><strong>First name:</strong> <%= student.getFirstName() %></p>
        <p><strong>Last name:</strong> <%= student.getLastName() %></p>
        <p><strong>Email:</strong> <%= student.getEmail() %></p>
        <p><strong>Mobile Number:</strong> <%= student.getMobileNumber() %></p>
        <p><strong>Gender:</strong> <%= student.getGender() %></p>
        <p><strong>Birthdate:</strong> <%= student.getBirthdate() %></p>
        <p><strong>Address:</strong> <%= student.getAddress() %></p>
        <p><strong>City:</strong> <%= student.getCity() %></p>
        <p><strong>State:</strong> <%= student.getState() %></p>
        <p><strong>Country:</strong> <%= student.getCountry() %></p>
        <p><strong>Pin Code:</strong> <%= student.getPinCode() %></p>
        <p><strong>Course Applied For:</strong> <%= student.getCourseAppliedFor() %></p>
        
        <h2>Hobbies:</h2>
        <ul>
            <%
                List<String> hobbies = student.getHobbies();
                if (hobbies != null && !hobbies.isEmpty()) {
                    for (String hobby : hobbies) {
            %>
                <li><%= hobby %></li>
            <%
                    }
                } else {
            %>
                <li>No hobbies selected</li>
            <%
                }
            %>
        </ul>
        
        <h2>Qualification Details</h2>
        <%
            QualificationDetails qualifications = student.getQualificationDetails();
            if (qualifications != null) {
        %>
            <h3>Class X</h3>
            <p><strong>Board:</strong> <%= qualifications.getClassX().getBoard() %></p>
            <p><strong>Percentage:</strong> <%= qualifications.getClassX().getPercentage() %></p>
            <p><strong>Year of Passing:</strong> <%= qualifications.getClassX().getYearOfPassing() %></p>
            
            <h3>Class XII</h3>
            <p><strong>Board:</strong> <%= qualifications.getClassXII().getBoard() %></p>
            <p><strong>Percentage:</strong> <%= qualifications.getClassXII().getPercentage() %></p>
            <p><strong>Year of Passing:</strong> <%= qualifications.getClassXII().getYearOfPassing() %></p>
            
            <h3>Graduation</h3>
            <p><strong>Board:</strong> <%= qualifications.getGraduation().getBoard() %></p>
            <p><strong>Percentage:</strong> <%= qualifications.getGraduation().getPercentage() %></p>
            <p><strong>Year of Passing:</strong> <%= qualifications.getGraduation().getYearOfPassing() %></p>
            
            <h3>Masters</h3>
            <p><strong>Board:</strong> <%= qualifications.getMasters().getBoard() %></p>
            <p><strong>Percentage:</strong> <%= qualifications.getMasters().getPercentage() %></p>
            <p><strong>Year of Passing:</strong> <%= qualifications.getMasters().getYearOfPassing() %></p>
        <%
            } else {
        %>
            <p>No qualification details available</p>
        <%
            }
        %>
    <%
        } else {
    %>
        <p>No student details available.</p>
    <%
        }
    %>
</body>
</html>
