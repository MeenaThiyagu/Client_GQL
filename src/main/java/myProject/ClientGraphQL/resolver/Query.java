package myProject.ClientGraphQL.resolver;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import myProject.ClientGraphQL.GetClaimDetails;
import myProject.ClientGraphQL.GetClaimsDetailsService;
import myProject.ClientGraphQL.model.*;
import myProject.ClientGraphQL.service.*;
@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	DentalClaimsService dsObj;
	
	@Autowired
	MedicalClaimsService msObj;
	
	@Autowired
	GetClaimsDetailsService allClaims;
	
	private static Logger logger = LoggerFactory.getLogger(Query.class);
	long start = System.currentTimeMillis();
	public Query() {
		
	}
	public Query(DentalClaimsService dsObj,MedicalClaimsService msObj,GetClaimsDetailsService allClaims) {
		super();
		this.dsObj = dsObj;
		this.msObj = msObj;
		this.allClaims = allClaims;
	}

	
	public String allClaimsFromService() throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException{
		CompletableFuture<List<ClaimDental>> claimDental = allClaims.getDentalClaims();
        CompletableFuture<List<ClaimMedical>> claimMedical = allClaims.getMedicalClaims();
        CompletableFuture<List<ClaimDental>> claimDental2 = allClaims.getDentalClaims();
        CompletableFuture.allOf(claimDental, claimMedical,claimDental2).join();
        
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
	    logger.info("--> " + claimDental.get());
	    logger.info("--> " + claimMedical.get());
	    logger.info("--> " + claimDental2.get());
       return "Completed";

	}
	
	public List<ClaimMedical> allMedicalClaimsFromService() throws JsonMappingException, JsonProcessingException{
<<<<<<< HEAD
		return msObj.findAllMedical();	
=======
		return msObj.findAllDental();	
	}
	public List<ClaimDental> getThisPersonDentalClaims(long memberId) throws JsonMappingException, JsonProcessingException{
		return dsObj.findThisPersonClaims(memberId);
>>>>>>> a599e879d5391739fc37cb47e07cff6b350a13ce
	}
	
	public List<ClaimMedical> getThisPersonMedicalClaims(long memberId) throws JsonMappingException, JsonProcessingException{
		return msObj.findThisPersonClaims(memberId);
	}
	
	public List<ClaimDental> getThisPersonDentalClaims(long memberId) throws JsonMappingException, JsonProcessingException{
		return dsObj.findThisPersonClaims(memberId);
	}
	
	
}
