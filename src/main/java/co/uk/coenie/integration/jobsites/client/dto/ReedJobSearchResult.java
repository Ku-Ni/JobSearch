package co.uk.coenie.integration.jobsites.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Coenie
 *
 */
public class ReedJobSearchResult {
	@JsonProperty("results")
	private List<ReedJob> results;
	
	public List<ReedJob> getResults(){
		return results;
	}
}
