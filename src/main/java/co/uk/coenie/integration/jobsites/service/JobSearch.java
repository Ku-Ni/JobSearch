package co.uk.coenie.integration.jobsites.service;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.uk.coenie.integration.jobsites.client.ReedAPIClient;
import co.uk.coenie.integration.jobsites.client.dto.ReedSearchParameters;
import co.uk.coenie.integration.jobsites.dto.Job;

@Controller
@RequestMapping("/search-job")
public class JobSearch {
	@Autowired
	private ReedAPIClient reed;

	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String searchJob (
			@RequestParam(value="keyWords", required=true) String keyWords,
			@RequestParam(value="location", required=true) String location,
			@RequestParam(value="distanceFromLocation", required=false) String distanceFromLocation,
			@RequestParam(value="permanent", required=false) String permanent,
			@RequestParam(value="contract", required=false) String contract,
			@RequestParam(value="temp", required=false) String temp,
			@RequestParam(value="partTime", required=false) String partTime,
			@RequestParam(value="fullTime", required=false) String fullTime,
			@RequestParam(value="minSalary", required=false) String minSalary,
			@RequestParam(value="maxSalary", required=false) String maxSalary
			){
		ReedSearchParameters parameters = new ReedSearchParameters();
		try {
			return new ObjectMapper().writeValueAsString(reed.findJobs(parameters));
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return String.valueOf(HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
