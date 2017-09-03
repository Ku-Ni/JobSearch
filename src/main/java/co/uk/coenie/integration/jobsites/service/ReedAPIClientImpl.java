package co.uk.coenie.integration.jobsites.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.uk.coenie.integration.jobsites.config.Constants.JobSite;
import co.uk.coenie.integration.jobsites.dto.Job;
import co.uk.coenie.integration.jobsites.service.dto.ReedJob;
import co.uk.coenie.integration.jobsites.service.dto.ReedJobSearchResult;
import co.uk.coenie.integration.jobsites.service.dto.ReedSearchParameters;

@Service
public class ReedAPIClientImpl implements ReedAPIClient {
	@Autowired
	private RestTemplate reedRestTemplate;
	@Autowired
	private Logger logger;

	@Value("${connection.reed.url.search}")
	private String searchEndpoint;

	@Override
	public Set<Job> findJobs(ReedSearchParameters parameters) throws UnsupportedEncodingException {
		URI url = URI.create(searchEndpoint+parameters.getParameterString());
		logger.info("Calling {}...", url.getPath());
		List<ReedJob> results = reedRestTemplate.getForObject(url, ReedJobSearchResult.class).getResults();

		Set<Job> jobSet = new HashSet<>();
		for (ReedJob rj: results) {
			jobSet.add(new Job(JobSite.REED, 
					rj.getJobUrl(), 
					rj.getJobTitle(), 
					rj.getEmployerName(), 
					rj.getLocationName(), 
					String.valueOf(rj.getMinimumSalary()),
					String.valueOf(rj.getMaximumSalary()),
					String.valueOf(rj.getMinimumSalary()),
					String.valueOf(rj.getMaximumSalary()),
					rj.getCurrency(),
					null,
					null,
					null));
		}
		
		return jobSet;
	}

}
