/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package searchCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import searchCrawler.SearchUrlBuilder;
import searchCrawler.CrawlerDataFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import main.Defines;


/**
 * @author schmidtkevin
 * Crawler logic to grab GitHub search results from the API
 */
public class Crawler {
	
	protected SearchUrlBuilder searchUrlBuilder;
	protected CrawlerDataFilter crawlerDataFilter;
	
	
	/**
	 * constructor
	 */
	public Crawler() {
	}

	
	/**
	 * Grabs search results from the GitHub API
	 */
	public void grabContent() {
		int requestCounter = 0;
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    boolean finished = false;
	    
	    searchUrlBuilder = new SearchUrlBuilder();
		crawlerDataFilter = new CrawlerDataFilter();
	    
		System.out.println("Starting to retrieve search data...");
		System.out.print("Visited: A, ");
	    
	    while(!finished){ 
		    try {		    	
		    	/* build URL */
		        url = new URL(searchUrlBuilder.composeURL());
		        
		        /* reconnect due to request limitation and sleep for a while */
		        if (requestCounter > Defines.maxCrawlerRequests){
		        	is.close();
		        	Thread.sleep(Defines.crawlerTimeout);
			        is = url.openStream(); 	
			        requestCounter = 0;
		        }
		        
		        /* fetch data */
		        is = url.openStream(); 
		        requestCounter++;
		        br = new BufferedReader(new InputStreamReader(is));	
		        while ((line = br.readLine()) != null) {
		        	writeToTxt(line);
		        }
		        
		    } 
		    catch (MalformedURLException e) {
		         e.printStackTrace();
		    } 
		    catch (IOException e) {
				 System.out.println("HTTP response code: 403. GitHub API limits the number of requests, please wait a few minutes.");
		         e.printStackTrace();
		    } catch (InterruptedException e) {
				e.printStackTrace();
			} 
		    finally {
		        try {
		            if (is != null) is.close();
		        } 
		        catch (IOException e) {
					e.printStackTrace();
		        }
		    }
		    
		    
		    /* switch to next letter and reset page if finished, else increment page */
		    if (searchUrlBuilder.getCurrentPage() == Defines.maxSearchPages-1){
		    	if (!searchUrlBuilder.getCurrentQuery().equals("Z")){
		    		searchUrlBuilder.setCurrentPage(0);
					try {
						searchUrlBuilder.incrementQuery();
						System.out.print(searchUrlBuilder.getCurrentQuery() + ", ");
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	}
		    	else{
				    /* finished retrieval */
			    	System.out.println("Retrieving search data successfully finished!");	
		    		break;
		    	}
		    }		    
		    else{
		    	searchUrlBuilder.incrementPage();
		    }		    		    
	    }
	}
	
	
	/**
	 * Writes the crawled data to a formatted .txt file 
	 * @param content content to write to the .txt
	 */
	public void writeToTxt(String content) {
        BufferedWriter writer = null;
   
        try {        	
            /* create file in path... */
        	String filename =  "Search_" + searchUrlBuilder.getCurrentQuery()+ "_" + searchUrlBuilder.getCurrentPage();
            File temp = new File("src/RetrievedData/" + filename + ".txt");
                   
            writer = new BufferedWriter(new FileWriter(temp));
            
            /* split String before processing at every ',' to separate lines */
            String[] parts = content.split(",");
            for (int i = 0; i < parts.length; i++){
                writer.write(parts[i] + "\n");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
        
        /* immediately shorten file */
		crawlerDataFilter.deleteLines(searchUrlBuilder.getCurrentQuery(), searchUrlBuilder.getCurrentPage());
    }	
}