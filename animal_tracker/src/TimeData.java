//TimeData will simply hold three integers (int hours, int minutes, int seconds)
// TimeData uses the default compareTo method which accepts
// a generic Object that then must be cast to an object of type TimeData
public class TimeData implements Comparable{
    private int hours ;
    private int minutes;
    private int seconds;

    public TimeData(){}
    
    public TimeData(int hours , int minutes , int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        
    }
    
    public void  setTime(int hours , int minutes , int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        
    }
    
    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    
    public String toString(){
        String s = "" + hours + ":" + minutes + ":" + seconds;
        return s;
    }

    public boolean equals(Object other){

	if( other instanceof TimeData ){
		TimeData otherTime = (TimeData) other;
		if( hours == otherTime.getHours()){
			if( minutes == otherTime.getMinutes()){
				if( seconds == otherTime.getSeconds()){
					return true;
				}
			}
		}
	}

	return false;
    }
    
    // Compare to another Object
    // this will need to be cast to a TimeData before it can 
    // be compared. 

    public int compareTo(Object other){
	if( other instanceof TimeData ){
		TimeData otherTime = (TimeData) other;
		
		int hoursSum = hours - otherTime.getHours();
		if(hoursSum == 0){
			int minutesSum = minutes - otherTime.getMinutes();

			if( minutesSum == 0){
				int secondsSum = seconds - otherTime.getSeconds();

				if(secondsSum == 0){
					return 0; // Equals the same
					// Check for time

				}else{
					return secondsSum;
				}
			}else{
				return minutesSum;
			}
		}else{
			return hoursSum;
		}
	}else{
		return -1;
	}
    }
}
