<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<style>
	.form-container {
		width: 450px;
        margin: 0 auto;
        padding: 10px;
        box-sizing: border-box;
	}

    .flex {
        display: flex;
        flex-direction: row;
        box-sizing: border-box;
        justify-content: space-between;
        margin-bottom: 10px;
    }

    .flex .inputText {
        width: 50%;
        box-sizing: border-box;
    }

    .flex .inputText.firstItem {
        margin-right: 5px;
    }

    .inputText input {
        width: 100%;
        padding: 5px;
        box-sizing: border-box;
     }

     input[type="email"],
     input[type="password"] {
        width: 100%;
        padding: 5px;
        margin-bottom: 10px;
        box-sizing: border-box;
     }

     #Birthday {
        display: block;
        text-align: left;
     }

     select {
        width: 17%;
        padding: 5px;
        margin-bottom: 10px;
        margin: 10px 10px 10px 0;
        box-sizing: border-box;
     }

     #Female {
        margin-right: 5px;
     }

     button {
        margin-top: 10px;
        width: 100%;
        background-color: blue;
        color: white;
        padding: 6px;
        border: none;
        cursor: pointer;
    }
</style>

<script>
        window.onload = function () {
            const daySelect = document.getElementById("day");
            const monthSelect = document.getElementById("month");
            const yearSelect = document.getElementById("year");

            for (let i = 1; i <= 31; i++) {
                const option = document.createElement("option");
                option.value = i;
                option.text = i;
                daySelect.appendChild(option);
            }

            for (let i = 1; i <= 12; i++) {
                const option = document.createElement("option");
                option.value = i;
                option.text = i;
                monthSelect.appendChild(option);
            }

            const currentYear = new Date().getFullYear();
            for (let i = currentYear; i >= 1900; i--) {
                const option = document.createElement("option");
                option.value = i;
                option.text = i;
                yearSelect.appendChild(option);
            }
        };
    </script>
</head>
<body>
	<div class="form-container">
        <form action="registration-form" method="post">
            <h1 style="text-align: center;">User Registration Form</h1>
            <div class="flex">
                <div class="inputText firstItem">
                    <input type="text" name="firstName" id="FirstName" placeholder="First Name" required>
                </div>
                <div class="inputText">
                    <input type="text" name="lastName" id="LastName" placeholder="Last Name" required>
                </div>
            </div>
			<div class="inputText">
	            <input id="Email" type="email" name="email" placeholder="Your Email" required>
	            <c:if test="${not empty errorMessage}">
	                <span style="color: red;">${errorMessage}</span>
	            </c:if>
        	</div>
            <input id="ReEmail" type="email" name="reemail" placeholder="Re-enter Email" required>
            <input id="Password" type="password" placeholder="New Password" required>
            <label id="Birthday" for="Birthday">Birthday</label>
            <select name="month" id="month" required>
                <option value="">Month</option>
            </select>
            <select name="day" id="day" required>
                <option value="">Day</option>
            </select>
            <select name="year" id="year" required>
                <option value="">Year</option>
            </select> <br>
            <input type="radio" name="gender" id="FemaleGender" value="Female" required>
            <label for="FemaleGender" id="Female">Female</label>
            <input type="radio" name="gender" id="MaleGender" value="Male" required>
            <label for="MaleGender" id="Male">Male</label>
            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>