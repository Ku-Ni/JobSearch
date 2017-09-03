/**
 * 
 */
package co.uk.coenie.integration.jobsites.service;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import co.uk.coenie.integration.jobsites.dto.Job;
import co.uk.coenie.integration.jobsites.service.dto.ReedSearchParameters;

/**
 * @author Coenie
 *
 */
public interface ReedAPIClient {
	
	/**
	 * Runs Reed search for specified parameters and return results
	 * 
	 * @param parameters - ReedSearchParameters
	 * @return Set of Job objects
	 * @throws UnsupportedEncodingException 
	 */
	public Set<Job> findJobs(ReedSearchParameters parameters) throws UnsupportedEncodingException;
}
