/* The MIT License (MIT), Copyright (c) 2016 Kevin Schmidt, See: MIT.license */

package main;

import java.awt.Checkbox;
import java.util.LinkedList;
import main.App;

public class LicenseSuggestion{
	
	//TODO: ordering by featured licenses
	
	/**
	 * Class for suggesting licenses based on the recommendation logic
	 */
	protected static Licenses licenses;
	
	boolean checkedL1, checkedL2, checkedL3, checkedL4, checkedL5, checkedL6, checkedL7, checkedL8, checkedL9, checkedL10, checkedL11, checkedL12, checkedL13, checkedL14, checkedL15, checkedL16;
	boolean checkedA, checkedB, checkedC, checkedD;
	
	public boolean isCheckedA() {
		return checkedA;
	}
	public void setCheckedA(boolean checkedA) {
		this.checkedA = checkedA;
	}
	public boolean isCheckedB() {
		return checkedB;
	}
	public void setCheckedB(boolean checkedB) {
		this.checkedB = checkedB;
	}
	public boolean isCheckedC() {
		return checkedC;
	}
	public void setCheckedC(boolean checkedC) {
		this.checkedC = checkedC;
	}
	public boolean isCheckedD() {
		return checkedD;
	}
	public void setCheckedD(boolean checkedD) {
		this.checkedD = checkedD;
	}
	public boolean isCheckedL1() {
		return checkedL1;
	}
	public void setCheckedL1(boolean checkedL1) {
		this.checkedL1 = checkedL1;
	}
	public boolean isCheckedL2() {
		return checkedL2;
	}
	public void setCheckedL2(boolean checkedL2) {
		this.checkedL2 = checkedL2;
	}
	public boolean isCheckedL3() {
		return checkedL3;
	}
	public void setCheckedL3(boolean checkedL3) {
		this.checkedL3 = checkedL3;
	}
	public boolean isCheckedL4() {
		return checkedL4;
	}
	public void setCheckedL4(boolean checkedL4) {
		this.checkedL4 = checkedL4;
	}
	public boolean isCheckedL5() {
		return checkedL5;
	}
	public void setCheckedL5(boolean checkedL5) {
		this.checkedL5 = checkedL5;
	}
	public boolean isCheckedL6() {
		return checkedL6;
	}
	public void setCheckedL6(boolean checkedL6) {
		this.checkedL6 = checkedL6;
	}
	public boolean isCheckedL7() {
		return checkedL7;
	}
	public void setCheckedL7(boolean checkedL7) {
		this.checkedL7 = checkedL7;
	}
	public boolean isCheckedL8() {
		return checkedL8;
	}
	public void setCheckedL8(boolean checkedL8) {
		this.checkedL8 = checkedL8;
	}	
	public boolean isCheckedL9() {
		return checkedL9;
	}
	public void setCheckedL9(boolean checkedL9) {
		this.checkedL9 = checkedL9;
	}
	public boolean isCheckedL10() {
		return checkedL10;
	}
	public void setCheckedL10(boolean checkedL10) {
		this.checkedL10 = checkedL10;
	}
	public boolean isCheckedL11() {
		return checkedL11;
	}
	public void setCheckedL11(boolean checkedL11) {
		this.checkedL11 = checkedL11;
	}
	public boolean isCheckedL12() {
		return checkedL12;
	}
	public void setCheckedL12(boolean checkedL12) {
		this.checkedL12 = checkedL12;
	}
	public boolean isCheckedL13() {
		return checkedL13;
	}
	public void setCheckedL13(boolean checkedL13) {
		this.checkedL13 = checkedL13;
	}
	public boolean isCheckedL14() {
		return checkedL14;
	}
	public void setCheckedL14(boolean checkedL14) {
		this.checkedL14 = checkedL14;
	}
	public boolean isCheckedL15() {
		return checkedL15;
	}
	public void setCheckedL15(boolean checkedL15) {
		this.checkedL15 = checkedL15;
	}
	public boolean isCheckedL16() {
		return checkedL16;
	}
	public void setCheckedL16(boolean checkedL16) {
		this.checkedL16 = checkedL16;
	}

