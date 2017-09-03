package co.uk.coenie.integration.jobsites.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages="co.uk.coenie.integration.jobsites")
@PropertySource({
	"classpath:application.properties"
})
public class SpringConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

	@Value("${connection.reed.api-key}")
	private String reedApiKey;
	

	@Bean
	public Logger logger() {
		return LogManager.getLogger();
	}
	
	@Bean
	public RestTemplate reedRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		// Set timeout time
//		int timeout = 60*1000; // 60 seconds
//		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
//		SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
//		rf.setReadTimeout(timeout);
//		rf.setConnectTimeout(timeout);    

		// Message converter for marshalling JSON to objects
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		// Set Authorization header
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(reedApiKey, null));

		return restTemplate;
	}
}