/**
 * 
 */
package co.uk.coenie.integration.jobsites.service;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.uk.coenie.integration.jobsites.config.SpringConfig;
import co.uk.coenie.integration.jobsites.dto.Job;
import co.uk.coenie.integration.jobsites.service.dto.ReedSearchParameters;

/**
 * @author Coenie
 *
 */
public class Test_ReedAPI {
	ApplicationContext context;
	ReedAPIClient api;
	Logger logger = LogManager.getLogger(this.getClass());


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
		api = context.getBean(ReedAPIClient.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		ReedSearchParameters parameters = new ReedSearchParameters();
		parameters.setKeyWords("Junior Java");
		parameters.setLocation("London");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Set<Job> jobs = api.findJobs(parameters);
			for (Job j:jobs) {
				logger.info("Job extracted: {}", mapper.writeValueAsString(j));
			}
		}
		catch (Exception e) {
			logger.error("{}: {}", e.getClass(), e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

}
