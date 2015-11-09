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
import com.dev.persistence.dao.SalesOrderDAO;
import com.dev.persistence.dao.SalesOrderImplDAO;
import com.dev.persistence.model.SalesOrder;

import junit.framework.TestCase;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class SalesOrderTest extends TestCase {
	
	Logger logger = LoggerFactory.getLogger(SalesOrderTest.class);

	private SalesOrderDAO salesOrderDao = new SalesOrderImplDAO();
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		salesOrderDao.beginTransaction();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		salesOrderDao.rollbackTransaction();
	}

	@Test
	public void testInsertSuccess() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);
		salesOrder.setSorTotalPrice(BigDecimal.ZERO);

		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		Long lngId = salesOrder.getSorId();
		salesOrder = salesOrderDao.findById(lngId);
		
		assertEquals(orderNum, salesOrder.getSorOrderNum());
	}
	
	public void testInsertError() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);

		try {
			salesOrderDao.save(salesOrder);
			HibernateUtil.getSession().flush();
			
			Assert.fail();
		} catch (PropertyValueException e) {
		}
		
	}
	
	public void testUpdateSuccess() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		String newOrderNum = "321";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);
		salesOrder.setSorTotalPrice(BigDecimal.ZERO);

		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		Long lngId = salesOrder.getSorId();
		salesOrder = salesOrderDao.findById(lngId);
		
		salesOrder.setSorOrderNum(newOrderNum);
		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		salesOrder = salesOrderDao.findById(lngId);
		
		assertEquals(newOrderNum, salesOrder.getSorOrderNum());
	}

	public void testUpdateError() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		String newOrderNum = "321";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);
		salesOrder.setSorTotalPrice(BigDecimal.ZERO);
		
		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		Long lngId = salesOrder.getSorId();
		salesOrder = salesOrderDao.findById(lngId);
		
		salesOrder.setSorOrderNum(newOrderNum);
		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		salesOrder = salesOrderDao.findById(lngId);
		
		assertNotSame(orderNum, salesOrder.getSorOrderNum());
	}

	public void testDeleteSuccess() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);
		salesOrder.setSorTotalPrice(BigDecimal.ZERO);
		
		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		Long lngId = salesOrder.getSorId();
		salesOrder = salesOrderDao.findById(lngId);
		
		salesOrderDao.delete(salesOrder);
		
		Assert.assertTrue(true);
	}

	public void testDeleteError() {
		Assert.fail("Not implemented yet");
	}

	public void testFindSuccess() {
		long lngCustId = System.currentTimeMillis();
		String orderNum = "123";
		
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSorCusId(lngCustId);
		salesOrder.setSorOrderNum(orderNum);
		salesOrder.setSorTotalPrice(BigDecimal.ZERO);
		
		salesOrderDao.save(salesOrder);
		
		HibernateUtil.getSession().flush();
		
		Long lngId = salesOrder.getSorId();
		salesOrder = salesOrderDao.findById(lngId);
		
		assertNotNull(salesOrder);
		
	}

	public void testFindError() {
		Long lngProduct = new Long(-1);
		
		SalesOrder Product = salesOrderDao.findById(lngProduct);
		
		assertNull(Product);
	}
}
