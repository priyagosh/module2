package com.capgemini.paymobbill.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.capgemini.paymobbill.bean.RechargeDetails;
import com.capgemini.paymobbill.service.RechargeDataValidator;
import com.capgemini.paymobbill.service.RechargeFileHelper;

public class filehelperTest {

	RechargeDetails rechargeDetailObject = new RechargeDetails("prepaid","airtel","9910256808",100,1234);
	RechargeDataValidator dataValidatorObject = new RechargeDataValidator();

	RechargeFileHelper rechaargeFileHelperObject = new RechargeFileHelper();
	
	 @Rule
	    public ExpectedException thrown = ExpectedException.none();
	 
	 @Rule
	    public TemporaryFolder folder = new TemporaryFolder();
	@Test
	public final void testAddRechargeDetails() {
		
		  try {
			File file = folder.newFile("someTestFile.obj");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  rechaargeFileHelperObject.addRechargeDetails(rechargeDetailObject);
		   thrown.expect(IOException.class);
		   
	        thrown.expectMessage("Please save the application on desktop and run again.");
		
	
		
	}

	@Test
	public final void testDisplayRechargeDetails() {
	
	}

}
