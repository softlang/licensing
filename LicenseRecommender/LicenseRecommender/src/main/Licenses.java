/* The MIT License (MIT), Copyright (c) 2016 Kevin Schmidt, See: MIT.license */

package main;

import java.util.Arrays;
import java.util.LinkedList;


/*
 * This class contains all information on the licenses. If you want to add a new license:
 * 1. Add license to the licensesArray
 * 2. Add license features and compatibility in licenses declaration
 * 3. Add license to feature selector
 * 4: Add checkbox and inferred licensing
 * 5. Add in rankings
 */
public class Licenses {
	
	/**
	 * constructor
	 */
	public Licenses() {
		super();
	}
	
	public String licensesArray[] = {"Apache1", "Apache2", "GPL1", "GPL2", "GPL3" , "AGPL3", "MIT", "BSD1", "BSD2", "BSD3", "BSD4", "NO", "LGPL3" ,"Artistic2", "EPL1", "MPL2"};
	
	/* license features */
	public static String r1t = "License & copyright notice";
	public static String r2t = "State changes";
	public static String r3t = "Disclose source";
	public static String r4t = "Network use";
	public static String r5t = "Library usage";	
	public static String r6t = "Same License";	
	public static String p1t = "Commercial use";
	public static String p2t = "Private use";
	public static String p3t = "Distribution";
	public static String p4t = "Modification";
	public static String p5t = "Patent use";
	public static String p6t = "Sub-licensing";	
	public static String c1t = "Hold liable";
	public static String c2t = "Use trademark";
	public static String c3t = "Sub-licensing";
	public static String c4t = "Distribution";
	public static String c5t = "Modification";	
	public static String c6t = "Patent Use";	
	
	/* licenses declaration */
	
	//Apache v-1.0 //TODO check features
	LinkedList<String> permApache1 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constApache1 = new LinkedList<String>(Arrays.asList(c1t, c2t));	
	LinkedList<String> reqApache1 = new LinkedList<String>(Arrays.asList(r1t, r2t));
	LinkedList<String> uncApache1 = new LinkedList<String>(Arrays.asList("GPL1", "GPL2", "GPL3" , "NO"));
	
	//Apache v-2.0
	LinkedList<String> permApache2 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constApache2 = new LinkedList<String>(Arrays.asList(c1t, c2t));	
	LinkedList<String> reqApache2 = new LinkedList<String>(Arrays.asList(r1t, r2t));
	LinkedList<String> uncApache2 = new LinkedList<String>(Arrays.asList("GPL1", "GPL2", "NO"));
	
	//GNU GPL v1 //TODO check features
	LinkedList<String> reqGPL1 = new LinkedList<String>(Arrays.asList(r1t, r2t, r3t, r6t));
	LinkedList<String> permGPL1 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constGPL1 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncGPL1 = new LinkedList<String>(Arrays.asList("NO"));
	
	//GNU GPL v2 
	LinkedList<String> reqGPL2 = new LinkedList<String>(Arrays.asList(r1t, r2t, r3t, r6t));
	LinkedList<String> permGPL2 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constGPL2 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncGPL2 = new LinkedList<String>(Arrays.asList("Apache2", "GPL1", "NO"));
	
	//GNU GPL v3
	LinkedList<String> reqGPL3 = new LinkedList<String>(Arrays.asList(r1t, r2t, r3t, r6t));
	LinkedList<String> permGPL3 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constGPL3 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncGPL3 = new LinkedList<String>(Arrays.asList("Apache1", "GPL1", "GPL2", "BSD4", "NO"));
	
	//Affero GPL v3
	LinkedList<String> reqAGPL3 = new LinkedList<String>(Arrays.asList(r1t, r2t, r3t, r4t, r6t));
	LinkedList<String> permAGPL3 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constAGPL3 = new LinkedList<String>(Arrays.asList(c1t, c3t));
	LinkedList<String> uncAGPL3 = new LinkedList<String>(Arrays.asList("Apache2", "GPL1", "GPL2", "GPL3" , "BSD1", "BSD2", "BSD3", "BSD4", "NO"));
	
