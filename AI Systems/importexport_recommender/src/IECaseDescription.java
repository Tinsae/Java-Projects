

import jcolibri.cbrcore.Attribute;

/**
 * Bean that stores the solution of the case (trip)
 * 
 * @author Juan A. Recio-Garcia and Tinsae Gizachew
 * @version 1.0
 */
public class IECaseDescription implements jcolibri.cbrcore.CaseComponent {

	


	String caseNo;
	String nationality;
	String legalStatus;	
	String location;	
	String group;	
	String subGroup;	

	
		
	
	public String getCaseNo() {
		return caseNo;
	}



	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}



	public String getNationality() {
		return nationality;
	}



	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public String getLegalStatus() {
		return legalStatus;
	}



	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public String getSubGroup() {
		return subGroup;
	}



	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

		
	public Attribute getIdAttribute() {
		return new Attribute("caseNo", this.getClass());
	}


	
	@Override
	public String toString() {
		return "IECaseDescription [caseNo=" + caseNo + ", nationality=" + nationality + ", legalStatus=" + legalStatus
				+ ", location=" + location + ", group=" + group + ", subGroup=" + subGroup + "]";
	}



}
