package com.sc.domain;

import java.util.UUID;

/**
 * The Class Store.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public class Store {
	
	/** The id. */
	private UUID id;
	
	/** The sneaker. */
	private UUID sneaker;
	
	/** The size. */
	private ESize size;
	
	/** The quantity. */
	private Integer quantity;	
		
	

	/**
	 * Instantiates a new store.
	 *
	 * @param id the id
	 * @param sneaker the sneaker
	 * @param size the size
	 * @param quantity the quantity
	 */
	public Store(UUID id, UUID sneaker, ESize size, Integer quantity) {
		super();
		this.id = id;
		this.sneaker = sneaker;
		this.size = size;
		this.quantity = quantity;
	}

	/**
	 * Sets the sneaker.
	 *
	 * @param sneaker the new sneaker
	 */
	public void setSneaker(UUID sneaker) {
		this.sneaker = sneaker;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public ESize getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(ESize size) {
		this.size = size;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the sneaker.
	 *
	 * @return the sneaker
	 */
	public UUID getSneaker() {
		return sneaker;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
}
