/* The MIT License (MIT), Copyright (c) 2016 Kevin Schmidt, See: MIT.license */

package main;

import java.applet.Applet;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.LinkedList;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;

/*
 * main class
 */
public class App extends Applet{
	
	/**
	 * constructor
	 */
	public App() {
		super();
	}
	
	protected static Licenses licenses;
	protected static LicenseSuggestion licenseSuggestion;
	
	private static final long serialVersionUID = -7030914855174471085L;
	
	/* predefined strings (for features) */
	private String requirementsPrefix = "Requirements: ";
	private String permissionsPrefix = "Permissions: ";
	private String constraintsPrefix = "Constraints: ";	
	
	/* User input */
	static LinkedList<String> requirementsList = new LinkedList<String>();
	static LinkedList<String> permissionsList = new LinkedList<String>();
	static LinkedList<String> constraintsList = new LinkedList<String>();
	
	
	/* Features of licenses */
	static LinkedList<String> suggestedLicenses = new LinkedList<String>();
	
	/* Labels */
	Label conflictLabel = new Label("Currently all features are compatible to each other :) !");
	Label requirementsLabel = new Label("Requirements: ");
	Label permissionsLabel = new Label("Permissions: ");
	Label constraintsLabel = new Label("Constraints: ");
	Label licensesLabel =  new Label("Select licenses already included in the project: ");
	Label rankingLabel =  new Label("Additional preferences: ");
	Label suggestionsLabel = new Label("Currently all and no licenses can be recommended... ");
	Label suggestionLabel = new Label("The following licenses can be recommended:");
	Label blankline1 = new Label("");
	Label blankline2 = new Label("");
	Label blankline3 = new Label("");
	Label blankline4 = new Label("");
	Label blankline5 = new Label("");
	Label blankline6 = new Label("");
	
	/* Buttons */
	Button r1 = new Button(Licenses.r1t);
	Button r2 = new Button(Licenses.r2t);
	Button r3 = new Button(Licenses.r3t);
	Button r4 = new Button(Licenses.r4t);		
	Button r5 = new Button(Licenses.r5t);
	Button r6 = new Button(Licenses.r6t);
	Button p1 = new Button(Licenses.p1t);	
	Button p2 = new Button(Licenses.p2t);		
	Button p3 = new Button(Licenses.p3t);	
	Button p4 = new Button(Licenses.p4t);		
	Button p5 = new Button(Licenses.p5t);		
	Button p6 = new Button(Licenses.p6t);
	Button c1 = new Button(Licenses.c1t);	
	Button c2 = new Button(Licenses.c2t);		
	Button c3 = new Button(Licenses.c3t);		
	Button c4 = new Button(Licenses.c4t);		
	Button c5 = new Button(Licenses.c5t);	
	Button c6 = new Button(Licenses.c6t);	
	
	/* Checkboxes (inferred licenses)*/
    Checkbox checkBox1 = new Checkbox("No License"); 	
    Checkbox checkBox2 = new Checkbox("MIT");
    Checkbox checkBox3 = new Checkbox("GPL v1");;     
    Checkbox checkBox4 = new Checkbox("GPL v2+");    
    Checkbox checkBox5 = new Checkbox("GPL v3"); 
    Checkbox checkBox6 = new Checkbox("AGPL v3");
    Checkbox checkBox7 = new Checkbox("Apache 1.0"); 
    Checkbox checkBox8 = new Checkbox("Apache 2.0");
    Checkbox checkBox9 = new Checkbox("BSD 4"); 
    Checkbox checkBox10 = new Checkbox("BSD 3"); 
    Checkbox checkBox11 = new Checkbox("BSD 2"); 
    Checkbox checkBox12 = new Checkbox("BSD 1"); 
    Checkbox checkBox13 = new Checkbox("LGPL v3.0"); 
    Checkbox checkBox14 = new Checkbox("MPL v2.0"); 
    Checkbox checkBox15 = new Checkbox("EPL v1.0"); 
    Checkbox checkBox16 = new Checkbox("Artistic v 2.0"); 
    
	/* Ranking selection*/
    Checkbox checkBoxA = new Checkbox("Enforcement-ranking");     
    Checkbox checkBoxB = new Checkbox("Popularity-ranking");
    Checkbox checkBoxC = new Checkbox("Featured licenses");
    Checkbox checkBoxD = new Checkbox("Wheeler");

	/*
	 * Initialize
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		
		/* Applet preferences */
		this.setSize(900, 500);
		setLayout(new BorderLayout());
		setBackground(Color.black);
		setForeground(Color.black);

