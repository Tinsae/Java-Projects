

import jcolibri.cbrcore.Attribute;

/**
 * Bean that stores the solution of the case
 * 
 * @author Juan A. Recio-Garcia and Tinsae Gizachew
 * @version 1.0
 */
public class IECaseSolution implements jcolibri.cbrcore.CaseComponent {

	String caseNo;
	String description;
	Long capital;
			
	
	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCapital() {
		return capital;
	}

	public void setCapital(Long capital) {
		this.capital = capital;
	}

	
	
	@Override
	public String toString() {
		return "IECaseSolution [caseNo=" + caseNo + ", description=" + description + ", capital=" + capital + "]";
	}

	public Attribute getIdAttribute() {

		return new Attribute("caseNo", this.getClass());
	}
	
}


