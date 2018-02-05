package com.capgemini.paymobbill.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.paymobbill.bean.RechargeDetails;
import com.capgemini.paymobbill.service.RechargeDataValidator;

public class validateTest {
	
	RechargeDetails rechargeDetailObject = new RechargeDetails("prepaid","airtel","9910256808",100,1234);
	RechargeDataValidator dataValidatorObject = new RechargeDataValidator();


	@Test
	public final void testValidateRechargeType() 
	{
		assertEquals(true, dataValidatorObject.validateRechargeType(rechargeDetailObject.getRechargeType()));
		assertEquals(true, dataValidatorObject.validateRechargeType("prepaid"));
		assertEquals(true, dataValidatorObject.validateRechargeType("PREPAID"));
		assertEquals(true, dataValidatorObject.validateRechargeType("Postpaid"));
		assertEquals(true, dataValidatorObject.validateRechargeType("POSTpaid"));
		
		assertEquals(false, dataValidatorObject.validateRechargeType("prpaid"));
		assertEquals(false, dataValidatorObject.validateRechargeType("pstpaid"));

	}

	@Test
	public void testValidateDetails() {
		
		assertEquals(true, dataValidatorObject.validateDetails(rechargeDetailObject));
		
	}

	@Test
	public void testValidateCurrentOperator() 
	{
		assertEquals(true, dataValidatorObject.validateCurrentOperator("AIRTEL"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("AIRTEL"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("AiRtel"));
		
		assertEquals(false, dataValidatorObject.validateCurrentOperator("airtl"));
		assertEquals(false, dataValidatorObject.validateCurrentOperator("airtl"));
		assertEquals(false, dataValidatorObject.validateCurrentOperator("Aitel"));
		
		assertEquals(true, dataValidatorObject.validateCurrentOperator("docomo"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("DOCOMO"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("DoCoMo"));
		
		assertEquals(false, dataValidatorObject.validateCurrentOperator("dcomo"));
		assertEquals(false, dataValidatorObject.validateCurrentOperator("Dcom"));
		
		
		assertEquals(true, dataValidatorObject.validateCurrentOperator("bsnl"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("BSNL"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("bSnL"));
		
		assertEquals(false, dataValidatorObject.validateCurrentOperator("bsl"));
		assertEquals(false, dataValidatorObject.validateCurrentOperator("Bnsl"));
		
		
		assertEquals(true, dataValidatorObject.validateCurrentOperator("jio"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("JIO"));
		assertEquals(true, dataValidatorObject.validateCurrentOperator("JiO"));
		
		assertEquals(false, dataValidatorObject.validateCurrentOperator("GIo"));
		assertEquals(false, dataValidatorObject.validateCurrentOperator("gio"));
		
	}

	@Test
	public void testValidateMobileNo() {
		
		assertEquals(false, dataValidatorObject.validateMobileNo("90987") );
		assertEquals(false, dataValidatorObject.validateMobileNo("687770987") );
		assertEquals(false, dataValidatorObject.validateMobileNo("9098888887000") );
		assertEquals(false, dataValidatorObject.validateMobileNo("212120987") );
		
		assertEquals(true, dataValidatorObject.validateMobileNo("9910256808") );
		assertEquals(true, dataValidatorObject.validateMobileNo("8910256808") );
	}

	@Test
	public void testValidateAmount() {
		assertEquals(true, dataValidatorObject.validateAmount(100d) );
		assertEquals(false, dataValidatorObject.validateAmount(0d) );
		assertEquals(false, dataValidatorObject.validateAmount(99990d) );
		
	}

	@Test
	public void testValidateTransactionID() {
		assertEquals(true, dataValidatorObject.validateTransactionID(1023) );
		assertEquals(true, dataValidatorObject.validateTransactionID(9999) );
		assertEquals(false, dataValidatorObject.validateTransactionID(103) );
		
		
	}

}
