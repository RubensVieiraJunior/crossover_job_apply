/**
 * 
 */
package persistence;

import java.math.BigDecimal;

import org.hibernate.PropertyValueException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.persistence.HibernateUtil;
import com.dev.persistence.dao.CustomerDAO;
import com.dev.persistence.dao.CustomerImplDAO;
import com.dev.persistence.model.Customer;

import junit.framework.TestCase;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class CustomerTest extends TestCase {
	
	Logger logger = LoggerFactory.getLogger(CustomerTest.class);

	private CustomerDAO customerDao = new CustomerImplDAO();
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		customerDao.beginTransaction();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		customerDao.rollbackTransaction();
	}

	@Test
	public void testInsertSuccess() {
		String name = "Name1";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCreditLimit(BigDecimal.ZERO);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		Long lngCustomer = customer.getCusId();
		customer = customerDao.findById(lngCustomer);
		
		assertEquals(name, customer.getCusName());
	}
	
	public void testInsertError() {
		String name = "Name1";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		try {
			customerDao.save(customer);
			HibernateUtil.getSession().flush();
			
			Assert.fail();
		} catch (PropertyValueException e) {
		}
		
	}
	
	public void testUpdateSuccess() {
		String name = "Name1";
		String newName = "Customer2";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCreditLimit(BigDecimal.ZERO);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		Long lngCustomer = customer.getCusId();
		customer = customerDao.findById(lngCustomer);
		
		customer.setCusName(newName);
		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		customer = customerDao.findById(lngCustomer);
		
		assertEquals(newName, customer.getCusName());
	}

	public void testUpdateError() {
		String name = "Name1";
		String newName = "Customer2";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCreditLimit(BigDecimal.ZERO);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		Long lngCustomer = customer.getCusId();
		customer = customerDao.findById(lngCustomer);
		
		customer.setCusName(newName);
		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		customer = customerDao.findById(lngCustomer);
		
		assertNotSame(name, customer.getCusName());
	}
	
	public void testDeleteSuccess() {
		String name = "Name1";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCreditLimit(BigDecimal.ZERO);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		Long lngCustomer = customer.getCusId();
		customer = customerDao.findById(lngCustomer);
		
		customerDao.delete(customer);
		
		Assert.assertTrue(true);
	}

	public void testDeleteError() {
		Assert.fail("Not implemented yet");
	}

	public void testFindSuccess() {
		String name = "Name1";
		
		Customer customer = new Customer();
		customer.setCusCode("Cus1" + System.currentTimeMillis());
		customer.setCusName(name);
		customer.setCusCreditLimit(BigDecimal.ZERO);
		customer.setCusCurrentCredit(BigDecimal.ZERO);

		customerDao.save(customer);
		
		HibernateUtil.getSession().flush();
		
		Long lngCustomer = customer.getCusId();
		customer = customerDao.findById(lngCustomer);
		
		assertNotNull(customer);
		
	}

	public void testFindError() {
		Long lngCustomer = new Long(-1);
		
		Customer customer = customerDao.findById(lngCustomer);
		
		assertNull(customer);
	}
}
