package com.sc.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sc.domain.ESize;
import com.sc.domain.Sneaker;
import com.sc.domain.Store;
import com.sc.service.ISneakerQueryService;
import com.sc.util.IdGenerator;

/**
 * The Class SneakerView.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@Component
@Scope("session")
@Qualifier("sneakerView")
public class SneakerView {

	/** The sneakers. */
	private List<Sneaker> sneakers;
	
	/** The available sizes. */
	private List<Store> availableSizes;
	
	/** The stock view. */
	private boolean stockView;
	
	/** The selected sneaker. */
	private Sneaker selectedSneaker;
	
	/** The selected sizes. */
	private List<Store> selectedSizes;
	
	/** The my sneaker. */
	private Store mySneaker;
	
	/** The enable add to cart. */
	private boolean enableAddToCart;
	
	/** The cart. */
	private List<Store> cart;
	
	/** The cart view. */
	private boolean cartView;
	
	/** The selected qty. */
	private Integer selectedQty;
	
	/** The cart total price. */
	private BigDecimal cartTotalPrice;
	
	/** The enable change. */
	private boolean enableChange;

	/** The sneaker query service. */
	@Autowired
	private ISneakerQueryService sneakerQueryService;

	/**
	 * Inits the.
	 */
	@PostConstruct
	void init() {
		sneakers = sneakerQueryService.getSneakersList();
		availableSizes = new ArrayList<>();
		cart = new ArrayList<>();
	}

	/**
	 * Gets the sneakers.
	 *
	 * @return the sneakers
	 */
	public List<Sneaker> getSneakers() {
		return sneakers;
	}

	/**
	 * Gets the latest sneakers.
	 *
	 * @return the latest sneakers
	 */
	public List<Sneaker> getLatestSneakers() {
		return sneakerQueryService.getLatestSneakers();
	}

	/**
	 * All sizes.
	 *
	 * @return the list
	 */
	public List<Store> allSizes() {
		if (selectedSneaker != null && !availableSizes.isEmpty()) {
			List<Store> allSizes = new ArrayList<>();
			for (ESize size : ESize.values()) {
				if (sizeAvailable(size)) {
					allSizes.add(mySneaker);
				} else {
					allSizes.add(new Store(IdGenerator.getId(size.toString()), selectedSneaker.getId(), size,
							Integer.valueOf(0)));
				}
			}
			return allSizes;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * Size available.
	 *
	 * @param size the size
	 * @return true, if successful
	 */
	private boolean sizeAvailable(ESize size) {
		Predicate<Store> bySize = store -> store.getSize().compareTo(size) == 0;
		Optional<Store> stock = availableSizes.stream().filter(bySize).findFirst();
		if (stock.isPresent()) {
			setMySneaker(stock.get());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Find sneaker sizes.
	 *
	 * @param sneaker the sneaker
	 */
	public void findSneakerSizes(final Sneaker sneaker) {
		setSelectedSneaker(sneaker);
		setAvailableSizes(sneakerQueryService.getAvailableSizes(selectedSneaker));
		setStockView(true);
	}
	
	/**
	 * Enable select.
	 */
	public void enableSelect(){
		setEnableChange(true);
	}

	/**
	 * Go home.
	 */
	public void goHome() {
		setStockView(false);
		setCartView(false);
	}

	/**
	 * Go stock.
	 */
	public void goStock() {
		setStockView(true);
		setCartView(false);
	}

	/**
	 * Change quantity.
	 *
	 * @param item the item
	 */
	public void changeQuantity(Store item) {
		item.setQuantity(selectedQty);
		List<Store> cartObjs = new ArrayList<>();
		cart.stream().map(val -> {
			if (val.getId().equals(item.getId())) {
				val.setQuantity(selectedQty);
				return val;
			}
			return val;
		}).forEach(val -> cartObjs.add(val));
		setCart(cartObjs);
		computeTotalCart();
		setEnableChange(false);
	}

	/**
	 * Compute total cart.
	 */
	public void computeTotalCart() {
		BigDecimal total = BigDecimal.ZERO;
		for (Store st : cart) {
			if(st.getQuantity()==null){
				st.setQuantity(1);
			}
			Sneaker snkr = findSneaker(st.getSneaker());
			if (snkr != null) {
				total = total.add(snkr.getPrice().multiply(BigDecimal.valueOf(st.getQuantity())));
			}
		}
		setCartTotalPrice(total);
	}

	/**
	 * Adds the to cart.
	 */
	public void addToCart() {
		addMessage(String.valueOf(selectedSizes.size()) + " item added to Cart");
		if (!selectedSizes.isEmpty()) {
			for (Store item : selectedSizes) {
				item.setQuantity(1);
				cart.add(item);
			}
		}
		computeTotalCart();
	}

	/**
	 * Removes the.
	 *
	 * @param item the item
	 */
	public void remove(UUID item) {
		List<Store> filteredList = cart.stream().filter(i -> !i.getId().equals(item)).collect(Collectors.toList());
		setCart(filteredList);
		computeTotalCart();
	}

	/**
	 * Cart size.
	 *
	 * @return the string
	 */
	public String cartSize() {
		return String.valueOf(cart.size());
	}

	/**
	 * Display cart.
	 */
	public void displayCart() {
		setCartView(true);
		setStockView(false);
	}

	/**
	 * Find sneaker.
	 *
	 * @param id the id
	 * @return the sneaker
	 */
	public Sneaker findSneaker(UUID id) {
		Predicate<Sneaker> byId = store -> store.getId().compareTo(id) == 0;
		Optional<Sneaker> sneaker = sneakers.stream().filter(byId).findFirst();
		return sneaker.get();
	}

	/**
	 * Sets the sneakers.
	 *
	 * @param sneakers the new sneakers
	 */
	public void setSneakers(final List<Sneaker> sneakers) {
		this.sneakers = sneakers;
	}

	/**
	 * Gets the available sizes.
	 *
	 * @return the available sizes
	 */
	public List<Store> getAvailableSizes() {
		return availableSizes;
	}

	/**
	 * Sets the available sizes.
	 *
	 * @param availableSizes the new available sizes
	 */
	public void setAvailableSizes(final List<Store> availableSizes) {
		this.availableSizes = availableSizes;
	}

	/**
	 * Checks if is stock view.
	 *
	 * @return true, if is stock view
	 */
	public boolean isStockView() {
		return stockView;
	}

	/**
	 * Sets the stock view.
	 *
	 * @param stockView the new stock view
	 */
	public void setStockView(boolean stockView) {
		this.stockView = stockView;
	}

	/**
	 * Gets the selected sneaker.
	 *
	 * @return the selected sneaker
	 */
	public Sneaker getSelectedSneaker() {
		return selectedSneaker;
	}

	/**
	 * Sets the selected sneaker.
	 *
	 * @param selectedSneaker the new selected sneaker
	 */
	public void setSelectedSneaker(Sneaker selectedSneaker) {
		this.selectedSneaker = selectedSneaker;
	}

	/**
	 * Gets the selected sizes.
	 *
	 * @return the selected sizes
	 */
	public List<Store> getSelectedSizes() {
		return selectedSizes;
	}

	/**
	 * Sets the selected sizes.
	 *
	 * @param selectedSizes the new selected sizes
	 */
	public void setSelectedSizes(List<Store> selectedSizes) {
		this.selectedSizes = selectedSizes;
	}

	/**
	 * Checks if is enable add to cart.
	 *
	 * @return true, if is enable add to cart
	 */
	public boolean isEnableAddToCart() {
		return enableAddToCart;
	}

	/**
	 * Sets the enable add to cart.
	 *
	 * @param enableAddToCart the new enable add to cart
	 */
	public void setEnableAddToCart(boolean enableAddToCart) {
		this.enableAddToCart = enableAddToCart;
	}

	/**
	 * Gets the my sneaker.
	 *
	 * @return the my sneaker
	 */
	public Store getMySneaker() {
		return mySneaker;
	}

	/**
	 * Sets the my sneaker.
	 *
	 * @param mySneaker the new my sneaker
	 */
	public void setMySneaker(Store mySneaker) {
		this.mySneaker = mySneaker;
	}

	/**
	 * Gets the cart.
	 *
	 * @return the cart
	 */
	public List<Store> getCart() {		
		return cart;
	}

	/**
	 * Sets the cart.
	 *
	 * @param cart the new cart
	 */
	public void setCart(List<Store> cart) {
		this.cart = cart;
	}

	/**
	 * Checks if is cart view.
	 *
	 * @return true, if is cart view
	 */
	public boolean isCartView() {
		return cartView;
	}

	/**
	 * Sets the cart view.
	 *
	 * @param cartView the new cart view
	 */
	public void setCartView(boolean cartView) {
		this.cartView = cartView;
	}

	/**
	 * Gets the selected qty.
	 *
	 * @return the selected qty
	 */
	public Integer getSelectedQty() {
		return selectedQty;
	}

	/**
	 * Sets the selected qty.
	 *
	 * @param selectedQty the new selected qty
	 */
	public void setSelectedQty(Integer selectedQty) {
		this.selectedQty = selectedQty;
	}

	/**
	 * Gets the cart total price.
	 *
	 * @return the cart total price
	 */
	public BigDecimal getCartTotalPrice() {		
		return cartTotalPrice;
	}

	/**
	 * Sets the cart total price.
	 *
	 * @param cartTotalPrice the new cart total price
	 */
	public void setCartTotalPrice(BigDecimal cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	/**
	 * Checks if is enable change.
	 *
	 * @return true, if is enable change
	 */
	public boolean isEnableChange() {
		return enableChange;
	}

	/**
	 * Sets the enable change.
	 *
	 * @param enableChange the new enable change
	 */
	public void setEnableChange(boolean enableChange) {
		this.enableChange = enableChange;
	}

	/**
	 * Adds the message.
	 *
	 * @param summary the summary
	 */
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
