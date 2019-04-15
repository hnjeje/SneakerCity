package com.sneaker.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.sc.domain.Sneaker;
import com.sc.service.ISneakerQueryService;
import com.sc.util.IdGenerator;

/**
 * The Class TestSneakerService.
 * 
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/application-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })

public final class TestSneakerService {

	/** The sneaker query service. */
	@Autowired
	private ISneakerQueryService sneakerQueryService;

	/**
	 * Test find ten latest sneakers.
	 */
	@Test
	public void testFindTenLatestSneakers() {
		assertEquals("Checking size of List", 10, sneakerQueryService.getLatestSneakers().size());
	}

	@Test
	public void testFindAllSneakers() {
		assertEquals("Checking size of List", 22, sneakerQueryService.getSneakersList().size());
	}

	@Test
	public void testFindSneakerById() {
		Sneaker result = sneakerQueryService.findSneakerById(IdGenerator.getId("1"));
		Assert.assertTrue(result.getModel().equals("Airforce1"));
	}

	@Test(expected = AssertionError.class)
	public void testFindSneakerByIdNegative() {
		sneakerQueryService.findSneakerById(IdGenerator.getId("rrr"));
		org.junit.Assert.fail();
	}
	
}
