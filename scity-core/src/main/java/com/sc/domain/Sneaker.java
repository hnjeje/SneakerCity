package com.sc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * The Class Sneaker.
 * 
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public class Sneaker implements Comparable<Sneaker> {
	/** The Constant serialVersionUID. */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	/** The id. */
	private UUID id;
	/** The brand name. */
	private String brandName;

	/** The model. */
	private String model;

	/** The price. */
	private BigDecimal price;

	/** The picture. */
	private String pictureUrl;

	/** The release. */
	private LocalDate release;

	/**
	 * Instantiates a new sneaker.
	 */
	public Sneaker() {
		super();
	}

	/**
	 * Instantiates a new sneaker.
	 *
	 * @param id
	 *            the id
	 * @param brandName
	 *            the brand name
	 * @param model
	 *            the model
	 * @param price
	 *            the price
	 * @param pictureUrl
	 *            the picture url
	 * @param release
	 *            the release
	 */
	public Sneaker(UUID id, String brandName, String model, BigDecimal price, String pictureUrl, LocalDate release) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.model = model;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.release = release;
	}

	/**
	 * Gets the brand name.
	 *
	 * @return the brand name
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name.
	 *
	 * @param brandName
	 *            the new brand name
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Gets the picture url.
	 *
	 * @return the picture url
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * Sets the picture url.
	 *
	 * @param pictureUrl
	 *            the new picture url
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	/**
	 * Gets the release.
	 *
	 * @return the release
	 */
	public LocalDate getRelease() {
		return release;
	}

	/**
	 * Sets the release.
	 *
	 * @param release
	 *            the new release
	 */
	public void setRelease(LocalDate release) {
		this.release = release;
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
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sneaker [id=" + id + ", brandName=" + brandName + ", model=" + model + ", price=" + price
				+ ", pictureUrl=" + pictureUrl + ", release=" + release + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Sneaker o) {
		return this.release.compareTo(o.release);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else if (this == obj) {
			return true;
		}
		Sneaker other = (Sneaker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
