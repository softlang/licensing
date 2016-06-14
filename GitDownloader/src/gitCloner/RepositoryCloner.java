/* The BSD License (BSD), Copyright (c) 2016 Kevin Schmidt, See: BSD.license */

package gitCloner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import gitCloner.RepoUrlBuilder;
import main.Defines;


/**
 * @author schmidtkevin
 * Methods for cloning a remote repository with authentication
 */
public class RepositoryCloner {
	
	protected RepoUrlBuilder repoUrlBuilder;

	/**
	 * constructor
	 */
	public RepositoryCloner() {
		super();
	}
	
	
    /**
     * Cloning with a timeout if there is something wrong
     */
    public void cloneWithTimeout(){
	  	ExecutorService executor = Executors.newCachedThreadPool();
		Callable<Object> task = new Callable<Object>() {
		   public Object call() {
		      return cloneRepository();
		   }
		};
		Future<Object> future = executor.submit(task);
		try {
		   future.get(Defines.cloneTimeOut, TimeUnit.SECONDS); 
		} catch (TimeoutException ex) {
			cloneWithTimeout();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} 
    }	


    /**
     * clones a remote repository
     * @return Object
     */
    public Object cloneRepository(){
    	
            // prepare a new folder for the cloned repository
            File localPath = null;
            Git result = null;
    	    repoUrlBuilder = new RepoUrlBuilder();
    	    
            while(repoUrlBuilder.loadNextRepo()){            	
				try {
					// TODO: save repositories where wanted					
					localPath = File.createTempFile("TestRepository", "");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            localPath.delete();
	            
	            System.out.println(repoUrlBuilder.getCurrentRepo());
	            
				try {
		            // then clone
		            System.out.println("Cloning repo " + repoUrlBuilder.getCurrentRepo() + " to " + localPath);
					result = Git.cloneRepository().setURI(repoUrlBuilder.getCurrentRepo()).setDirectory(localPath).call();
				} catch (GitAPIException e) {
					e.printStackTrace();
					cloneWithTimeout();
				}	
	    	    System.out.println("Having repo: " + result.getRepository().getDirectory());
	    	    result.getRepository().close();
            }
			return result;            
    }
}