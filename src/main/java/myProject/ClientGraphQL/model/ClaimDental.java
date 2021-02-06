package myProject.ClientGraphQL.model;

public class ClaimDental {
	 	private Long dentalId;
	    private String claimType;
	    private Long memberId;
	    private String pharmacyClaimStatus;
	    private String memberName;


	    public ClaimDental(Long dentalId, String claimType, Long memberId, String pharmacyClaimStatus,
				String memberName) {
			super();
			this.dentalId = dentalId;
			this.claimType = claimType;
			this.memberId = memberId;
			this.pharmacyClaimStatus = pharmacyClaimStatus;
			this.memberName = memberName;
		}

		public ClaimDental() {
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

		public Long getDentalId() {
			return dentalId;
		}

		public void setDentalId(Long dentalId) {
			this.dentalId = dentalId;
		}
}
