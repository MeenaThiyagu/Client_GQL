package myProject.ClientGraphQL.resolver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import myProject.ClientGraphQL.model.*;
import myProject.ClientGraphQL.service.*;
@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	DentalClaimsService dsObj;
	
	
	public Query() {
		
	}
	public Query(DentalClaimsService dsObj) {
		super();
		this.dsObj = dsObj;
	}

	
	public List<ClaimDental> allClaimsFromService() throws JsonMappingException, JsonProcessingException{
	return dsObj.findAllDental();	
	}
	
	
	
	
}
