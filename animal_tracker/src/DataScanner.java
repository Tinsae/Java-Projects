import java.util.*;

public class DataScanner{

	private String line;
	Scanner scan;

	public DataScanner(String line){
		line = line.replaceAll("\"","");
		this.line = line;
		scan = new Scanner(this.line);
	}

	public DataPoint processLine() throws Exception {
		scan.useDelimiter(",");

		String part;
		//First part
		part = scan.next();
		String animalID = part;
		
		//Second part
		part = scan.next();
		String[] dateAndTime = part.split(" ");

		String strDate = dateAndTime[0];
		String[] yearMonthDay=strDate.split("-");
		int year=Integer.parseInt(yearMonthDay[0]);
		int month=Integer.parseInt(yearMonthDay[1]);
		int day=Integer.parseInt(yearMonthDay[2]);
		DateData date = new DateData(year,month,day); 

		String strTime=dateAndTime[1];
		String[] hourMinuteSecond=strTime.split(":");
		int hours = Integer.parseInt(hourMinuteSecond[0]);
		int minutes = Integer.parseInt(hourMinuteSecond[1]);
		String strSec = hourMinuteSecond[2].split("\\.")[0];
		int seconds = Integer.parseInt(strSec);
		TimeData time= new TimeData(hours, minutes,seconds);

		//Third part
		part = scan.next();
		double longitude = Double.parseDouble(part);

		//Fourth part
		part = scan.next();
		double latitude = Double.parseDouble(part);

		//Construct the DataPoint object
		DataPoint dp = new DataPoint(animalID,date,time,latitude,longitude);
		return dp;
	}

}

