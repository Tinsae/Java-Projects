
public class DataPoint implements Comparable{
    private String animalID;
    private DateData date;
    private TimeData time;
    private double longitude;
    private double latitude;

    // Default Constructor
    // Sets animalID to "Not Set"
    // Sets time and date to default DateData and TimeData objects
    // each of these should be set to (0,0,0) be default
    public DataPoint(){
        animalID="Not Set";
        date=new DateData(0,0,0);
        time=new TimeData(0,0,0);
        longitude=0;
        latitude=0;
        
    }
    
    public DataPoint(String id,DateData date,TimeData time, double lat, double lon){
        animalID=id;
        this.date=date;
        this.time=time;
        this.latitude = lat;
        this.longitude = lon;
    }

    public DataPoint(String id, DateData date, TimeData time)
    {
    
    	
    	
    	
    }
    
    
    
    
    
    public void setLongitude(double longitude){
        this.longitude=longitude;        
    }
    
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
    
    public String toString(){
        String s=animalID+" Date: "+date.toString()+" Time: "+time.toString()+" Long: "+longitude+" Lat: "+latitude;
        return s;
    }
    
      
    public boolean equals(Object other){
        boolean match=false;
        if(other.equals(animalID)){
            match=true;
        }
        
        return match;
    }
    
    public String getAnimalID(){
        return animalID;
    }
    
    public TimeData getTime() {
        return time;
    }
    
    public DateData getDate() {
        return date;
    }
    
    
    public int compareTo(Object otherData){
        DataPoint dp = (DataPoint)otherData;
        if(date.compareTo(dp.date) == 0) {
            return time.compareTo(dp.time);
        } else {
            return date.compareTo(dp.date);
        }
        
    }
}