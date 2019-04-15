package com.sc.service;

import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Interface ISneakerService.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public interface ISneakerService {
	
	/** The name. */
	public final String NAME = "SneakerService";
	
	/**
	 * Adds the to cart.
	 *
	 * @param store the store
	 */
	public void addToCart(Store store);
	
	/**
	 * Adds the sneaker.
	 *
	 * @param sneaker the sneaker
	 */
	public void addSneaker(Sneaker sneaker);
}
