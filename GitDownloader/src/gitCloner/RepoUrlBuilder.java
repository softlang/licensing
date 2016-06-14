/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package gitCloner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import main.Defines;

public class RepoUrlBuilder {

	private String url;	
	private String currentRepo = "";
	
	
	/**
	 * constructor
	 */
	public RepoUrlBuilder() {
		super();
	}
	
	/**
	 * @return currentPage
	 */
	public String getCurrentRepo() {
		return currentRepo;
	}


	/**
	 * @param currentPage
	 */
	public void setCurrentRepo(String currentRepo) {
		this.currentRepo = currentRepo;
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
	 * composes the repository URL 
	 * @return composed repositoryURL for execution
	 */
	public String composeURL(){		
		String repo = getCurrentRepo();
		setUrl(Defines.gitRepo + repo);
		return url;
	}
	

	/**
	 * Loads the next repository from the list and deletes it
	 * @return true, if there is still a repository
	 */
	public boolean loadNextRepo(){
		
		 RandomAccessFile raf;
		 BufferedReader reader;
		
		try {
			// read first line of search file and format it
			reader = new BufferedReader(new FileReader(Defines.searchResultFile));
			String temp = reader.readLine(); // full line 
			if (temp == null) {
				reader.close();
				return false;
			}
			String temp2 = temp.replaceFirst("\"full_name\":\"", "");  // delete prefix
			String temp3 = temp2.replaceAll("\"", ""); // delete postfix
			setCurrentRepo(Defines.gitRepo + temp3);	
		} catch (IOException e1) {
			e1.printStackTrace();
		}		

		try {
			raf = new RandomAccessFile(Defines.searchResultFile, "rw");  
		    long writePosition = raf.getFilePointer();                            
		    raf.readLine();  
		    long readPosition = raf.getFilePointer();                             
	
		    byte[] buff = new byte[1024];                                         
		    int n;                                                                
		    while (-1 != (n = raf.read(buff))) {                                  
		        raf.seek(writePosition);                                          
		        raf.write(buff, 0, n);                                            
		        readPosition += n;                                                
		        writePosition += n;                                               
		        raf.seek(readPosition);                                           
		    }                                                                     
		    raf.setLength(writePosition);                                         
		    raf.close();        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
		return true;
	}	
}
