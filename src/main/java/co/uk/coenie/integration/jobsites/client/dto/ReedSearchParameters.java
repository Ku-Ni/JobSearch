package co.uk.coenie.integration.jobsites.client.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class ReedSearchParameters {
	private String keyWords; 
	private String location;
	private int distanceFromLocation;
	private boolean permanent;
	private boolean contract;
	private boolean temp;
	private boolean partTime;
	private boolean fullTime;
	private int minSalary;
	private int maxSalary;
	
	
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getDistanceFromLocation() {
		return distanceFromLocation;
	}
	public void setDistanceFromLocation(int distanceFromLocation) {
		this.distanceFromLocation = distanceFromLocation;
	}
	
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
	public boolean isContract() {
		return contract;
	}
	public void setContract(boolean contract) {
		this.contract = contract;
	}
	
	public boolean isTemp() {
		return temp;
	}
	public void setTemp(boolean temp) {
		this.temp = temp;
	}
	
	public boolean isPartTime() {
		return partTime;
	}
	public void setPartTime(boolean partTime) {
		this.partTime = partTime;
	}
	
	public boolean isFullTime() {
		return fullTime;
	}
	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}
	
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	

	public String getParameterString() throws UnsupportedEncodingException {
		List<String> tmpParameterArr = new ArrayList<>();
		
		if (keyWords != null)
			tmpParameterArr.add("keywords="+StringUtils.replace(keyWords, " ", "+"));
		if (location != null)
			tmpParameterArr.add("locationName="+location);
		
		if(distanceFromLocation > 0)
			tmpParameterArr.add("distanceFromLocation="+distanceFromLocation);
		if (minSalary > 0)
			tmpParameterArr.add("minimumSalary="+minSalary);
		if (maxSalary > 0)
			tmpParameterArr.add("maximumSalary="+maxSalary);

		tmpParameterArr.add("permanent="+permanent);
		tmpParameterArr.add("contract="+contract);
		tmpParameterArr.add("temp="+temp);
		tmpParameterArr.add("partTime="+partTime);
		tmpParameterArr.add("fullTime="+fullTime);
		
		return String.join("&", tmpParameterArr);
	}
	
}
