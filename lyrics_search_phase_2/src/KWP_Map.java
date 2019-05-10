import java.util.*;

public class KWP_Map{
  //declare the Map as global
  public SortedMap<String, String> SortedLyrics = new TreeMap<String, String>();

  //add lyrics to the Map
  public void addToMap(String album, String song, String lyrics){

    //parse given lyrics into arrays of phrases.....    ----this is for later, getting hectic already
    String[] splitPhrases = lyrics.split("\\?|\\.|\\!|\\~");

    //and words
    String[] splitWords = lyrics.split(" |\\?|\\.|\\!|\\~");

    //put words into the sorted map
    for (String lyric: splitWords){
      //convert to lowercase
      lyric = lyric.toLowerCase();
      //if the map already has the lyric
      if (SortedLyrics.get(lyric) != null){

        //split the value (the total amount of times said, then times said for each song and album pair)
        String[] totalSplitFromSongs = SortedLyrics.get(lyric).split(" ", 4);
        String[] songsSplit = totalSplitFromSongs[3].split(" \\- ");
        //some initalization
        String amountSong = "1";
        String end = "";
        //iterate through the song and album pair
        for (String amountInSentence : songsSplit){
          //split up the junk from the "song, album" part of the sentence
          String[] amountAndSong = amountInSentence.split(" ", 4);
          //create the comparative sentence
          String sentence = song + ", " + album;
          //check if the comparative sentence equals the sentence already there
          //we do this to add a value to the amount of times a word has been said in a specific song
          if (sentence.equals(amountAndSong[3])){
            //if it is there, add to that songs amount of times said
            amountSong = Integer.toString(Integer.parseInt(amountAndSong[0])+ 1);
          } else {
            //if it isn't there, add it to the end of the sentence so that we don't lose previous entries
            end = end + amountInSentence + " - ";
          }
        }//end of for loop

        //again, this is if the map already has the lyric
        //add one to the total amount of times that word has been said
        int amountTotal = Integer.parseInt(totalSplitFromSongs[0]) + 1;
        //put the whole thing together into the map with the lyric as the key, the new total amount, the new amount of times said in the song, and the previous entries.
        SortedLyrics.put(lyric, Integer.toString(amountTotal) + " times total: " + amountSong + " times in " + song + ", " + album + " - " + end);

      } else {
        //if the lyric is not in the map already, just put it in
        SortedLyrics.put(lyric, "1 time total: 1 time in " + song + ", " + album);
      }
    }
    //just a check that prints the whole thing
    //Object[] lyricsAndAmount = SortedLyrics.entrySet().toArray();
    //for (Object i : lyricsAndAmount){
    //  System.out.println(i);
    //}
  }
//end of add



  public void searchFor(String search){
    String get = SortedLyrics.get(search.toLowerCase());
    if (get != null){
      System.out.println("He said " + search.toLowerCase() + " " + get);
    }

    else {
    		
    		System.out.println("Did you mean: ");
    		SpellCheck.wordSuggester(search);
    		
    		Scanner keyboard = new Scanner(System.in);
    		System.out.println("If correct word is there, enter the number on the left. If it's not there then please try again");
    		int answer = keyboard.nextInt();
    		
    		ArrayList<String> data = SpellCheck.getData();
    		//System.out.println(data.get(answer));
    		
    		String get2 = SortedLyrics.get(data.get(answer));
    		if (get2 != null) {
    			System.out.println("He said " + data.get(answer) + " " + get2);
    		}
    		
    		else {
    			System.out.println("He never said that!");
    		}

    		
    		
    	}
    }
    
  }
 
