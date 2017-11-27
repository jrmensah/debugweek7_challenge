package com.example.week7_challenge.Controller;

	import javax.persistence.*;

	import java.util.Collection;
	import java.util.Set;

@Entity
public class JobSeeker {
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO
	)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String DegreeCompleted;
	private String UniversityName;
	private String YearsCompleted;
	private String JobTittle;
	private String CompanyName;
	private String YearsWorked;
	private String SkilledType;
	private String Proffesional_Level;

	@ManyToMany(mappedBy = "jobSeekers")
	private Collection<User> users;


	public JobSeeker() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDegreeCompleted() {
		return this.DegreeCompleted;
	}

	public void setDegreeCompleted(String degreeCompleted) {
		this.DegreeCompleted = degreeCompleted;
	}

	public String getUniversityName() {
		return this.UniversityName;
	}

	public void setUniversityName(String universityName) {
		this.UniversityName = universityName;
	}

	public String getYearsCompleted() {
		return this.YearsCompleted;
	}

	public void setYearsCompleted(String yearsCompleted) {
		this.YearsCompleted = yearsCompleted;
	}

	public String getJobTittle() {
		return this.JobTittle;
	}

	public void setJobTittle(String jobTittle) {
		this.JobTittle = jobTittle;
	}

	public String getCompanyName() {
		return this.CompanyName;
	}

	public void setCompanyName(String companyName) {
		this.CompanyName = companyName;
	}

	public String getYearsWorked() {
		return this.YearsWorked;
	}

	public void setYearsWorked(String yearsWorked) {
		this.YearsWorked = yearsWorked;
	}

	public String getSkilledType() {
		return this.SkilledType;
	}

	public void setSkilledType(String skilledType) {
		this.SkilledType = skilledType;
	}

	public String getProffesional_Level() {
		return this.Proffesional_Level;
	}

	public void setProffesional_Level(String proffesional_Level) {
		this.Proffesional_Level = proffesional_Level;
	}

	public JobSeeker(String firstName, String lastName, String email, String degreeCompleted, String universityName, String yearsCompleted, String jobTittle, String companyName, String yearsWorked, String skilledType, String proffesional_Level, Collection<User> users)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		DegreeCompleted = degreeCompleted;
		UniversityName = universityName;
		YearsCompleted = yearsCompleted;
		JobTittle = jobTittle;
		CompanyName = companyName;
		YearsWorked = yearsWorked;
		SkilledType = skilledType;
		Proffesional_Level = proffesional_Level;
		this.users = users;
	}

}