	//MIT
	LinkedList<String> reqMIT = new LinkedList<String>(Arrays.asList(r1t));
	LinkedList<String> permMIT = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t));
	LinkedList<String> constMIT = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncMIT = new LinkedList<String>(Arrays.asList("NO"));
	
	//BSD4
	LinkedList<String> reqBSD4 = new LinkedList<String>(Arrays.asList(r1t));
	LinkedList<String> permBSD4 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t));
	LinkedList<String> constBSD4 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncBSD4 = new LinkedList<String>(Arrays.asList("Apache1", "Apache2", "GPL1", "GPL2", "GPL3" , "NO"));
	
	//BSD1
	LinkedList<String> reqBSD1 = new LinkedList<String>(Arrays.asList(r1t));
	LinkedList<String> permBSD1 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t));
	LinkedList<String> constBSD1 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncBSD1 = new LinkedList<String>(Arrays.asList("NO"));
	
	//BSD2
	LinkedList<String> reqBSD2 = new LinkedList<String>(Arrays.asList(r1t));
	LinkedList<String> permBSD2 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t));
	LinkedList<String> constBSD2 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncBSD2 = new LinkedList<String>(Arrays.asList("NO"));
	
	//BSD3
	LinkedList<String> reqBSD3 = new LinkedList<String>(Arrays.asList(r1t));
	LinkedList<String> permBSD3 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t));
	LinkedList<String> constBSD3 = new LinkedList<String>(Arrays.asList(c1t));	
	LinkedList<String> uncBSD3 = new LinkedList<String>(Arrays.asList("NO"));
	
	//unlicensed
	LinkedList<String> reqNO = new LinkedList<String>(Arrays.asList());
	LinkedList<String> permNO = new LinkedList<String>(Arrays.asList());
	LinkedList<String> constNO = new LinkedList<String>(Arrays.asList(c1t, c2t, c3t, c4t, c5t));
	LinkedList<String> uncNO = new LinkedList<String>(Arrays.asList("Apache1", "Apache2", "GPL1", "GPL2", "GPL3" , "AGPL3", "MIT", "BSD1", "BSD2", "BSD3", "BSD4", "NO", "Artistic2", "EPL1", "MPL2", "LGPL3"));
	
	//Artistic License 2.0 //TODO check compatibility
	LinkedList<String> reqArtistic2 = new LinkedList<String>(Arrays.asList(r1t, r2t));
	LinkedList<String> permArtistic2 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constArtistic2 = new LinkedList<String>(Arrays.asList(c1t, c2t));
	LinkedList<String> uncArtistic2 = new LinkedList<String>(Arrays.asList("NO"));
	
	//Eclipse Public License 1.0 //TODO check compatibility
	LinkedList<String> reqEPL1 = new LinkedList<String>(Arrays.asList(r1t, r3t, r6t));
	LinkedList<String> permEPL1 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constEPL1 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncEPL1 = new LinkedList<String>(Arrays.asList("NO"));	
	
	//GNU LGPL 3.0 //TODO check compatibility
	LinkedList<String> reqLGPL3 = new LinkedList<String>(Arrays.asList(r1t, r3t, r6t));
	LinkedList<String> permLGPL3 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constLGPL3 = new LinkedList<String>(Arrays.asList(c1t));
	LinkedList<String> uncLGPL3 = new LinkedList<String>(Arrays.asList("NO"));		

	//Mozilla Public License 2.0 //TODO check compatibility
	LinkedList<String> reqMPL2 = new LinkedList<String>(Arrays.asList(r1t, r3t, r6t));
	LinkedList<String> permMPL2 = new LinkedList<String>(Arrays.asList(p1t, p2t, p3t, p4t, p5t));
	LinkedList<String> constMPL2 = new LinkedList<String>(Arrays.asList(c1t, c2t));
	LinkedList<String> uncMPL2 = new LinkedList<String>(Arrays.asList("NO"));	
	
	
	
	/*
	 * select features of different licenses
	 */
	@SuppressWarnings("rawtypes")
	public LinkedList<LinkedList> featureSelector(String currentLicense){
		
		LinkedList<String> req = new LinkedList<String>();
		LinkedList<String> per = new LinkedList<String>();
		LinkedList<String> con = new LinkedList<String>();
		LinkedList<LinkedList> result = new LinkedList<LinkedList>();

	        switch (currentLicense) {
	        	case "Apache1":
	            	req = reqApache1;
	            	per = permApache1;
	            	con = constApache1;
                break;
	            case "Apache2":
	            	req = reqApache2;
	            	per = permApache2;
	            	con = constApache2;
	                break;
	            case "GPL1":
	            	req = reqGPL1;
	            	per = permGPL1;
	            	con = constGPL1;
	                break;	                
	            case "GPL2":
	            	req = reqGPL2;
	            	per = permGPL2;
	            	con = constGPL2;
	                break;
	            case "GPL3":;
	            	req = reqGPL3;
	            	per = permGPL3;
	            	con = constGPL3;
	            	break;
	            case "AGPL3":
	            	req = reqAGPL3;
	            	per = permAGPL3;
	            	con = constAGPL3;
	                break;
	            case "MIT":
	            	req = reqMIT;
	            	per = permMIT;
	            	con = constMIT;
	                break;
	            case "BSD1":
	            	req = reqBSD1;
	            	per = permBSD1;
	            	con = constBSD1;
	                break;
	            case "BSD2":
	            	req = reqBSD2;
	            	per = permBSD2;
	            	con = constBSD2;
	                break;
	            case "BSD3":
	            	req = reqBSD3;
	            	per = permBSD3;
	            	con = constBSD3;
	                break;
	            case "BSD4":
	            	req = reqBSD4;
	            	per = permBSD4;
	            	con = constBSD4;
	                break;	                
	            case "NO":
	            	req = reqNO;
	            	per = permNO;
	            	con = constNO;
	                break;
	            case "EPL1":
	            	req = reqEPL1;
	            	per = permEPL1;
	            	con = constEPL1;
	                break;
	            case "MPL2":
	            	req = reqMPL2;
	            	per = permMPL2;
	            	con = constMPL2;
	                break;
	            case "LGPL3":
	            	req = reqLGPL3;
	            	per = permLGPL3;
	            	con = constLGPL3;
	                break;
	            case "Artistic2":
	            	req = reqArtistic2;
	            	per = permArtistic2;
	            	con = constArtistic2;
	                break;
	            default:
	            	req = null;
	            	per = null;
	            	con = null;
	            	break;
	        }		        
	    result.add(0, req);
	    result.add(1, per);
	    result.add(2, con);
		return result;
	}
	
	
}
