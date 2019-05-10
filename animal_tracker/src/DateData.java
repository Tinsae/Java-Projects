// DateData uses the default compareTo method which accepts
// a generic Object that then must be cast to an object of type DateData
public class DateData implements Comparable{
	// Date 
	private int year;
	private int month;
	private int day;

	public DateData(){}

	public DateData(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public void setDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear(){
		return year;
	}
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}

	public String toString(){
		String s = "" + year + ":" + month + ":" + day;
		return s;
	}

	public boolean equals(Object other){

		if( other instanceof DateData ){
			DateData otherDate = (DateData) other;
			if( year == otherDate.getYear()){
				if( month == otherDate.getMonth()){
					if( day == otherDate.getDay()){
						return true;
					}
				}
			}
		}

		return false;
	}

	// Compare to another Object
	// this will need to be cast to a DateData before it can 
	// be compared. 
	public int compareTo(Object other){
		if( other instanceof DateData ){
			DateData otherDate = (DateData) other;
			
			int yearSum = year - otherDate.getYear();
			if(yearSum == 0){
				int monthSum = month - otherDate.getMonth();

				if( monthSum == 0){
					int daySum = day - otherDate.getDay();

					if(daySum == 0){
						return 0; // Equals the same
						// Check for time

					}else{
						return daySum;
					}
				}else{
					return monthSum;
				}
			}else{
				return yearSum;
			}
		}else{
			return -1;
		}
	}
}