		/* Font preferences */
		Font font1 = new Font("TimesRoman", Font.BOLD, 12);		
		Font font2 = new Font("TimesRoman", Font.ITALIC, 12);		
		conflictLabel.setFont(font2);
		requirementsLabel.setFont(font1);
		permissionsLabel.setFont(font1);
		constraintsLabel.setFont(font1);
		licensesLabel.setFont(font1);
		rankingLabel.setFont(font1);
		suggestionLabel.setFont(font1);		
		
		//default settings for checkboxes
		checkBoxC.setState(true);
		checkBoxD.setState(true);
		
		/* Panels */
		Panel panelCheckbox = new Panel();
		Panel panelReq = new Panel();
		Panel panelPerm = new Panel();
		Panel panelConst = new Panel();
		Panel panelMain = new Panel();
		Panel panelCheckbox2 = new Panel();
		
		/* Panel layouts */
		panelCheckbox.setBackground(Color.getHSBColor(13, 37, 42));
		panelCheckbox.setLayout(new GridLayout(2, 2));		
		panelReq.setBackground(Color.getHSBColor(13, 37, 42));
		panelReq.setLayout(new GridLayout(1, 1)); 		
		panelPerm.setBackground(Color.getHSBColor(13, 37, 42));
		panelPerm.setLayout(new GridLayout(1, 1)); 		
		panelConst.setBackground(Color.getHSBColor(13, 37, 42));
		panelConst.setLayout(new GridLayout(1, 1)); 		
		panelMain.setBackground(Color.getHSBColor(13, 37, 42));
		panelMain.setLayout(new GridLayout(20, 1)); 
		panelCheckbox2.setBackground(Color.getHSBColor(13, 37, 42));
		panelCheckbox2.setLayout(new FlowLayout());

		
		/* Panel selection */
	    Add(panelCheckbox, checkBox6);	// AGPLv3
	    Add(panelCheckbox, checkBox7);	// Apache1
	    Add(panelCheckbox, checkBox8);	// Apache2
	    Add(panelCheckbox, checkBox16);	// Artistic2
	    Add(panelCheckbox, checkBox12);	// BSD1
	    Add(panelCheckbox, checkBox11);	// BSD2
	    Add(panelCheckbox, checkBox10);	// BSD3
	    Add(panelCheckbox, checkBox9);	// BSD4
	    Add(panelCheckbox, checkBox15);	// EPL1
	    Add(panelCheckbox, checkBox3);	// GPLv1
	    Add(panelCheckbox, checkBox4);	// GPLv2
	    Add(panelCheckbox, checkBox5);	// GPLv3
	    Add(panelCheckbox, checkBox13);	// LGPL3
	    Add(panelCheckbox, checkBox2);	// MIT
	    Add(panelCheckbox, checkBox14);	// MPL2
	    Add(panelCheckbox, checkBox1);	// No
	    Add(panelReq, r1);		
	    Add(panelReq, r2);	
	    Add(panelReq, r3);	
	    Add(panelReq, r4);	
	    Add(panelReq, r5);	
	    Add(panelReq, r6);	
	    Add(panelPerm, p1);		
	    Add(panelPerm, p2);	
	    Add(panelPerm, p3);	
	    Add(panelPerm, p4);	
	    Add(panelPerm, p5);		
	    Add(panelPerm, p6);	
	    Add(panelConst, c1);		
	    Add(panelConst, c2);	
	    Add(panelConst, c3);	
	    Add(panelConst, c4);	
	    Add(panelConst, c5);	
	    Add(panelConst, c6);	  
	    Add(panelCheckbox2, checkBoxA);	
	    Add(panelCheckbox2, checkBoxB);	
	    Add(panelCheckbox2, checkBoxC);	
	    Add(panelCheckbox2, checkBoxD);	
	    
