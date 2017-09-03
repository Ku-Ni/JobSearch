package co.uk.coenie.integration.jobsites.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.uk.coenie.integration.jobsites.config.Constants.ContractType;
import co.uk.coenie.integration.jobsites.config.Constants.JobSite;
import co.uk.coenie.integration.jobsites.config.Constants.JobType;
import co.uk.coenie.integration.jobsites.config.Constants.SalaryType;

public class Job {
	@JsonProperty("jobSite")
	private JobSite jobSite;
	@JsonProperty("uRL")
	private String uRL;
	@JsonProperty("title")
	private String title;
	@JsonProperty("employerName")
	private String employerName;
	@JsonProperty("location")
	private String location;
	@JsonProperty("minSalary")
	private String minSalary;
	@JsonProperty("maxSalary")
	private String maxSalary;
	@JsonProperty("annualMinSalary")
	private String annualMinSalary;
	@JsonProperty("annualMaxSalary")
	private String annualMaxSalary;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("salaryType")
	private SalaryType salaryType;
	@JsonProperty("contractType")
	private ContractType contractType;
	@JsonProperty("jobType")
	private JobType jobType;


	/**
	 * @param jobSite
	 * @param uRL
	 * @param title
	 * @param employerName
	 * @param location
	 * @param minSalary
	 * @param maxSalary
	 * @param annualMinSalary
	 * @param annualMaxSalary
	 * @param currency
	 * @param salaryType
	 * @param contractType
	 * @param jobType
	 */
	public Job(JobSite jobSite, String uRL, String title, String employerName, String location, String minSalary,
			String maxSalary, String annualMinSalary, String annualMaxSalary, String currency, SalaryType salaryType,
			ContractType contractType, JobType jobType) {
		this.jobSite = jobSite;
		this.uRL = uRL;
		this.title = title;
		this.employerName = employerName;
		this.location = location;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.annualMinSalary = annualMinSalary;
		this.annualMaxSalary = annualMaxSalary;
		this.currency = currency;
		this.salaryType = salaryType;
		this.contractType = contractType;
		this.jobType = jobType;
	}

	public JobSite getJobSite() {
		return jobSite;
	}

	public String getuRL() {
		return uRL;
	}

	public String getTitle() {
		return title;
	}

	public String getEmployerName() {
		return employerName;
	}

	public String getLocation() {
		return location;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public String getAnnualMinSalary() {
		return annualMinSalary;
	}

	public String getAnnualMaxSalary() {
		return annualMaxSalary;
	}

	public String getCurrency() {
		return currency;
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public JobType getJobType() {
		return jobType;
	}

	
	@Override
	public boolean equals(Object o) {

		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Job))
			return false;

		Job job = (Job) o;
		return Objects.equals(title, job.title) &&
				Objects.equals(employerName, job.employerName) &&
				Objects.equals(location, job.location) &&
				Objects.equals(minSalary, job.minSalary) &&
				Objects.equals(maxSalary, job.maxSalary) &&
				Objects.equals(annualMinSalary, job.annualMinSalary) &&
				Objects.equals(annualMaxSalary,job.annualMaxSalary) &&
				Objects.equals(currency, job.currency)  &&
				salaryType == job.salaryType &&
				contractType == job.contractType &&
				jobType == job.jobType;		
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				title,employerName,location,minSalary,
				maxSalary,annualMinSalary,annualMaxSalary,
				currency,salaryType,contractType,jobType
				);
	}
}
