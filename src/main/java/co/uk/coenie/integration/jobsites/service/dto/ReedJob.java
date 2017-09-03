package co.uk.coenie.integration.jobsites.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Coenie
 *
 */
public class ReedJob {
	@JsonProperty("jobId")
	private int jobId;
	@JsonProperty("employerId")
	private int employerId;
	@JsonProperty("employerName")
	private String employerName;
	@JsonProperty("employerProfileId")
	private int employerProfileId;
	@JsonProperty("employerProfileName")
	private String employerProfileName;
	@JsonProperty("jobTitle")
	private String jobTitle;
	@JsonProperty("locationName")
	private String locationName;
	@JsonProperty("minimumSalary")
	private int minimumSalary;
	@JsonProperty("maximumSalary")
	private int maximumSalary;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("expirationDate")
	private String expirationDate;
	@JsonProperty("date")
	private String date;
	@JsonProperty("jobDescription")
	private String jobDescription;
	@JsonProperty("applications")
	private int applications;
	@JsonProperty("jobUrl")
	private String jobUrl;
	
	public int getJobId() {
		return jobId;
	}
	public int getEmployerId() {
		return employerId;
	}
	public String getEmployerName() {
		return employerName;
	}
	public int getEmployerProfileId() {
		return employerProfileId;
	}
	public String getEmployerProfileName() {
		return employerProfileName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public String getLocationName() {
		return locationName;
	}
	public int getMinimumSalary() {
		return minimumSalary;
	}
	public int getMaximumSalary() {
		return maximumSalary;
	}
	public String getCurrency() {
		return currency;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public String getDate() {
		return date;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public int getApplications() {
		return applications;
	}
	public String getJobUrl() {
		return jobUrl;
	}
}
