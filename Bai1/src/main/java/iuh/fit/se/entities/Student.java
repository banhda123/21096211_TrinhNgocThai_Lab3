package iuh.fit.se.entities;

import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String birthdate;
	private String mobileNumber;
	private String address;
	private String city;
	private String pinCode;
	private String state;
	private String country;
	private List<String> hobbies;
	private QualificationDetails qualificationDetails;
	private String courseAppliedFor;

	public Student(String firstName, String lastName, String email, String gender, String birthdate,
			String mobileNumber, String address, String city, String pinCode, String state, String country,
			List<String> hobbies, QualificationDetails qualificationDetails, String courseAppliedFor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birthdate = birthdate;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.hobbies = hobbies;
		this.qualificationDetails = qualificationDetails;
		this.courseAppliedFor = courseAppliedFor;
	}

	public Student() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public QualificationDetails getQualificationDetails() {
		return qualificationDetails;
	}

	public void setQualificationDetails(QualificationDetails qualificationDetails) {
		this.qualificationDetails = qualificationDetails;
	}

	public String getCourseAppliedFor() {
		return courseAppliedFor;
	}

	public void setCourseAppliedFor(String courseAppliedFor) {
		this.courseAppliedFor = courseAppliedFor;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", mobileNumber=" + mobileNumber + ", address=" + address + ", city="
				+ city + ", pinCode=" + pinCode + ", state=" + state + ", country=" + country + ", hobbies=" + hobbies
				+ ", qualificationDetails=" + qualificationDetails + ", courseAppliedFor=" + courseAppliedFor + "]";
	}

}