package qu.edu.qa.cmps251.gui.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Utils {

	// TODO (d) complete this function so that you return the top 100 songs
	// in an arraylist from file selectedFile (parameter).
	// Use supporting functions such as getSongName() and getArtist() below.
	// The idea is that you find the line that has these information, then pass
	// that line to the functions to get both the name and song title.
	// You then add that line to the ArrayList and return it after fetching
	// 100 lines.
	public static ArrayList<String> extractTitlesFromFile(File selectedFile) {
		// create buffered reader object
		BufferedReader bf;
		ArrayList<String> titles = new ArrayList<String>();
		try {
			// instantiate object
			bf = new BufferedReader(new FileReader(selectedFile));
			// merge all lines into one string
			String all = bf.lines().collect(Collectors.joining());
			// create document object
			Document doc = Jsoup.parse(all);
			Elements artist_names = doc.getElementsByClass("chart-list-item__artist");
			Elements song_names = doc.getElementsByClass("chart-list-item__title-text");

			//System.out.println(song_names.size());
			//System.out.println(artist_names.size());

			// let us see the 0th element
			// this should print information about the top title
//	        System.out.println(divTags.get(2).attr("data-rank"));
//	        System.out.println(divTags.get(2).attr("data-artist"));
//	        System.out.println(divTags.get(2).attr("data-title"));
			String current = "";
			// iterate over all chart-list-item divtags
			for (int i = 0; i < 100; i++) {
				// append rank, artist, title to titles arraylist
				current = "";
				current += getArtist(artist_names.get(i).toString()) + " - ";
				current += getSongName(song_names.get(i).toString()) ;
				titles.add(current);
			}

			// close reader
			bf.close();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		return titles;
	}

	// TODO (e) Return the the song name from the line in html that has it.
	// this line is already passed to you in the parameter
	// you should call this function from extractTitlesFromFile()
	private static String getSongName(String line) {
		// String x= "<div class=\"chart-number-one__title\">Old Town Road</div>\n";
		// parse given html line and get song name
		Document d = Jsoup.parse(line);
		//System.out.print(d.getElementsByTag("div").text());
		return d.getElementsByTag("span").text();
	}

	// TODO (f) Return the artist name from the line in html that has it.
	// this line is already passed to you in the parameter.
	// you should call this function from extractTitlesFromFile()
	private static String getArtist(String line) {
		//String x= "<div class=\"chart-number-one__artist\">\n" + 
		//		"Lil Nas X Featuring Billy Ray Cyrus\n" + 
		//		"</div>";
		// parse give html line and find the artist name
		Document d = Jsoup.parse(line);
		//System.out.print(d.getElementsByTag("div").text());
		return d.getElementsByTag("div").text();
	}

	// TODO (g) complete this function so that
	// it saves the top 100 in the array (top100) to file selectedFile
	public static void saveToFile(ArrayList<String> top100, File selectedFile) {

		// create buffered reader object
		BufferedWriter br;
		try {
			// instantiate object
			br = new BufferedWriter(new FileWriter(selectedFile));
			// read file line by line
			String currentLine = "";
			int rank = 1;
			// iterate over arraylist
			for (String line : top100) {
				// write line and move curser to a new line
				br.write(rank +". " + line + "\n");
				rank+=1;

			}
			// close reader
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
