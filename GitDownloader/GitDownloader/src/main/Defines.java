/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package main;

/**
 * @author schmidtkevin
 * All defines for the package searchCrawler
 */
public class Defines {
	
	/* File for the search results */
	public static final String searchResultFile = "src/RetrievedData/Search_results.txt";
	
	/* keyword to filter the search results: default = "full_name" */
	public static final String filterKey = "full_name";
	
	/* HashSet size in removeDuplicates: default = 10000 */
	public static final int removeDuplicatesHashSet = 10000;
	
	/* how many pages of the GitHub search are crawled: limit = 35 */
	public static final int maxSearchPages = 3;
	
	/* requests of the crawler until timeout */
	public static final int maxCrawlerRequests = 8;

	/* duration of timeout before continuing to request: default = 60000 */
	public static final int crawlerTimeout = 60000;
	
	/* general GitHub API search link */
	public final static String gitSearch = "https://api.github.com/search/repositories?q=";
	
	/* elements of the GitHub API search */
	/* Examples:
	 * Order by best match: &page=
	 * Order by stars desc.: +&sort=stars&order=desc&page=
	 * Based on language: +language:assembly&sort=stars&order=desc&page=
	 */ 
	public final static String searchElements  = "+&sort=stars&order=desc&page=";
	
	/* general GitHub repository search link */
	public final static String gitRepo = "https://github.com/"; 
	
	/* path for cloned repositories */
	public static final String repoPath = "src/Repos/";
	
	/* Timeout for beginning to clone the next repository in seconds */
	public static final int cloneTimeOut = 300;

}
