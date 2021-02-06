package myProject.ClientGraphQL.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import myProject.ClientGraphQL.model.ClaimDental;


@Service
public class DentalClaimsService {
    RestTemplate restTempObj=new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();	
		
	    public List<ClaimDental> findAllDental() throws JsonMappingException, JsonProcessingException {
			// TODO Auto-generated method stub
			final String claimsCollectUri="http://localhost:8082/getAllDentalClaims";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ClaimDental> entity = new HttpEntity<ClaimDental>(headers);
			restTempObj.put(claimsCollectUri, entity);
			String str=restTempObj.getForObject(claimsCollectUri, String.class);
			System.out.println("String is "+str);
			ClaimDental[] drObj=new ObjectMapper().readValue(str, ClaimDental[].class);
			System.out.println("Drug added is of type HttpEntity"+drObj);
			List<ClaimDental> dClaimsFromService=Arrays.asList(restTempObj.getForObject(claimsCollectUri, ClaimDental[].class));
			return dClaimsFromService;
		}
	
	  public List<ClaimDental> findThisPersonClaims(long memberId) throws JsonMappingException, JsonProcessingException {
			// TODO Auto-generated method stub
			final String claimsCollectUri="http://localhost:8082/getAllDentalClaims/"+memberId;
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ClaimDental> entity = new HttpEntity<ClaimDental>(headers);
			restTempObj.put(claimsCollectUri, entity);
			String str=restTempObj.getForObject(claimsCollectUri, String.class);
			ClaimDental[] drObj=new ObjectMapper().readValue(str, ClaimDental[].class);
			System.out.println("Drug added is of type HttpEntity"+drObj);
			List<ClaimDental> dClaimsFromService=Arrays.asList(restTempObj.getForObject(claimsCollectUri, ClaimDental[].class));
			return dClaimsFromService;
		}
}