	    /* Main panel */
		panelMain.add(licensesLabel);
		panelMain.add("Center", panelCheckbox);		
		panelMain.add(blankline1);
		panelMain.add(requirementsLabel);
	    panelMain.add("Center", panelReq); 	    
		panelMain.add(blankline2);
		panelMain.add(permissionsLabel);	
	    panelMain.add("Center", panelPerm); 	    
		panelMain.add(blankline3);
		panelMain.add(constraintsLabel);	
	    panelMain.add("Center", panelConst); 	    
		panelMain.add(blankline4);
		panelMain.add(conflictLabel); 
		panelMain.add(blankline5);
		panelMain.add(rankingLabel);
		panelMain.add("Center", panelCheckbox2);
		panelMain.add(blankline6);	
		panelMain.add(suggestionLabel);
		panelMain.add(suggestionsLabel);		
	    add("Center", panelMain);
	}
	
	
	/*
	 * Adding buttons or checkboxes to panels (and probably do sth. more)
	 */
	public void Add(Panel p, Button b) {
		p.add(b);
	}
	
	
	public void Add(Panel p, Checkbox b) {
		p.add(b);
	}
	
	
	public void Add(String str, Panel p, Button b) {
	      p.add(str, b);
	}
		

	/*
	 * react on user actions and control workflow
	 */
	public boolean action(Event event, Object eventobject){	
		
		licenseSuggestion = new LicenseSuggestion();
		
		useLicenseCheckboxes(event, eventobject);
		useFeatureButtons(event, eventobject);
		useRankingCheckboxes(event, eventobject);
		
		return true;		
	}
	
	
	/*
	 * react on user using the license checkboxes
	 */
	public boolean useLicenseCheckboxes(Event event, Object eventobject){
		
		if(checkBox1.getState()){
			licenseSuggestion.setCheckedL1(true);
		}
		else{
			licenseSuggestion.setCheckedL1(false);
		}
		if(checkBox2.getState()){
			licenseSuggestion.setCheckedL2(true);
		}
		else{
			licenseSuggestion.setCheckedL2(false);
		}
		if(checkBox3.getState()){
			licenseSuggestion.setCheckedL3(true);
		}
		else{
			licenseSuggestion.setCheckedL3(false);
		}
		if(checkBox4.getState()){
			licenseSuggestion.setCheckedL4(true);
		}
		else{
			licenseSuggestion.setCheckedL4(false);
		}
		if(checkBox5.getState()){
			licenseSuggestion.setCheckedL5(true);
		}
		else{
			licenseSuggestion.setCheckedL5(false);
		}
		if(checkBox6.getState()){
			licenseSuggestion.setCheckedL6(true);
		}
		else{
			licenseSuggestion.setCheckedL6(false);
		}
		if(checkBox7.getState()){
			licenseSuggestion.setCheckedL7(true);
		}
		else{
			licenseSuggestion.setCheckedL7(false);
		}
		if(checkBox8.getState()){
			licenseSuggestion.setCheckedL8(true);
		}
		else{
			licenseSuggestion.setCheckedL8(false);
		}
		if(checkBox9.getState()){
			licenseSuggestion.setCheckedL9(true);
		}
		else{
			licenseSuggestion.setCheckedL9(false);
		}
		if(checkBox10.getState()){
			licenseSuggestion.setCheckedL10(true);
		}
		else{
			licenseSuggestion.setCheckedL10(false);
		}	
		if(checkBox11.getState()){
			licenseSuggestion.setCheckedL11(true);
		}
		else{
			licenseSuggestion.setCheckedL11(false);
		}	
		if(checkBox12.getState()){
			licenseSuggestion.setCheckedL12(true);
		}
		else{
			licenseSuggestion.setCheckedL12(false);
		}
		if(checkBox13.getState()){
			licenseSuggestion.setCheckedL13(true);
		}
		else{
			licenseSuggestion.setCheckedL13(false);
		}	
		if(checkBox14.getState()){
			licenseSuggestion.setCheckedL14(true);
		}
		else{
			licenseSuggestion.setCheckedL14(false);
		}	
		if(checkBox15.getState()){
			licenseSuggestion.setCheckedL15(true);
		}
		else{
			licenseSuggestion.setCheckedL15(false);
		}	
		if(checkBox16.getState()){
			licenseSuggestion.setCheckedL16(true);
		}
		else{
			licenseSuggestion.setCheckedL16(false);
		}	
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());		
		return true;		
	}
	
	
	/*
	 * react on user using the ranking checkboxes
	 */
	public boolean useRankingCheckboxes(Event event, Object eventobject){
		
		if(checkBoxA.getState()){
			licenseSuggestion.setCheckedA(true);
		}
		else{
			licenseSuggestion.setCheckedA(false);
		}
		if(checkBoxB.getState()){
			licenseSuggestion.setCheckedB(true);
		}
		else{
			licenseSuggestion.setCheckedB(false);
		}
		if(checkBoxC.getState()){
			licenseSuggestion.setCheckedC(true);
		}
		else{
			licenseSuggestion.setCheckedC(false);
		}
		if(checkBoxD.getState()){
			licenseSuggestion.setCheckedD(true);
		}
		else{
			licenseSuggestion.setCheckedD(false);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());	
		return true;		
	}	
	
	
	/*
	 * react on user using the feature buttons
	 */
	public boolean useFeatureButtons(Event event, Object eventobject){
		
		if ((event.target == r1)){
			includeRequirements(Licenses.r1t);
			return true;
		}	
		
		if ((event.target == r2)){
			includeRequirements(Licenses.r2t);
			return true;
		}	
		
		if ((event.target == r3)){
			includeRequirements(Licenses.r3t);
			return true;
		}	
		
		if ((event.target == r4)){
			includeRequirements(Licenses.r4t);
			return true;
		}
		
		if ((event.target == r5)){
			includeRequirements(Licenses.r5t);
			return true;
		}	
		
		if ((event.target == r6)){
			includeRequirements(Licenses.r6t);
			return true;
		}	
		
		if ((event.target == p1)){
			includePermissions(Licenses.p1t);
			return true;
		}
		
		if ((event.target == p2)){
			includePermissions(Licenses.p2t);
			return true;
		}
		
		if ((event.target == p3)){
			includePermissionsWithConflict(Licenses.p3t, Licenses.c4t);
			return true;
		}	
		
		if ((event.target == p4)){
			includePermissionsWithConflict(Licenses.p4t, Licenses.c5t);
			return true;
		}	
		
		if ((event.target == p5)){
			includePermissionsWithConflict(Licenses.p5t, Licenses.c6t);
			return true;
		}
		
		if ((event.target == p6)){
			includePermissionsWithConflict(Licenses.p6t, Licenses.c3t);
			return true;
		}	
		
		if ((event.target == c1)){
			includeConstraints(Licenses.c1t);
			return true;
		}	
		
		if ((event.target == c2)){
			includeConstraints(Licenses.c2t);
			return true;
		}	
		
		if ((event.target == c3)){
			includeConstraintsWithConflict(Licenses.c3t, Licenses.p6t);
			return true;
		}
		
		if ((event.target == c4)){
			includeConstraintsWithConflict(Licenses.c4t, Licenses.p3t);
			return true;
		}	
		
		if ((event.target == c5)){
			includeConstraintsWithConflict(Licenses.c5t, Licenses.p4t);
			return true;
		}
		if ((event.target == c6)){
			includeConstraintsWithConflict(Licenses.c6t, Licenses.p5t);
			return true;
		}
		
		return true;
	}

	
	/* feature compatibility and selection */
	private void includeRequirements(String feature) {
		if (!requirementsList.contains(feature)){
			requirementsList.add(feature);		
			requirementsLabel.setText(requirementsPrefix + requirementsList);
			conflictLabel.setText("Currently all features are compatible to each other :) !");
		}
		else{
			requirementsList.remove(feature);
			requirementsLabel.setText(requirementsPrefix + requirementsList);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());
	}
	
	private void includePermissions(String feature) {
		if (!permissionsList.contains(feature)){
			permissionsList.add(feature);				
			permissionsLabel.setText(permissionsPrefix + permissionsList);
			conflictLabel.setText("Currently all features are compatible to each other :) !");
		}
		else{
			permissionsList.remove(feature);
			permissionsLabel.setText(permissionsPrefix + permissionsList);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());
	}
	
	private void includePermissionsWithConflict(String feature, String conflict) {
		if (!permissionsList.contains(feature)){
			if(constraintsList.contains(conflict)){ 
				conflictLabel.setText("This feature is in conflict with another feature...");
				return;				
			}
			permissionsList.add(feature);				
			permissionsLabel.setText(permissionsPrefix + permissionsList);
			conflictLabel.setText("Currently all features are compatible to each other :) !");
		}
		else{
			permissionsList.remove(feature);
			permissionsLabel.setText(permissionsPrefix + permissionsList);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());
	}
	
	private void includeConstraints(String feature) {
		if (!constraintsList.contains(feature)){
			constraintsList.add(feature);				
			constraintsLabel.setText(constraintsPrefix + constraintsList);
			conflictLabel.setText("Currently all features are compatible to each other :) !");
		}
		else{
			constraintsList.remove(feature);
			constraintsLabel.setText(constraintsPrefix + constraintsList);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());
	}
	
	private void includeConstraintsWithConflict(String feature, String conflict) {
		if (!constraintsList.contains(feature)){				
			if(permissionsList.contains(conflict)){ 
				conflictLabel.setText("This feature is in conflict with another feature...");
				return;				
			}
			constraintsList.add(feature);				
			constraintsLabel.setText(constraintsPrefix + constraintsList);
			conflictLabel.setText("Currently all features are compatible to each other :) !");
		}
		else{
			constraintsList.remove(feature);
			constraintsLabel.setText(constraintsPrefix + constraintsList);
		}
		suggestionsLabel.setText(licenseSuggestion.SuggestLicense().toString());
	}
	
	
	
	
	
}