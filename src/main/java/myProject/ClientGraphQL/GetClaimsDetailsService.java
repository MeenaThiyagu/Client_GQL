package myProject.ClientGraphQL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import myProject.ClientGraphQL.model.ClaimDental;
import myProject.ClientGraphQL.model.ClaimMedical;
@Service
public class GetClaimsDetailsService {
	private static Logger logger = LoggerFactory.getLogger(GetClaimDetails.class);

	  RestTemplate restTempObj=new RestTemplate();
	  private RestTemplate restTemplate;
	  
	    @Async("asyncExecutor")
	    public CompletableFuture<List<ClaimDental>> getDentalClaims() throws InterruptedException, JsonMappingException, JsonProcessingException 
	    {   final String getDentalClaim = "http://localhost:8082/getDentalClaimsAsync";
	    logger.info("Current Dental thread name " + Thread.currentThread().getName());
	         HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<ClaimDental> entity = new HttpEntity<ClaimDental>(headers);
	         restTempObj.put(getDentalClaim, entity);
				String str=restTempObj.getForObject(getDentalClaim, String.class);
				ClaimDental[] drObj=new ObjectMapper().readValue(str, ClaimDental[].class);
				List<ClaimDental> dClaimsFromService=Arrays.asList(restTempObj.getForObject(getDentalClaim, ClaimDental[].class));
				System.out.println("Claims are "+dClaimsFromService.toString());
				 
				 CompletableFuture<List<ClaimDental>> listsObj=CompletableFuture.completedFuture(dClaimsFromService);
				 logger.info("getDentalClaimData completed");
				return listsObj;
	    }
	 
	    @Async("asyncExecutor")
	    public CompletableFuture<List<ClaimMedical>> getMedicalClaims() throws InterruptedException, JsonMappingException, JsonProcessingException 
	    {
	    	
	    	 final String getMedicalClaim = "http://localhost:8083/getMedicalClaimsAsync";
	    	 logger.info("Current medical thread name " + Thread.currentThread().getName());
	    	 HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<ClaimMedical> entity = new HttpEntity<ClaimMedical>(headers);
	         restTempObj.put(getMedicalClaim, entity);
				String str=restTempObj.getForObject(getMedicalClaim, String.class);
				ClaimMedical[] drObj=new ObjectMapper().readValue(str, ClaimMedical[].class);
				List<ClaimMedical> mClaimsFromService=Arrays.asList(restTempObj.getForObject(getMedicalClaim, ClaimMedical[].class));
				System.out.println("Claims are "+mClaimsFromService.toString());
				 CompletableFuture<List<ClaimMedical>> listsObj=CompletableFuture.completedFuture(mClaimsFromService);
				 logger.info("get Medical ClaimData completed");
				return listsObj;
	       
	    }	    
}
