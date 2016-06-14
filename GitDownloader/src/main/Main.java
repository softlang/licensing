/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package main;

import java.io.File;
import java.io.IOException;

import gitCloner.RepositoryCloner;
import searchCrawler.Crawler;
import searchCrawler.CrawlerDataFilter;
import searchCrawler.SearchUrlBuilder;

/**
 * @author schmidtkevin
 * Main class for execution
 */
public class Main {
	
	protected static Crawler crawler;
	protected static SearchUrlBuilder urlBuilder;
	protected static CrawlerDataFilter crawlerDataFilter;
	protected static RepositoryCloner repositoryCloner;
	

	/**
	 * @param args
	 * Main method for execution
	 */
	public static void main(String[] args) {		

		/* create objects*/
		crawler = new Crawler();
		crawlerDataFilter = new CrawlerDataFilter();
		repositoryCloner = new RepositoryCloner();

		
		/* create result file */
		try {
			File searchResults = new File(Defines.searchResultFile);
			boolean created = searchResults.createNewFile();
	        System.out.println("Result File createt at: " + searchResults.getCanonicalPath() + ": " + created);
		} catch (IOException e) {
	        e.printStackTrace();
		}
		
		/* Create search file by grabbing content from GitHub */
		crawler.grabContent();		

		/* Remove duplicates in search file */
		crawlerDataFilter.removeDuplicates();
		
		/* Clone repositories listed in search file */
		repositoryCloner.cloneWithTimeout();
	}
}
