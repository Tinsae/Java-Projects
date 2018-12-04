import java.util.regex.Pattern;

public class PhoneNumberFormatException extends Exception {
	private String storeNumber;
    public PhoneNumberFormatException(String storeNumber) {
        super("Invalid phone number format " + storeNumber);
        this.storeNumber = storeNumber;
    }
    
    public String getStoreNumber() {
    	return storeNumber;
    }

public void validatePhoneNumber(String phone) throws PhoneNumberFormatException {
    final String regexStr = "^[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
    if (!Pattern.matches(regexStr, phone)) {
        throw new PhoneNumberFormatException(phone);
    }
}
}
