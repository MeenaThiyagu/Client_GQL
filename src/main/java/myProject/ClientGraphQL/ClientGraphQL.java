package myProject.ClientGraphQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import myProject.ClientGraphQL.resolver.Query;
import myProject.ClientGraphQL.service.*;

@SpringBootApplication
public class ClientGraphQL {

	@Autowired
	private static DentalClaimsService dentalClaimsService;

	@Autowired
	private static MedicalClaimsService medicalClaimsService;
	
	@Autowired
	private static GetClaimsDetailsService allClaims;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientGraphQL.class, args);
	}	
	public static GraphQLSchema buildSchema(DentalClaimsService dentalClaimsService, MedicalClaimsService medicalClaimsService) {
		System.out.println("Inside GraphQL schema of main class- with kickstart");
		return SchemaParser
				.newParser()
				.file("graphql/schema.graphqls")
//                .dictionary()
				.resolvers(new Query(dentalClaimsService,medicalClaimsService,allClaims))
				.build()
				.makeExecutableSchema();
	}

	
}
