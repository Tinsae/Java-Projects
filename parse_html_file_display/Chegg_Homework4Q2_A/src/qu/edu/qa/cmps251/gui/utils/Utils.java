package qu.edu.qa.cmps251.gui.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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
			// read file line by line
			String currentLine = "";
			while ((currentLine = bf.readLine()) != null) {
				// split line by -
				// we will obtain two values for each line
				// the value to the right is the title(sp[1])
				String songName = getSongName(currentLine);
				String artistName = getArtist(currentLine);

				// String [] sp = currentLine.split("-");
				// print title, trim is used to remove
				// leading or trailing whitespaces
				// System.out.println(sp[1].trim());
				// artist name and song name
				// separated by space
				titles.add(artistName + "-" + songName);
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
		String[] sp = line.split("-");
		return sp[1].trim();
	}

	// TODO (f) Return the artist name from the line in html that has it.
	// this line is already passed to you in the parameter.
	// you should call this function from extractTitlesFromFile()
	private static String getArtist(String line) {
		String[] sp = line.split("-");
		// further split the left side to obtain artist name
		String[] sp2 = sp[0].split("\\.");
		// return artist name
		return sp2[1].trim();
	}

	// TODO (g) complete this function so that
	// it saves the top 100 in the array (top100) to file selectedFile
	public static void saveToFile(ArrayList<String> top100, File selectedFile) {

		// select top100
		List<String> top100_2 = top100.subList(0, 100);
		// create buffered reader object
		BufferedWriter br;
		try {
			// instantiate object
			br = new BufferedWriter(new FileWriter(selectedFile));
			// read file line by line
			String currentLine = "";
			// iterate over arraylist
			for (String line : top100_2) {
				// write line and move curser to a new line
				br.write(line + "\n");

			}
			// close reader
			br.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
