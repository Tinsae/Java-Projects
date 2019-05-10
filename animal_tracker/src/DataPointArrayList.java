import java.util.ArrayList ;

public class DataPointArrayList extends ArrayList <DataPoint >{

	public DataPointArrayList(){
		super();
	}

	public boolean add(DataPoint data){
		if(data == null) {
			return false;
		}
		else if(data.getAnimalID().equals("NotSet")){
			return false;
		}
		else if (data.getDate()==null && data.getTime()==null ) {
			return false;
		}
		else {
			super.add(data);
			return true;
		}
	}
}

