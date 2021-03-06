package myProject.ClientGraphQL.resolver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import myProject.ClientGraphQL.model.*;
import myProject.ClientGraphQL.service.*;
@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	DentalClaimsService dsObj;
	
	@Autowired
	MedicalClaimsService msObj;
	
	
	public Query() {
		
	}
	public Query(DentalClaimsService dsObj,MedicalClaimsService msObj) {
		super();
		this.dsObj = dsObj;
		this.msObj = msObj;
	}

	
	public List<ClaimDental> allClaimsFromService() throws JsonMappingException, JsonProcessingException{
	return dsObj.findAllDental();	
	}
	
	public List<ClaimMedical> allMedicalClaimsFromService() throws JsonMappingException, JsonProcessingException{
		return msObj.findAllDental();	
	}
	public List<ClaimDental> getThisPersonDentalClaims(long memberId) throws JsonMappingException, JsonProcessingException{
		return dsObj.findThisPersonClaims(memberId);
	}
	
	public List<ClaimMedical> getThisPersonMedicalClaims(long memberId) throws JsonMappingException, JsonProcessingException{
		return msObj.findThisPersonClaims(memberId);
	}
	
	
	
}
