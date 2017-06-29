/**
 * This is the Spring Boot POC using Spring boot, Spring Secure, and AWS 
 */
package testbasic.service;

import java.util.ArrayList;
import java.util.List;

//import paymentdata.model.Transaction;

/**
 * @author x3fm
 * Stub data source for testing.
 */
/**

public class TestBasicServiceStub {
	
	public static List<Transaction> getListTransaction() {
		List<Transaction> result = new ArrayList<>();
		result.add(getTransaction(1));
		return result;
	}

	private static Transaction getTransaction(int i) {
		int transRole = 0;
		Transaction result = new Transaction();
		switch (transRole) {
			case 1: 
				result.setActionReason("1");
				result.setAmountTransaction("12.01");
				break;
			case 2: 
				result.setActionReason("2");
				result.setAmountTransaction("22.01");
				break;
			default:
				result.setActionReason("default");
				result.setAmountTransaction("default");
				break;
		}
		return result;
	}

}
*/
