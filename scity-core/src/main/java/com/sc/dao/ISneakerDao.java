package com.sc.dao;

import java.util.List;
import java.util.UUID;

import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Interface ISneakerDao.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public interface ISneakerDao {
	
	/**
	 * Find sneakers.
	 *
	 * @return the list
	 */
	public List<Sneaker> findSneakers();	
	
	/**
	 * Adds the sneaker.
	 *
	 * @param sneaker the sneaker
	 */
	public void addSneaker(Sneaker sneaker);
	
	/**
	 * Adds the to cart.
	 *
	 * @param store the store
	 */
	public void addToCart(Store store);
	
	/**
	 * Find available sizes.
	 *
	 * @param sneaker the sneaker
	 * @return the list
	 */
	public List<Store> findAvailableSizes(final Sneaker sneaker);
	
	/**
	 * Find sneaker by id.
	 *
	 * @param id the id
	 * @return the sneaker
	 */
	public Sneaker findById(final UUID id);
}