	/**
	 * constructor
	 */
	public LicenseSuggestion() {
		super();
	}	
	
	
	/*
	 * Check if the requirements of a license match the current requirementsList
	 */
	public boolean CheckRequirements(LinkedList<String> requirements){
		return CompareLists(App.requirementsList, requirements);
	}
	
	
	/*
	 * Check if the requirements of a license match the current permissionsList
	 */
	public boolean CheckPermissions(LinkedList<String> permissions){
		return CompareLists(App.permissionsList, permissions);
	}
	
	
	/*
	 * Check if the requirements of a license match the current constraintsList
	 */
	public boolean CheckConstraints(LinkedList<String> constraints){
		return CompareLists(App.constraintsList, constraints);		
	}
	
	
	/*
	 * Check if all elements of listA are in listB
	 */
	public boolean CompareLists(LinkedList<String> listA, LinkedList<String> listB){
	boolean contains = true;
	   	for (int i = 0; i < listA.size(); i++) {
	   		if(!listB.contains(listA.get(i))){
	   			contains = false;
	   		}
	   	}
	return contains;
	}
	
	
	/*
	 * Remove all elements in listA from listB
	 */
	public LinkedList<String> RemoveListElements(LinkedList<String> listA, LinkedList<String> listB){
	   	for (int i = 0; i < listA.size(); i++) {
	   			listB.remove(listA.get(i));
	   	}
	return listB;
	}
	
	
	/*
	 * Logic to suggest a license
	 */
	public LinkedList<String> SuggestLicense(){
		
		LinkedList<String> suggestedLicenses = new LinkedList<String>();
		suggestedLicenses = CheckFeatures();
		suggestedLicenses = CheckInferredLicenses(suggestedLicenses);
		if(!isCheckedA() && isCheckedB()){
			suggestedLicenses = IncludePopularity(suggestedLicenses);
		}
		if(isCheckedA() && !isCheckedB()){
			suggestedLicenses = IncludeEnforcement(suggestedLicenses);
		}
		if(isCheckedA() && isCheckedB()){
			suggestedLicenses = IncludePopularityAndEnforcement(suggestedLicenses);
		}		
		if(isCheckedC()){
			// remove not recommended licenses
			suggestedLicenses.remove("Apache1");
			suggestedLicenses.remove("BSD4");
			suggestedLicenses.remove("NO");
			suggestedLicenses.remove("GPL1");
			suggestedLicenses.remove("EPL1");
			suggestedLicenses.remove("Artistic2");
		}
		if(isCheckedD()){
			// include Wheeler's license slide (other licenses not included)
			if(isCheckedL6()){ //AGPL3
				suggestedLicenses.remove("MIT");
				suggestedLicenses.remove("GPL2");
				suggestedLicenses.remove("GPL3");
				suggestedLicenses.remove("Apache2");
				suggestedLicenses.remove("BSD3");
				suggestedLicenses.remove("BSD2");
				suggestedLicenses.remove("BSD1");
				suggestedLicenses.remove("LGPL3");
				suggestedLicenses.remove("MPL2");	
			}
			if(isCheckedL5()){ //GPL3
				suggestedLicenses.remove("MIT");
				suggestedLicenses.remove("GPL2");
				suggestedLicenses.remove("Apache2");
				suggestedLicenses.remove("BSD3");
				suggestedLicenses.remove("BSD2");
				suggestedLicenses.remove("BSD1");
				suggestedLicenses.remove("LGPL3");	
				suggestedLicenses.remove("MPL2");	
			}
			if(isCheckedL4()){ //GPL2
				suggestedLicenses.remove("MIT");
				suggestedLicenses.remove("GPL3");
				suggestedLicenses.remove("Apache2");
				suggestedLicenses.remove("BSD3");
				suggestedLicenses.remove("BSD2");
				suggestedLicenses.remove("BSD1");
				suggestedLicenses.remove("LGPL3");	
				suggestedLicenses.remove("MPL2");	
			}
			if(isCheckedL13()){ //LGPL3
				suggestedLicenses.remove("MIT");
				suggestedLicenses.remove("GPL2");
				suggestedLicenses.remove("Apache2");
				suggestedLicenses.remove("BSD3");
				suggestedLicenses.remove("BSD2");
				suggestedLicenses.remove("BSD1");
				suggestedLicenses.remove("MPL2");	
			}
			if(isCheckedL8()){ //Apache2
				suggestedLicenses.remove("MIT");
				suggestedLicenses.remove("BSD3");
				suggestedLicenses.remove("BSD2");
				suggestedLicenses.remove("BSD1");
				suggestedLicenses.remove("MPL2");	
			}
			if(isCheckedL10() || isCheckedL11() || isCheckedL12()){ //BSD1, BSD2, BSD3
				suggestedLicenses.remove("MIT");
			}
		}
		return suggestedLicenses;
	}
	
	
	/*
	 * check if features are contained in the different licenses
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList<String> CheckFeatures(){
		
		licenses = new Licenses();
		LinkedList<String> suggestedLicenses = new LinkedList<String>();
		String currentLicense;
		String[] licensesArray = licenses.licensesArray;
		LinkedList<LinkedList> features = new LinkedList<LinkedList>();
		
		suggestedLicenses = App.suggestedLicenses;
		
	        
		for (int i = 0; i < licensesArray.length; i++){
			currentLicense = licensesArray[i];			
			
			features = licenses.featureSelector(currentLicense);
	
			if(CheckRequirements(features.get(0)) && CheckPermissions(features.get(1)) && CheckConstraints(features.get(2))) {	
				if (!suggestedLicenses.contains(currentLicense)){
					suggestedLicenses.add(currentLicense);
				}
			}
			else{
				suggestedLicenses.remove(currentLicense);
			}	
		}
		return suggestedLicenses;		
	}
	
	
	/*
	 * Exclude incompatible licenses
	 */
	public LinkedList<String> CheckInferredLicenses(LinkedList<String> list){
		
		if(isCheckedL1()){ 
			RemoveListElements(licenses.uncNO, list);			
		}		
		if(isCheckedL2()){
			RemoveListElements(licenses.uncMIT, list);		
		}		
		if(isCheckedL3()){
			RemoveListElements(licenses.uncGPL1, list);		
		}
		if(isCheckedL4()){
			RemoveListElements(licenses.uncGPL2, list);		
		}
		if(isCheckedL5()){
			RemoveListElements(licenses.uncGPL3, list);		
		}
		if(isCheckedL6()){
			RemoveListElements(licenses.uncAGPL3, list);		
		}
		if(isCheckedL7()){
			RemoveListElements(licenses.uncApache1, list);		
		}
		if(isCheckedL8()){
			RemoveListElements(licenses.uncApache2, list);		
		}
		if(isCheckedL9()){
			RemoveListElements(licenses.uncBSD4, list);		
		}
		if(isCheckedL10()){ 
			RemoveListElements(licenses.uncBSD3, list);		
		}
		if(isCheckedL11()){ 
			RemoveListElements(licenses.uncBSD2, list);		
		}
		if(isCheckedL12()){
			RemoveListElements(licenses.uncBSD1, list);		
		}	
		if(isCheckedL13()){
			RemoveListElements(licenses.uncEPL1, list);		
		}	
		if(isCheckedL14()){
			RemoveListElements(licenses.uncLGPL3, list);		
		}	
		if(isCheckedL15()){
			RemoveListElements(licenses.uncArtistic2, list);		
		}	
		if(isCheckedL16()){
			RemoveListElements(licenses.uncMPL2, list);		
		}	
		return list;		
	}
	
	
    Checkbox checkBox1 = new Checkbox("NO"); 	
    Checkbox checkBox2 = new Checkbox("MIT");
    Checkbox checkBox3 = new Checkbox("GPLv1");;     
    Checkbox checkBox4 = new Checkbox("GPLv2");    
    Checkbox checkBox5 = new Checkbox("GPLv3"); 
    Checkbox checkBox6 = new Checkbox("AGPL");
    Checkbox checkBox7 = new Checkbox("Apache1"); 
    Checkbox checkBox8 = new Checkbox("Apache2");
    Checkbox checkBox9 = new Checkbox("BSD4"); 
    Checkbox checkBox10 = new Checkbox("BSD3"); 
    Checkbox checkBox11 = new Checkbox("BSD2"); 
    Checkbox checkBox12 = new Checkbox("BSD1"); 
	
	
	
