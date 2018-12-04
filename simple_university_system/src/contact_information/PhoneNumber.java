package contact_information;

public class PhoneNumber {

	private String type;
	private int areaCode;
	private int prefix;
	private int suffix;
	
	public PhoneNumber(String type, int areaCode, int prefix, int suffix) {
		this.type = type;
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getAreaCode() {
		return areaCode;
	}
	
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
	public int getPrefix() {
		return prefix;
	}
	
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	
	public int getSuffix() {
		return suffix;
	}
	
	public void setSuffix(int suffix) {
		this.suffix = suffix;
	}
	
	public boolean equals(PhoneNumber phoneNumber) {
		return phoneNumber.type.equalsIgnoreCase(this.type) &&
				phoneNumber.areaCode == this.areaCode &&
				phoneNumber.prefix == this.prefix &&
				phoneNumber.suffix == this.suffix;
	}
	
	@Override
	public String toString() {
		return type + ": " +  "(" + areaCode + ") " + prefix + "-" + suffix;
	}
	
}