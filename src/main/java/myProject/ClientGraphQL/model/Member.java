package myProject.ClientGraphQL.model;
import java.util.*;
public class Member {
		private Long memberId;
		private List<ClaimDental> dentalLists;
	    private List<ClaimMedical> medicalLists;
	    
		public Member() {} 	
	    public Long getMemberId() {
			return memberId;
		}

		public Member(Long memberId, List<ClaimDental> dentalLists, List<ClaimMedical> medicalLists) {
			super();
			this.memberId = memberId;
			this.dentalLists = dentalLists;
			this.medicalLists = medicalLists;
		}

		@Override
		public String toString() {
			return "Member [memberId=" + memberId + ", dentalLists=" + dentalLists + ", medicalLists=" + medicalLists
					+ "]";
		}

		public void setMemberId(Long memberId) {
			this.memberId = memberId;
		}

		public List<ClaimDental> getDentalLists() {
			return dentalLists;
		}

		public void setDentalLists(List<ClaimDental> dentalLists) {
			this.dentalLists = dentalLists;
		}

		public List<ClaimMedical> getMedicalLists() {
			return medicalLists;
		}

		public void setMedicalLists(List<ClaimMedical> medicalLists) {
			this.medicalLists = medicalLists;
		}



}
