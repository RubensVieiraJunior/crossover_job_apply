/**
 * 
 */
package persistence;

import java.math.BigDecimal;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.persistence.HibernateUtil;
import com.dev.persistence.ProductDAO;
import com.dev.persistence.ProductImplDAO;
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
		String name = "Product1";
		
		Product product = new Product();
		product.setPrdDescription(name);
		product.setPrdPrice(BigDecimal.ZERO);
		product.setPrdQuantity(1);

		productDao.save(product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = product.getPrdCode();
		product = productDao.findById(lngProduct);
		
		assertEquals(name, product.getPrdDescription());
	}
	
	public void testInsertError() {
		String name = "Product1";
		
		Product product = new Product();
		product.setPrdDescription(name);
		product.setPrdQuantity(1);

		try {
			productDao.save(product);
			HibernateUtil.getSession().flush();
			
			Assert.fail();
		} catch (ConstraintViolationException e) {
		}
		
	}
	
	public void testUpdateSuccess() {
		String name = "Product1";
		String newName = "Product2";
		
		Product Product = new Product();
		Product.setPrdDescription(name);
		Product.setPrdPrice(BigDecimal.ZERO);
		Product.setPrdQuantity(1);

		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = Product.getPrdCode();
		Product = productDao.findById(lngProduct);
		
		Product.setPrdDescription(newName);
		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Product = productDao.findById(lngProduct);
		
		assertEquals(newName, Product.getPrdDescription());
	}

	public void testUpdateError() {
		String name = "Product1";
		String newName = "Product2";
		
		Product Product = new Product();
		Product.setPrdDescription(name);
		Product.setPrdPrice(BigDecimal.ZERO);
		Product.setPrdQuantity(1);

		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = Product.getPrdCode();
		Product = productDao.findById(lngProduct);
		
		Product.setPrdDescription(newName);
		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Product = productDao.findById(lngProduct);
		
		assertNotSame(name, Product.getPrdDescription());
	}

	public void testDeleteSuccess() {
		String name = "Product1";
		
		Product Product = new Product();
		Product.setPrdDescription(name);
		Product.setPrdPrice(BigDecimal.ZERO);
		Product.setPrdQuantity(1);

		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = Product.getPrdCode();
		Product = productDao.findById(lngProduct);
		
		productDao.delete(Product);
		
		Assert.assertTrue(true);
	}

	public void testDeleteError() {
		Assert.fail("Not implemented yet");
	}

	public void testFindSuccess() {
		String name = "Product1";
		
		Product Product = new Product();
		Product.setPrdDescription(name);
		Product.setPrdPrice(BigDecimal.ZERO);
		Product.setPrdQuantity(1);

		productDao.save(Product);
		
		HibernateUtil.getSession().flush();
		
		Long lngProduct = Product.getPrdCode();
		Product = productDao.findById(lngProduct);
		
		assertNotNull(Product);
		
	}

	public void testFindError() {
		Long lngProduct = new Long(-1);
		
		Product Product = productDao.findById(lngProduct);
		
		assertNull(Product);
	}
}
