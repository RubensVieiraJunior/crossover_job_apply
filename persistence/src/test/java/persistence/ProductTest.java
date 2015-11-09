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
import com.dev.persistence.dao.ProductDAO;
import com.dev.persistence.dao.ProductImplDAO;
import com.dev.persistence.model.Product;

import junit.framework.TestCase;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class ProductTest extends TestCase {
	
	Logger logger = LoggerFactory.getLogger(ProductTest.class);

	private ProductDAO productDao = new ProductImplDAO();
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		productDao.beginTransaction();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		productDao.rollbackTransaction();
	}

	@Test
	public void testInsertSuccess() {
		String name = "Desc1";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdPrice(BigDecimal.ZERO);
		product.setPrdQuantity(1);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdId();
		product = productDao.findById(lngProduct);
		
		assertEquals(name, product.getPrdDescription());
	}
	
	public void testInsertError() {
		String name = "Desc1";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdQuantity(1);

		try {
			productDao.save(product);
			HibernateUtil.getSession().flush();
			
			Assert.fail();
		} catch (PropertyValueException e) {
		}
		
	}
	
	public void testUpdateSuccess() {
		String name = "Desc1";
		String newName = "Product2";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdPrice(BigDecimal.ZERO);
		product.setPrdQuantity(1);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdId();
		product = productDao.findById(lngProduct);
		
		product.setPrdDescription(newName);
		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		product = productDao.findById(lngProduct);
		
		assertEquals(newName, product.getPrdDescription());
	}

	public void testUpdateError() {
		String name = "Desc1";
		String newName = "Product2";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdPrice(BigDecimal.ZERO);
		product.setPrdQuantity(1);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdId();
		product = productDao.findById(lngProduct);
		
		product.setPrdDescription(newName);
		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		product = productDao.findById(lngProduct);
		
		assertNotSame(name, product.getPrdDescription());
	}

	public void testDeleteSuccess() {
		String name = "Desc1";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdPrice(BigDecimal.ZERO);
		product.setPrdQuantity(1);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdId();
		product = productDao.findById(lngProduct);
		
		productDao.delete(product);
		
		Assert.assertTrue(true);
	}

	public void testDeleteError() {
		Assert.fail("Not implemented yet");
	}

	public void testFindSuccess() {
		String name = "Desc1";
		
		Product product = new Product();
		product.setPrdCode("Prd1" + System.currentTimeMillis());
		product.setPrdDescription(name);
		product.setPrdPrice(new BigDecimal("29.00"));
		product.setPrdQuantity(52);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdId();
		product = productDao.findById(lngProduct);
		
		assertNotNull(product);
		
	}

	public void testFindError() {
		Long lngProduct = new Long(-1);
		
		Product product = productDao.findById(lngProduct);
		
		assertNull(product);
	}
}
