package cscd210Utils;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class FileUtils {

	// 1
	public static File openInputFile(String[] args) {
		if (args == null || args.length < 1) {
			throw new IllegalArgumentException();
		}
		File inf = new File(args[0]);
		if (!inf.exists())
			throw new IllegalArgumentException();

		return inf;
	}

	// 2
	public static int countRecords(Scanner fin, int linesPerRecord) {
		int numberOflines = 0;
		if (fin == null && linesPerRecord < 1) {
			throw new IllegalArgumentException();
		}
		while (fin.hasNext()) {
			String str = fin.nextLine();
			numberOflines++;
		}
		if (numberOflines == 0 || numberOflines % linesPerRecord != 0) {
			throw new RuntimeException();
		}
		return numberOflines/linesPerRecord;
	}

	// 3
	public static void displayFile(int num, Scanner fin, int linesPerRecord) {
		if (num < 1 || fin == null || linesPerRecord < 1) {
			throw new IllegalArgumentException();
		}
		int lines = num * linesPerRecord;
        for(int i = 0; i < lines; i++){
            String str = fin.nextLine();
            System.out.println(str);
        }
	}

	// 4
	public static File openInputFile(final Scanner kb) {
		if (kb == null) {
			throw new IllegalArgumentException();
		}
		String fn = "";
		File inf = null;
		do {
			System.out.println("Enter file name: ");
			fn = kb.nextLine();
			inf = new File(fn);
		} while (!inf.exists());

		return inf;
	}

	// 5
	public static String readFileName(Scanner kb, String type) {
	    // scanner is null or type is null or empty
	    if (kb == null || type == null || type.isEmpty()) {
			throw new IllegalArgumentException();
		}
		String fileName = "";
		System.out.print("PLease enter the file name of a " + 
		                type +
		                " file : ");
		fileName = kb.nextLine();
		return fileName;
	}

	// 6
	public static File openInputFile(String fn) {
		if(fn == null && fn.isEmpty()){
		    throw new IllegalArgumentException();
		    }
		 	File inf = new File(fn);
		 	if(inf.exists()){
		        return inf;
		 	}
	    else{
	       throw new RuntimeException();
	   }
	}

	// 7
	public static void displayFile(Scanner fin) {
		if(fin == null){
		    throw new IllegalArgumentException();
		}
		while(fin.hasNextLine()){
		    String data = fin.nextLine();
		    System.out.println(data);
		    
     }
		    
    }

	
	// 8
	public static File openOutputFile(String fn) {
        if(fn == null || fn.isEmpty()){
		    throw new IllegalArgumentException();
		  }
        File outf = new File(fn);
		return outf;
	}

	// 9
	public static void displayFile(Scanner fin, PrintStream fout) {
		
		fin = fin.reset();		
		if(fin == null || fout == null){
		    throw new IllegalArgumentException();
		  }
        
		while(fin.hasNextLine()){
		    String data = fin.nextLine();
		    fout.println(data);
		    
      }

	}

	// 10
	public static PrintStream openOutputFile(File outf) 
	throws java.lang.Exception{
        // This openOutputFile receives a File object. 
		PrintStream ps = new PrintStream(outf);
		return ps;
	}

}
