package com.capgemini.paymobbill.bean;

import java.io.Serializable;

@SuppressWarnings("serial")

/*	@author Deepak Yadav (0137397)
 * 
 * created on : Nov 11, 2017
 * 
 * Class Name: RechargeDetails
 * 
 * Description : It is the class which contains  variables used in the application. 
 * 				
 *  
 */

public class RechargeDetails implements Serializable{
		
 String rechargeType;
 String currentOperator;
 String mobileNo;
 double amount;
 int transactionID;

 //********************************************************Constructor method **********************************************//
 public RechargeDetails(String rechargeType, String currentOperator, String mobileNo, double amount,int transactionID) {
			super();
			this.rechargeType = rechargeType;
			this.currentOperator = currentOperator;
			this.mobileNo = mobileNo;
			this.amount = amount;
			this.transactionID = transactionID;
		}
 
 public RechargeDetails() 
	{
		this.transactionID = (int)(Math.random()*9000)+1000;                 //to generate random transactionID 
	}
	


 //*******************************************************getter and setter methods ******************************************//
 
  
  public String getRechargeType() 
   {
     return rechargeType;
   }
	
   public void setRechargeType(String rechargeType) 
   {
     this.rechargeType = rechargeType;
   }

   public String getCurrentOperator() 
   {
	 return currentOperator;
	
   }

   public void setCurrentOperator(String currentOperator) 
   {
	 this.currentOperator = currentOperator;
   }
	
   public String getMobileNo() 
   {
	 return mobileNo;
   }

   public void setMobileNo(String mobileNo) 
   {
	 this.mobileNo = mobileNo;
   }

   public double getAmount() 
   {
	 return amount;
   }
	
   public void setAmount(double amount) 
   {
	 this.amount = amount;
   }

   public int getTransactionID() 
   {
	 return transactionID;
   }

 
//********************************************************Overriding toString method ***************************************************************//
 		@Override
		public String toString() {
			return "RechargeDetails [rechargeType=" + rechargeType + ", currentOperator=" + currentOperator + ", mobileNo="
					+ mobileNo + ", amount=" + amount + ", transactionID=" + transactionID + "]";
		}
		
	}

