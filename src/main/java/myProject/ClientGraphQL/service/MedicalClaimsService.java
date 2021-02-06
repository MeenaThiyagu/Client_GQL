package myProject.ClientGraphQL.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import myProject.ClientGraphQL.model.ClaimMedical;

@Service
public class MedicalClaimsService {
    RestTemplate restTempObj=new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();	
		
	    public List<ClaimMedical> findAllDental() throws JsonMappingException, JsonProcessingException {
			// TODO Auto-generated method stub
			final String claimsCollectUri="http://localhost:8083/getAllMedicalClaims";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ClaimMedical> entity = new HttpEntity<ClaimMedical>(headers);
			restTempObj.put(claimsCollectUri, entity);
			String str=restTempObj.getForObject(claimsCollectUri, String.class);
			System.out.println("String is "+str);
			ClaimMedical[] drObj=new ObjectMapper().readValue(str, ClaimMedical[].class);
			System.out.println("Drug added is of type HttpEntity"+drObj);
			List<ClaimMedical> mClaimsFromService=Arrays.asList(restTempObj.getForObject(claimsCollectUri, ClaimMedical[].class));
			return mClaimsFromService;
		}
}