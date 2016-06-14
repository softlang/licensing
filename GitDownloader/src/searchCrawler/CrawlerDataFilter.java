/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package searchCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

import main.Defines;


/**
 * @author schmidtkevin
 * Simplifies and filters the results
 */
public class CrawlerDataFilter {
	
	
	/**
	 * constructor
	 */
	public CrawlerDataFilter() {
	}
	

	/**
	 * Deletes unnecessary lines from the extracted data.
	 * Only the lines containing the repository data remain
	 * @param query: current search query for temp file
	 * @param page: current search page for temp file
	 */
	public void deleteLines(String query, int page){	
		File inputFile = new File("src/RetrievedData/Search_" + query + "_" + page + ".txt");
		BufferedReader reader = null;
		String currentLine;
		
		try {
			reader = new BufferedReader(new FileReader(inputFile));

			/* delete unnecessary lines */
			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    if(!trimmedLine.contains(Defines.filterKey)) continue;			    
			    
			    /* add results to result file */
			    concatenateLine(currentLine);				
			    }
			reader.close();				
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/* clear used space */
		inputFile.delete();
	}

		
	/**
	 * Writes results into one concatenated .txt file
	 * @param newLine: line to be concatenated to the results
	 */
	public void concatenateLine(String newLine){
		newLine += System.getProperty("line.separator");
		try {
		    Files.write(Paths.get(Defines.searchResultFile), newLine.getBytes() , StandardOpenOption.APPEND);			
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	
	/**
	 * Removes duplicate lines from the list
	 */
	public void removeDuplicates(){		
		String filename = Defines.searchResultFile;
		
        try {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    Set<String> lines = new HashSet<String>(Defines.removeDuplicatesHashSet);
		    String line;
		    while ((line = reader.readLine()) != null) {
		        lines.add(line);
		    }
		    reader.close();
		    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		    for (String unique : lines) {
		        writer.write(unique);
		        writer.newLine();
		    }
		    writer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
	}
}

