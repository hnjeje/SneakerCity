package com.sc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.dao.ISneakerDao;
import com.sc.domain.Sneaker;
import com.sc.domain.Store;

/**
 * The Class SneakerQueryService.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@Service(ISneakerQueryService.NAME)
public class SneakerQueryService implements ISneakerQueryService {

	/** The sneaker dao. */
	@Autowired
	private ISneakerDao sneakerDao;

	/* (non-Javadoc)
	 * @see com.sc.service.ISneakerQueryService#getSneakersList()
	 */
	public List<Sneaker> getSneakersList() {
		try {
			return sneakerDao.findSneakers();
		} catch (Exception ex) {
			return Collections.emptyList();
		}
	}

	/* (non-Javadoc)
	 * @see com.sc.service.ISneakerQueryService#getLatestSneakers()
	 */
	@Override
	public List<Sneaker> getLatestSneakers() {
		try {
			List<Sneaker> allSneakers = sneakerDao.findSneakers();
			Comparator<Sneaker> c = (s1, s2) -> s1.getRelease().compareTo(s2.getRelease());
			allSneakers.sort(c);

			List<Sneaker> latest = new ArrayList<>();
			int counter=allSneakers.size();
			while(counter>allSneakers.size()-10){	
				latest.add(allSneakers.get(counter-1));
				counter--;
			}
			return latest;

		} catch (Exception ex) {
			return Collections.emptyList();
		}
	}

	/* (non-Javadoc)
	 * @see com.sc.service.ISneakerQueryService#getAvailableSizes(com.sc.domain.Sneaker)
	 */
	@Override
	public List<Store> getAvailableSizes(final Sneaker sneaker) {
		try{
			return sneakerDao.findAvailableSizes(sneaker);			
		}catch(Exception ex){
			return Collections.emptyList();
		}
	}

	@Override
	public Sneaker findSneakerById(UUID id) {
		try{
			return sneakerDao.findById(id);			
		}catch(Exception ex){
			//let's return a null
			return null;
		}
	}

}
