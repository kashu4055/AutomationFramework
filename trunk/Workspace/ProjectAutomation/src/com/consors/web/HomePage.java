package com.consors.web;

import java.util.Dictionary;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.amdocs.asap.*;

public class HomePage {
	
	
	private Reporting Reporter;
	private WebDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon;
	
	public String lnkCurrentAccount = "partiallinktext:=Girokonto";
	public String webbtnOpenCheckingAccount = "partiallinktext:=Girokonto er�ffnen";
    
	//Define the constructor
	//Define the constructor
    public HomePage(WebDriver GDriver,HashMap<String, String> GDictionary, HashMap<String, String> GEnvironment,Reporting GReporter)
	{
		Reporter = GReporter;
		driver = GDriver;
		Dictionary = GDictionary;
		Environment = GEnvironment;
		objCommon = new CommonFunctions(driver, Reporter);
	}	
	
	
	public String getTitle()
	{
		return driver.getTitle();		
	}
	
	//*****************************************************************************************
    //*    Name        	: clickCurrentAccount
    //*    Description 	: This function Click Link Current Account
    //*    Author       : Bharat Joshi
    //*    Input Params : None
    //*    Return Values: None
    //*****************************************************************************************
	public boolean clickCurrentAccount()
	{             
		//Click on link Current Account
		if (objCommon.fGuiClick(lnkCurrentAccount)==false)
	    {
	       	return false;
	    }
		else
		{				
			Reporter.fnWriteToHtmlOutput("Click Link","Click Link : Current Account", "Click Link done Successfully", "Pass");
			
		}
		return true;
	}
	
	//*****************************************************************************************
    //*    Name        	: clickOpenCheckingAccount
    //*    Description 	: This function Click Open Checking Account
    //*    Author       : Bharat Joshi
    //*    Input Params : None
    //*    Return Values: None
    //*****************************************************************************************
	public  CheckingAccountEntry clickOpenCheckingAccount()
	{             
		//Click on link Current Account
		 if (objCommon.fGuiClick(webbtnOpenCheckingAccount)==false)
	        {
	        	return null;
	       	}
		 
		return  new CheckingAccountEntry(driver, Dictionary,Environment,Reporter);
	}
	
	
}
