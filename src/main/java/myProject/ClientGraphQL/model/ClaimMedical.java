package myProject.ClientGraphQL.model;
public class ClaimMedical {
	 	private Long medicalId;
	    private String claimType;
	    private Long memberId;
	    private String pharmacyClaimStatus;
	    private String memberName;


	    public ClaimMedical(Long medicalId, String claimType, Long memberId, String pharmacyClaimStatus,
				String memberName) {
			super();
			this.medicalId = medicalId;
			this.claimType = claimType;
			this.memberId = memberId;
			this.pharmacyClaimStatus = pharmacyClaimStatus;
			this.memberName = memberName;
		}

		public ClaimMedical() {
	    }

	    public String getClaimType() {
	        return claimType;
	    }

	    public void setClaimType(String claimType) {
	        this.claimType = claimType;
	    }

	    public Long getMemberId() {
	        return memberId;
	    }

	    public void setMemberID(Long memberID) {
	        this.memberId = memberID;
	    }

	    public String getMemberName() {
	        return memberName;
	    }

	    public void setMemberName(String memberName) {
	        this.memberName = memberName;
	    }

		public String getPharmacyClaimStatus() {
			return pharmacyClaimStatus;
		}

		public void setPharmacyClaimStatus(String pharmacyClaimStatus) {
			this.pharmacyClaimStatus = pharmacyClaimStatus;
		}

		public Long getMedicalId() {
			return medicalId;
		}

		public void setMedicalId(Long medicalId) {
			this.medicalId = medicalId;
		}
}
