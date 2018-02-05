package com.capgemini.paymobbill.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.capgemini.paymobbill.bean.RechargeDetails;

/*	@author Deepak Yadav (0137397)
 * 
 * created on : Nov 11, 2017
 * 
 * Class Name: RechargeFileHelper
 * 
 * Description : It is the class which contains method for file handling.
 * 				 
 *  
 */

public class RechargeFileHelper

{
	//*****************************************************addRechargeDetails method**************************************//
	/*
	 * This method is used to write data on file.
	 * 
	 */
	
	
	public void addRechargeDetails(RechargeDetails rechargeDetails) 
	{
		try 
		{
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/Users/deepayad/Desktop/Deepak_Yadav_137397_mpt_mod_3/database/MobileBill.obj"));	
			objectOutputStream.writeObject(rechargeDetails);  						//writing on file
			objectOutputStream.close();												//closing the outputsream.
		} 
		catch (FileNotFoundException fileNotFound) 
		{
			System.out.println("Please save the application on desktop and run again.");  //if file not found alert message.
			System.out.println(fileNotFound.getMessage());
		} 
		catch (IOException ioException) 
		{
			System.out.println("Please save the application on desktop and run again.");
			System.out.println(ioException.getMessage());
		}
		
	}

	//*****************************************************addRechargeDetails method**************************************//
		/*
		 * This method is used to read data from file.
		 * 
		 */
		
	public void displayRechargeDetails() {
		try {
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/Users/deepayad/Desktop/Deepak_Yadav_137397_mpt_mod_3/database/MobileBill.obj"));
				try 
				{
					System.out.println(objectInputStream.readObject());
					objectInputStream.close();
				}
				catch (ClassNotFoundException classNotfound) 
				{
					System.out.println(classNotfound.getMessage());			
				}
			}
		    catch (FileNotFoundException fileNotFound)
		    {
		    	System.out.println(fileNotFound.getMessage());
		    } 
		    catch (IOException ioException) 
		    {
			   System.out.println(ioException.getMessage());
		    }
		
	}

	
}
