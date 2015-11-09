/**
 * 
 */
package webservice;

import java.util.Map;

import com.dev.webservice.BackEnd;
import com.google.gson.Gson;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class BackEndTest extends TestCase {

	public void testSave() {
		String jsonObject = "{\"currentCredit\":\"0\",\"address\":\"asdf\",\"name\":\"asdf\",\"creditLimit\":\"0.00\",\"phone2\":\"456\",\"code\":\"123\",\"phone1\":\"987\"}";
		
		BackEnd back = new BackEnd();
		try {
			String strReturn = back.save(jsonObject, BackEnd.TYPE_CUSTOMER);
			
			Assert.assertEquals(jsonObject, strReturn);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void testReadRecordByCode() {
		String code = "123";
		
		BackEnd back = new BackEnd();
		String strEntity = back.readRecordByCode(code, BackEnd.TYPE_CUSTOMER);
		
		Gson gson = new Gson();
		Map mapObject = gson.fromJson(strEntity, Map.class);
		Assert.assertEquals(code, mapObject.get("cusCode"));
	}
	
	public void testDelete() {
		
		String code = "123";
		BackEnd back = new BackEnd();
		boolean bolDeleted;
		try {
			bolDeleted = back.deleteRecordByCode(code, BackEnd.TYPE_CUSTOMER);
			
			Assert.assertTrue(bolDeleted);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	public void testListAll() {
		BackEnd back = new BackEnd();
		String customers = back.listCurrentRecords(BackEnd.TYPE_CUSTOMER);
		System.out.println("Customers:" + customers);
	}
}
