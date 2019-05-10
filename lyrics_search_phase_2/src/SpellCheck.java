import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SpellCheck {
  public static int computeDistance(String s1, String s2) {
      /**
       * Returns the edit distance needed to convert string s1 to s2
       * If returns 0, the strings are same
       * If returns 1, that means either a character is added, removed or replaced
       */
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    int[] costs = new int[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      int lastValue = i;
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0)
          costs[j] = j;
        else {
          if (j > 0) {
            int newValue = costs[j - 1];
            if (s1.charAt(i - 1) != s2.charAt(j - 1))
              newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
            costs[j - 1] = lastValue;
            lastValue = newValue;
          }
        }
      }
      if (i > 0)
        costs[s2.length()] = lastValue;
    }
    return costs[s2.length()];
  }
    
    static String wordfile = "dictionary.txt";
    static ArrayList <String>wordlist = new ArrayList<String>();
    static ArrayList<String> data = new ArrayList<String>();
    static ArrayList<String> list = new ArrayList<String>();
    static HashMap <String, Integer>newlist = new HashMap<String, Integer>();
    
    public static void loadwords(String filename) throws IOException{
        String line;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while((line = br.readLine()) != null){
            if(line.length()>2 && line.length()<26)
                wordlist.add(line);
        	}
        }
        
        public static void wordSuggester(String wordName){
            /**
             * Prints a list of words that can replace the word in a sorted list, along with their edit distances (difference in name)
             */
            int i;
            try {
                loadwords(wordfile);
            } catch (IOException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }
            for(String s : wordlist){
                i = SpellCheck.computeDistance(s, wordName);
                if(i<2){
                    // Adjust i. The lesser, the more precise number of options
                    newlist.put(s, i);
                }
            }

            // Sorting to get the best words in the top
            // Don't play with this part
            List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(newlist.entrySet());
            Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
                public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
            });

            Map<String, Integer> orderedMap = new LinkedHashMap<String, Integer>();
            for (Entry<String, Integer> entry : entries) {
                orderedMap.put(entry.getKey(), entry.getValue());
            }


            // Display the list of words
            int m = 0;
            for (Entry<String, Integer> e : orderedMap.entrySet()){
            	data.add(e.getKey());
            	System.out.println(m + ". " +e.getKey() + " " + e.getValue());
                m++;
            }
            
            }
        	//Getter and Setter for putting results of the search in an arraylist
            public void setData(ArrayList<String> data) {
            	this.data = data;
            }
            //System.out.print(data);
            public static ArrayList<String> getData(){
            	return data;
            //}
            //Dictionary reader
            //public static ArrayList<String> getList() throws FileNotFoundException {
            //Scanner s = new Scanner(new File("dictionary.txt"));
            //{
            //while (s.hasNext()){
                //list.add(s.next());
            //}
           
            //return list;
            
            

            //}
            
       }
}
            
            

        
     

    		 
                
        



