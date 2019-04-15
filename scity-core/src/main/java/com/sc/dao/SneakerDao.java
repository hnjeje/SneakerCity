package com.sc.dao;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Class SneakerDao.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@Repository
public class SneakerDao implements ISneakerDao{

	/* (non-Javadoc)
	 * @see com.sc.dao.ISneakerDao#findSneakers()
	 */
	public List<Sneaker> findSneakers() {
		/*****!!!!!NOT IMPLEMENTED HERE !!!!! RETURNS EMPTY ************/
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see com.sc.dao.ISneakerDao#findAvailableSizes(com.sc.domain.Sneaker)
	 */
	@Override
	public List<Store> findAvailableSizes(final Sneaker sneaker) {
		/*****!!!!!NOT IMPLEMENTED HERE !!!!! RETURNS EMPTY ************/	
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see com.sc.dao.ISneakerDao#addSneaker(com.sc.domain.Sneaker)
	 */
	@Override
	public void addSneaker(Sneaker sneaker) {
		/*****!!!!!NOT IMPLEMENTED HERE !!!!! RETURNS EMPTY ************/
		
	}

	/* (non-Javadoc)
	 * @see com.sc.dao.ISneakerDao#addToCart(com.sc.domain.Store)
	 */
	@Override
	public void addToCart(Store store) {
		/*****!!!!!NOT IMPLEMENTED HERE !!!!! RETURNS EMPTY ************/	
		
	}

	@Override
	public Sneaker findById(UUID id) {
		/*****!!!!!NOT IMPLEMENTED HERE !!!!! RETURNS EMPTY ************/	
		return null;
	}
	

}
