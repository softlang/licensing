/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package searchCrawler;

import java.io.IOException;

import main.Defines;

/**
 * @author schmidtkevin
 * Generate search URL's for GitHub API to query all available projects
 */
public class SearchUrlBuilder {
	
	private String url;	
	private int currentPage = 0;
	private String currentQuery = "A";
	
	
	/**
	 * constructor
	 */
	public SearchUrlBuilder() {
		super();
	}
	
	
	/**
	 * @return currentQuery
	 */
	public String getCurrentQuery() {
		return currentQuery;
	}
	

	/**
	 * @param currentQuery
	 */
	public void setCurrentQuery(String currentQuery) {
		this.currentQuery = currentQuery;
	}


	/**
	 * @return currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}


	/**
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	/**
	 * composes the search URL 
	 * @return composed search URL for execution
	 */
	public String composeURL(){		
		String query = getCurrentQuery();
		int pageNumber = getCurrentPage();
		setUrl(Defines.gitSearch + query + Defines.searchElements + pageNumber);
		return url;
	}
	

	/**
	 * increments the current page
	 */
	public void incrementPage(){
		int page = getCurrentPage();
		page++;		
		setCurrentPage(page);
	}
	
	
	/**
	 * increments the query letter
	 */
	public void incrementQuery() throws IOException{
		String query = getCurrentQuery();
		char currentChar = query.charAt(0);
			if (currentChar != 'Z'){
				currentChar++;
			}
		query = Character.toString(currentChar);	
		setCurrentQuery(query);
	}	
}