	/*
	 * Include the popularity ranking
	 * Popularity results according to experimental research (MSC-Thesis)
	 */
	/* TODO new order */
	public LinkedList<String> IncludePopularity(LinkedList<String> list){	
		LinkedList<String> result = new LinkedList<String>();			
		if(list.contains("MIT")){
			result.addLast("MIT");
		}
		if(list.contains("Apache2")){
			result.addLast("Apache2");
		}
		if(list.contains("BSD3")){
			result.addLast("BSD3");
		}
		if(list.contains("BSD2")){
			result.addLast("BSD2");
		}
		if(list.contains("GPL3")){
			result.addLast("GPL3");
		}
		if(list.contains("GPL2")){
			result.addLast("GPL2");
		}
		if(list.contains("LGPL3")){
			result.addLast("LGPL3");
		}		
		if(list.contains("GPL1")){
			result.addLast("GPL1");
		}
		if(list.contains("BSD1")){
			result.addLast("BSD1");
		}
		if(list.contains("Apache1")){
			result.addLast("Apache1");
		}
		if(list.contains("BSD4")){
			result.addLast("BSD4");
		}
		if(list.contains("MPL2")){
			result.addLast("MPL2");
		}
		if(list.contains("AGPL3")){
			result.addLast("AGPL3");
		}	
		if(list.contains("EPL1")){
			result.addLast("EPL1");
		}
		if(list.contains("Artistic2")){
			result.addLast("Artistic2");
		}
		if(list.contains("NO")){
			result.addLast("NO");
		}
		return result;	
	}
	
	
	/*
	 * Include the enforcement ranking
	 * Enforcement results according to literature research (MSC-Thesis)
	 */
	/* TODO logic */
	public LinkedList<String> IncludeEnforcement(LinkedList<String> list){
		LinkedList<String> result = new LinkedList<String>();
		if(list.contains("NO")){ 
			result.addLast("NO");
		}
		if(list.contains("GPL3")){ 
			result.addLast("GPL3");
		}
		if(list.contains("GPL2")){ 
			result.addLast("GPL2");
		}
		if(list.contains("LGPL3")){
			result.addLast("LGPL3");
		}
		if(list.contains("GPL1")){ 
			result.addLast("GPL1");
		}
		if(list.contains("AGPL3")){ 
			result.addLast("AGPL3");
		}
		if(list.contains("BSD4")){ 
			result.addLast("BSD4");
		}
		if(list.contains("BSD3")){ 
			result.addLast("BSD3");
		}
		if(list.contains("BSD1")){
			result.addLast("BSD1");
		}
		if(list.contains("BSD2")){ 
			result.addLast("BSD2");
		}
		if(list.contains("MPL2")){
			result.addLast("MPL2");
		}
		if(list.contains("Apache1")){ 
			result.addLast("Apache1");
		}
		if(list.contains("Apache2")){ 
			result.addLast("Apache2");
		}
		if(list.contains("MIT")){ 
			result.addLast("MIT");
		}
		if(list.contains("EPL1")){
			result.addLast("EPL1");
		}
		if(list.contains("Artistic2")){
			result.addLast("Artistic2");
		}
		return result;	
	}
	
	
	/*
	 * Include the popularity and enforcement ranking:
	 * currently: first criteria: enforcement, then popularity
	 */
	/* TODO new order */
	public LinkedList<String> IncludePopularityAndEnforcement(LinkedList<String> list){
		LinkedList<String> result = new LinkedList<String>();	
		if(list.contains("MIT")){
			result.addLast("MIT");
		}
		if(list.contains("Apache2")){
			result.addLast("Apache2");
		}
		if(list.contains("BSD3")){
			result.addLast("BSD3");
		}
		if(list.contains("BSD2")){
			result.addLast("BSD2");
		}
		if(list.contains("GPL3")){
			result.addLast("GPL3");
		}
		if(list.contains("GPL2")){
			result.addLast("GPL2");
		}
		if(list.contains("LGPL3")){
			result.addLast("LGPL3");
		}
		if(list.contains("AGPL3")){
			result.addLast("AGPL3");
		}	
		if(list.contains("GPL1")){
			result.addLast("GPL1");
		}
		if(list.contains("BSD1")){
			result.addLast("BSD1");
		}
		if(list.contains("BSD4")){
			result.addLast("BSD4");
		}
		if(list.contains("MPL2")){
			result.addLast("MPL2");
		}
		if(list.contains("Apache1")){
			result.addLast("Apache1");
		}
		if(list.contains("EPL1")){
			result.addLast("EPL1");
		}
		if(list.contains("Artistic2")){
			result.addLast("Artistic2");
		}
		if(list.contains("NO")){
			result.addLast("NO");
		}
		return result;
	}	
}
