package com.capgemini.paymobbill.ui;

import java.util.Scanner;

import com.capgemini.paymobbill.bean.RechargeDetails;
import com.capgemini.paymobbill.exception.InvalidNumberException;
import com.capgemini.paymobbill.service.RechargeDataValidator;
import com.capgemini.paymobbill.service.RechargeFileHelper;

/*	@author Deepak Yadav (0137397)
 * 
 * created on : Nov 11, 2017
 * 
 * Class Name: RechargeClient
 * 
 * Please save the application on desktop for file handling.
 * 
 * Description : It is the class which contains main method.
 * 				 displayMenu contain UI for user.
 * 				 
 *  
 */

public class RechargeClient {
	
		Scanner input = new Scanner(System.in);               //Input is used to accept user's entered value using console.
		
		
		/*
		 * Creating objects of different class used.
		 */
		RechargeDetails rechargeDetailObject =new RechargeDetails();
		
		RechargeDataValidator  dataValidatorObject =new RechargeDataValidator();
		
		RechargeFileHelper  fileHelperObject  = new RechargeFileHelper();
		
		
		//********************************************************Main Method*************************************//
		
		public static void main(String[] args) {
		
			RechargeClient rechargeClient = new RechargeClient();
			rechargeClient.displayMenu();
		}
		
		//*****************************************************displayMenu**************************************//
		/*
		 * This method is used to display different menu to the user and accept user's response from console.
		 * 
		 */
		
		public void displayMenu()
		{
			System.out.println("************************************WELCOME TO PayMobBill***************************");
			System.out.println("1.Make a Recharge ");
			System.out.println("2.Display Recharge Details ");
			System.out.println("3.Exit ");
			int option=Integer.parseInt(input.nextLine());
			switch(option)
			{
			case 1:
				mobileRecharge();
				displayMenu();
				break;
			case 2:
				readDetails();
				displayMenu();
				break;
			case 3:
				    System.exit(1); 
				    break;
			default:
				System.out.println("Enter the correct choice");
				displayMenu();
				break;
			}
		}
		
		//***************************************************details method**************************************//
		/*
		 * This method is used to read the data from file.
		 * 
		 */
		private void readDetails() 
		{
			fileHelperObject.displayRechargeDetails();
			
		}
		
		//**********************************************mobileRecharge method*****************************************//
		/*
		 *This method is used for transaction of the Recharges.
		 * 
		 */
		
		private void mobileRecharge() 
		{
			try {	
					System.out.println("Select Recharge Type (Prepaid/Postpaid)");
					String type=input.nextLine();
					rechargeDetailObject.setRechargeType(type);                                                 	  //Using setter to store values
					
					System.out.println("Enter Mobile No.");
					String mobileNo=input.nextLine();
					rechargeDetailObject.setMobileNo(mobileNo);												 	  //Using setter to store values
					
					System.out.println("Select Current Operator (Airtel/Docomo/BSNL/Jio)");
					String currentOperator=input.nextLine();
					rechargeDetailObject.setCurrentOperator(currentOperator);									  //Using setter to store values
					
					System.out.println("Enter Amount (Rs)");
					double amount=Math.round(Double.parseDouble(input.nextLine()) * 100D) / 100D;
					rechargeDetailObject.setAmount(amount);														   //Using setter to store values
				
					if(dataValidatorObject.validateDetails(rechargeDetailObject)) 
					{
						System.out.println("Successful Recharge. Transaction ID: "+rechargeDetailObject.getTransactionID());
						fileHelperObject.addRechargeDetails(rechargeDetailObject);
					}
					else
						{
							System.out.println("Failed to Recharge.");
							throw new InvalidNumberException();            //Exception Raised if number entered is incorrect
						}
						
					                                            
			}
			
			catch(InvalidNumberException number) 
			{
				System.out.println("!!!Please Check the number you have entered !!!");
			}
			
		}

	}

