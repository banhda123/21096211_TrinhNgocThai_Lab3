<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
        }

        form {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
            background-color: #a2d9e7;
        }

        label {
            display: inline-block;
            width: 150px;
            color: #ffffff;
        }

        span {
            color: #ffffff;
        }

        select {
            width: 70px;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        textarea {
            width: 150px;
            margin-bottom: 10px;
        }

        .qualification-container {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .qualification-table {
            border-style: solid;
            border-color: blue;
            width: 100%;
            border-collapse: collapse;
        }

        .qualification-table th,
        .qualification-table td {
            padding: 8px;
            text-align: left;
        }

        .form-buttons {
            text-align: center;
            margin-top: 20px;
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

            const months = [
                "January", "February", "March", "April", "May", "June", 
                "July", "August", "September", "October", "November", "December"
            ];
            for (let i = 0; i < months.length; i++) {
                const option = document.createElement("option");
                option.value = months[i];
                option.text = months[i];
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
<form action="registration-form" name="formDangKy" method="GET">
        <label for="firstName">First name:</label>
        <input type="text" id="txtFName" name="txtFName" maxlength="30" pattern="[a-zA-Z]+" required>
        <span>(max 30 characters a-z and A-Z)</span>
        <br>

        <label for="lastName">Last name:</label>
        <input type="text" id="txtLName" name="txtLName" maxlength="30" pattern="[a-zA-Z]+" required>
        <span>(max 30 characters a-z and A-Z)</span>
        <br>

        <label for="dob">Date of birth:</label>
        <select id="day" name="day" required>
            <option value="">Day:</option>
        </select>
        <select id="month" name="month" required>
            <option value="">Month:</option>
        </select>
        <select id="year" name="year" required>
            <option value="">Year:</option>
        </select><br>

        <label for="email">Email:</label>
        <input type="email" id="txtEmail" name="txtEmail" required><br>

        <label for="mobile">Mobile number:</label>
        <input type="tel" id="txtMobileNumber" name="txtMobileNumber" pattern="[0-9]{10}" required>
        <span>(10 digit number)</span>
        <br>

        <label>Gender:</label>
        <label style="width: 35px;" id="gender" for="male">Male</label>
        <input type="radio" id="male" name="gender" value="male" required>
        <label style="width: 55px;" id="gender" for="female">Female</label>
        <input type="radio" id="female" name="gender" value="female" required><br>

        <label for="address">Address:</label>
        <textarea id="txtAddress" name="txtAddress" rows="3" required></textarea><br>

        <label for="city">City:</label>
        <input type="text" id="txtCity" name="txtCity" maxlength="30" pattern="[a-zA-Z]+" required>
        <span>(max 30 characters a-z and A-Z)</span>
        <br>

        <label for="pinCode">Pin code:</label>
        <input type="text" id="txtPinCode" name="txtPinCode" pattern="[0-9]{5}" required>
        <span>(5 digit number)</span>
        <br>

        <label for="state">State:</label>
        <input type="text" id="txtState" name="txtState" maxlength="30" pattern="[a-zA-Z]+" required>
        <span>(max 30 characters a-z and A-Z)</span>
        <br>

        <label for="country">Country:</label>
        <input type="text" id="txtCountry" name="txtCountry" value="India" readonly><br>

        <label>Hobbies:</label>
        <label style="width: 60px;" for="drawing">Drawing</label>
        <input type="checkbox" id="drawing" name="chkHobbies" value="drawing">
        <label style="width: 60px;" for="singing">Singing</label>
        <input type="checkbox" id="singing" name="chkHobbies" value="singing">
        <label style="width: 60px;" for="dancing">Dancing</label>
        <input type="checkbox" id="dancing" name="chkHobbies" value="dancing">
        <label style="width: 70px;" for="sketching">Sketching</label>
        <input type="checkbox" id="sketching" name="chkHobbies" value="sketching">
        <label style="width: 55px;" for="others">Others</label>
        <input type="checkbox" id="others" name="chkHobbies" value="others">
        <input type="text" id="otherHobbies" name="otherHobbies"><br>

        <div class="qualification-container">
            <label style="width: 170px;">Qualification:</label>
            <table class="qualification-table">
                <tr>
                    <th>S.No. Examination</th>
                    <th>Board</th>
                    <th>Percentage</th>
                    <th>Year of Passing</th>
                </tr>
                <tr>
                    <td>Class X</td>
                    <td><input type="text" name="txtClassXBoard" maxlength="10"></td>
                    <td><input type="number" name="txtClassXPercentage" step="0.01" max="100"></td>
                    <td><input type="number" name="txtClassXYear" min="1900" max="2099"></td>
                </tr>
                <tr>
                    <td>Class XII</td>
                    <td><input type="text" name="txtClassXIIBoard" maxlength="10"></td>
                    <td><input type="number" name="txtClassXIIPercentage" step="0.01" max="100"></td>
                    <td><input type="number" name="txtClassXIIYear" min="1900" max="2099"></td>
                </tr>
                <tr>
                    <td>Graduation</td>
                    <td><input type="text" name="txtGraduationBoard" maxlength="10"></td>
                    <td><input type="number" name="txtGraduationPercentage" step="0.01" max="100"></td>
                    <td><input type="number" name="txtGraduationYear" min="1900" max="2099"></td>
                </tr>
                <tr>
                    <td>Masters</td>
                    <td><input type="text" name="txtMastersBoard" maxlength="10"></td>
                    <td><input type="number" name="txtMastersPercentage" step="0.01" max="100"></td>
                    <td><input type="number" name="txtMastersYear" min="1900" max="2099"></td>
                </tr>
            </table>
        </div><br>

        <label>Course applied for:</label>
        <label style="width: 35px;" for="bca">BCA</label>
        <input type="radio" id="bca" name="txtCourse" value="BCA" required>
        <label style="width: 50px;" for="bCom">B.Com</label>
        <input type="radio" id="bCom" name="txtCourse" value="B.Com" required>
        <label style="width: 40px;" for="bSc">B.Sc</label>
        <input type="radio" id="bSc" name="txtCourse" value="B.Sc" required>
        <label style="width: 25px;" for="ba">BA</label>
        <input type="radio" id="ba" name="txtCourse" value="BA" required><br>

        <div class="form-buttons">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>