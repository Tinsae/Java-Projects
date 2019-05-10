
import java.util.Collections;   

import javax.swing.JFileChooser;
import java.io.*;

public class AnimalTracker {

    private static DataPointArrayList data;

    public static void main (String[] args) {
        data = new DataPointArrayList();        
        int counter=loadDatabase();
        int first5Entry=5;
        int firstEntryPosition=0;
        int lastEntryPosition=counter-1;
        
        for(int i=0;i<first5Entry;i++){
            System.out.println(data.get(i));
        }
        
        System.out.println("Total Entries: "+counter);
        sortAscending();
        System.out.println("Find first and the last date & time");
        System.out.println("First: "+data.get(firstEntryPosition));
        System.out.println("Last: "+data.get(lastEntryPosition));    
    }

    public static int loadDatabase() {
        int counter=0;

        JFileChooser chooser = new JFileChooser(".");
        chooser.showOpenDialog(null);
        File chosenFile = chooser.getSelectedFile();
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(chosenFile));
            inFile.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                String newLine = inFile.readLine();
                if (newLine == null) {
                    break;
                }
                DataScanner ds = new DataScanner(newLine);
                DataPoint dp = ds.processLine();
                boolean added = data.add(dp);
                counter+=1;
                if(!added) {
                    throw new Exception();
                }
                

            } catch (Exception e) {
                System.out.println("Invalid line");
            }
        }
        
        return counter;
    }
    
    public static DataPointArrayList sortAscending() {         
        Collections.sort(data);         
        return data;     
    }       



}

