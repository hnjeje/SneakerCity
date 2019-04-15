package com.sc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.ISneakerDao;
import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Class SneakerService.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@Service(ISneakerService.NAME)
public class SneakerService implements ISneakerService {

	/** The sneaker dao. */
	@Autowired
	private ISneakerDao sneakerDao;

	/* (non-Javadoc)
	 * @see com.sc.service.ISneakerService#addToCart(com.sc.domain.Store)
	 */
	@Override
	public void addToCart(Store store) {
		try {
			sneakerDao.addToCart(store);
		} catch (Exception ex) {
			//no code here
		}

	}

	/* (non-Javadoc)
	 * @see com.sc.service.ISneakerService#addSneaker(com.sc.domain.Sneaker)
	 */
	@Override
	public void addSneaker(Sneaker sneaker) {
		sneakerDao.addSneaker(sneaker);
	}

}
