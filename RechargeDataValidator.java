package com.capgemini.paymobbill.service;

import com.capgemini.paymobbill.bean.RechargeDetails;

/*	@author Deepak Yadav (0137397)
 * 
 * created on : Nov 11, 2017
 * 
 * Class Name: RechargeClient
 * 
 * Description : It is the class which contains methods that validate the data entered by the user.
 * 				 
 *  
 */

public class RechargeDataValidator {
	
	
	//********************************************validateDetails method *************************************************//
	/*
	 * This method checks for all validation and then return true or false.
	 * this method checks that every validation is true or not. 
	 */
	public boolean validateDetails(RechargeDetails rechargeDetailObject)
	{
		if(validateRechargeType(rechargeDetailObject.getRechargeType()) && validateMobileNo(rechargeDetailObject.getMobileNo()) && validateCurrentOperator(rechargeDetailObject.getCurrentOperator()) && validateAmount(rechargeDetailObject.getAmount()) && validateTransactionID(rechargeDetailObject.getTransactionID()))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	//***************************************************validateRechargeType method**************************************//
	/*
	 * this method is used to validate if the recharges type  entered correctly or not.
	 * This first converts the user input string into lowercase and then compare with the predefined recharges type.
	 * 
	 */
	public boolean validateRechargeType(String  rechargeType)
	{
		//converting into lowercase to compare
		
		if(rechargeType.toLowerCase().equals("prepaid") || rechargeType.toLowerCase().equals("postpaid"))
		{
			return true;
		}
		else 
		{
			System.out.println("!!!Please Check the Recharge type you have entered !!!");
			return false;
		}
		
	}
	
	//**************************************************validateCurrentOperator method****************************************//
	/*
	 * this method is used to validate if the operator type  entered correctly or not.
	 * This first converts the user input string into lowercase and then compare with the predefined operator type.
	 * 
	 */
	public boolean validateCurrentOperator(String currentOperator)
	{
		String operator = currentOperator.toLowerCase();
		if(operator.equals("airtel") ||  operator.equals("bsnl") || operator.equals("docomo")|| operator.equals("jio"))
		{
			return true;
		}
		else
		{
			//System.out.println("!!!Please Check the operator you have entered !!!");
			return false;
		}
	}
	//**************************************************validateMobileNo method****************************************//
		/*
		 * this method is used to validate if the Mobile number entered correctly or not.
		 * This use regular expression for validating mobile number.
		 */
	
	public boolean validateMobileNo(String mobileNo) 
	{
		
		if(mobileNo.matches("[789]{1}[0-9]{9}"))                                   //regular expression for validating mobile number.
		{
			return true;
		}
		else
		{
			System.out.println("!!!Please Check the number you have entered !!!");
			return false;
		}
	}
	
	//**************************************************validateAmount method****************************************//
			/*
			 * this method is used to validate the amount by bounding its value to min 2 digit and max 4 digit.
			 * 
			 */
	
	public boolean validateAmount(Double amount)
	{
		try {
			if(amount>=10 && amount<=9999)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(NumberFormatException numberFormat) 
		{
			System.out.println("Please Enter the correct amount(10-9999)!!!!");
			return false;
		}
	}
	
	//**************************************************validateTransactionID method****************************************//
	/*
	 * this method is used to validate the Transaction Id.
	 * 
	 */
	
	
	public boolean validateTransactionID(int  transactionId) 
	{
		String transactionID= Integer.toString(transactionId);
		
		if(transactionID.matches("[0-9]{4}")) 
		{
			return true;
		}
		else 
		{
			System.out.println("!!!Please Check the Transaction id you have entered !!!");
			return false;
		}
		
	}

}