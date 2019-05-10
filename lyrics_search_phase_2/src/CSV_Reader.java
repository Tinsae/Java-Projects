import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class CSV_Reader {

  public static void main (String args[]) {

    ArrayList albums = new ArrayList();
    ArrayList songs = new ArrayList();
    ArrayList lyrics = new ArrayList();

    Scanner scan = null;
    int counter = 0;

    try {
      scan = new Scanner(new File("YeezyTaughtMe.csv"));
      scan.useDelimiter("~");

      while(scan.hasNext()){

        //print out the album, song, lyric, album, song, etc...
        System.out.print(scan.next() + "\n");
        //-------------

        //counter to determine if the pulled string is an album (counter = 1), song (counter = 2), or lyric (counter = 3)
        counter += 1;
        if (counter == 4){
          counter = 1;
        }

      }
    }

    catch (FileNotFoundException fe){
      fe.printStackTrace();
    }
    finally{
      scan.close();
    }
  }
}
