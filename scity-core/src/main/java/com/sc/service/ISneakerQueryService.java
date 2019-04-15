package com.sc.service;

import java.util.List;
import java.util.UUID;

import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Interface ISneakerQueryService.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public interface ISneakerQueryService {
	
	/** The name. */
	public final String NAME = "SneakerQueryService";
	
	/**
	 * Gets the sneakers list.
	 *
	 * @return the sneakers list
	 */
	public List<Sneaker> getSneakersList();
	
	/**
	 * Gets the latest sneakers.
	 *
	 * @return the latest sneakers
	 */
	public List<Sneaker> getLatestSneakers();
	
	/**
	 * Find sneaker by id.
	 *
	 * @param id the id
	 * @return the sneaker
	 */
	public Sneaker findSneakerById(UUID id);
	
	/**
	 * Gets the available sizes.
	 *
	 * @param sneaker the sneaker
	 * @return the available sizes
	 */
	public List<Store> getAvailableSizes(final Sneaker sneaker);
}
