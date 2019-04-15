package com.sc.mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sc.dao.ISneakerDao;
import com.sc.domain.ESize;
import com.sc.domain.Sneaker;
import com.sc.domain.Store;
import com.sc.util.IdGenerator;

/**
 * The Class MockSneaker.
 * 
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public class MockSneaker implements ISneakerDao {

	/** The sneakers. */
	private List<Sneaker> sneakers;

	/** The available sneakers. */
	private List<Store> availableSneakers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sc.dao.ISneakerDao#findSneakers()
	 */
	public List<Sneaker> findSneakers() {
		defaultData();
		return sneakers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sc.dao.ISneakerDao#findAvailableSizes(com.sc.domain.Sneaker)
	 */
	@Override
	public List<Store> findAvailableSizes(final Sneaker sneaker) {
		availableSneakers = new ArrayList<>();
		fillStockData();
		return availableSneakers.stream().filter(o -> o.getSneaker().equals(sneaker.getId()))
				.collect(Collectors.<Store>toList());
		// Predicate<Store> bySneaker = store ->
		// store.getSneaker().compareTo(sneaker.getId()) == 0;
		// return
		// availableSneakers.stream().filter(bySneaker).collect(Collectors.<Store>toList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sc.dao.ISneakerDao#addSneaker(com.sc.domain.Sneaker)
	 */
	@Override
	public void addSneaker(Sneaker sneaker) {
		sneakers.add(sneaker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sc.dao.ISneakerDao#addToCart(com.sc.domain.Store)
	 */
	@Override
	public void addToCart(Store store) {
		availableSneakers.add(store);
	}

	@Override
	public Sneaker findById(UUID id) {
		defaultData();
		return sneakers.stream().filter(o -> o.getId().equals(id)).findFirst().get();
	}

	/**
	 * Default data.
	 */
	private void defaultData() {
		sneakers = new ArrayList<>();
		sneakers.add(new Sneaker(IdGenerator.getId("1"), "Nike", "Airforce1", BigDecimal.valueOf(67.8), "nike1.jpg",
				LocalDate.parse("2019-04-02")));
		sneakers.add(new Sneaker(IdGenerator.getId("2"), "Adidas", "Athletic Kicks", BigDecimal.valueOf(89.0),
				"adidas1.jpg", LocalDate.parse("2019-04-03")));
		sneakers.add(new Sneaker(IdGenerator.getId("3"), "Veja", "Plimsoll Sneakers", BigDecimal.valueOf(39.0),
				"veja1.jpg", LocalDate.parse("2019-04-04")));
		sneakers.add(new Sneaker(IdGenerator.getId("4"), "Vans", "High Top Basketball Sneakers",
				BigDecimal.valueOf(23.6), "vans.jpg", LocalDate.parse("2019-04-01")));
		sneakers.add(new Sneaker(IdGenerator.getId("5"), "Adidas", "Authentic Sneakers", BigDecimal.valueOf(59.5),
				"adidas2.jpg", LocalDate.parse("2019-04-05")));
		sneakers.add(new Sneaker(IdGenerator.getId("6"), "Nike", "Slip-On Sneakers", BigDecimal.valueOf(62.0),
				"nike2.jpg", LocalDate.parse("2018-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("7"), "Veja", "Leather Sneakers", BigDecimal.valueOf(52.0),
				"veja2.jpg", LocalDate.parse("2018-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("8"), "Tretorn", "Canvas Sneakers", BigDecimal.valueOf(46.0),
				"tretorn1.jpg", LocalDate.parse("2019-04-06")));
		sneakers.add(new Sneaker(IdGenerator.getId("9"), "Nike", "Textile Blend Sneakers", BigDecimal.valueOf(99.0),
				"nike3.jpg", LocalDate.parse("2019-03-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("10"), "Adidas", "Synthetic Sneakers", BigDecimal.valueOf(83.0),
				"adidas3.jpg", LocalDate.parse("2018-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("11"), "Cariuma", "Designer Sneaker", BigDecimal.valueOf(70.0),
				"cariuma1.jpg", LocalDate.parse("2019-04-07")));
		sneakers.add(new Sneaker(IdGenerator.getId("12"), "Nike", "Simple, with big soles", BigDecimal.valueOf(74.0),
				"nike4.jpg", LocalDate.parse("2019-02-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("13"), "Veja", "The 90s", BigDecimal.valueOf(98.0), "veja1.jpg",
				LocalDate.parse("2019-01-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("14"), "Nike", "CQP Racquet", BigDecimal.valueOf(101.0), "nike5.jpg",
				LocalDate.parse("2017-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("15"), "Vans", "Vans Classic Slip-On", BigDecimal.valueOf(60.0),
				"vans1.jpg", LocalDate.parse("2018-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("16"), "Converse", "Converse Chuck Taylor", BigDecimal.valueOf(22.0),
				"nike2.jpg", LocalDate.parse("2018-12-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("17"), "Nike", "Gucci Ace Watersnake", BigDecimal.valueOf(22.5),
				"nike6.jpg", LocalDate.parse("2018-04-09")));
		sneakers.add(new Sneaker(IdGenerator.getId("18"), "Saucony", "Trimmed Embroidered Leather",
				BigDecimal.valueOf(19.9), "saucony1.jpg", LocalDate.parse("2016-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("19"), "Nike", "Nike Air Max 98 SE Mesh", BigDecimal.valueOf(29.7),
				"nike2.jpg", LocalDate.parse("2019-04-11")));
		sneakers.add(new Sneaker(IdGenerator.getId("20"), "Saucony", "Snake-Effect Leather And Suede",
				BigDecimal.valueOf(42.0), "saucony2.jpg", LocalDate.parse("2019-04-10")));
		sneakers.add(new Sneaker(IdGenerator.getId("21"), "Tretron", "The Classic White Sneaker",
				BigDecimal.valueOf(27.8), "tretorn2.jpg", LocalDate.parse("2019-04-09")));
		sneakers.add(new Sneaker(IdGenerator.getId("22"), "Adidas", "The Statement Sneaker", BigDecimal.valueOf(22.0),
				"adidas4.jpg", LocalDate.parse("2019-04-08")));
	}

	/**
	 * Fill stock data.
	 */
	private void fillStockData() {
		availableSneakers.add(new Store(IdGenerator.getId("D1"), IdGenerator.getId("1"), ESize.M11, 66));
		availableSneakers.add(new Store(IdGenerator.getId("D2"), IdGenerator.getId("2"), ESize.M14, 11));
		availableSneakers.add(new Store(IdGenerator.getId("D3"), IdGenerator.getId("3"), ESize.M7, 320));
		availableSneakers.add(new Store(IdGenerator.getId("D4"), IdGenerator.getId("4"), ESize.M11, 65));
		availableSneakers.add(new Store(IdGenerator.getId("D5"), IdGenerator.getId("5"), ESize.M6, 205));
		availableSneakers.add(new Store(IdGenerator.getId("D6"), IdGenerator.getId("6"), ESize.M11, 106));
		availableSneakers.add(new Store(IdGenerator.getId("D7"), IdGenerator.getId("7"), ESize.M6, 74));
		availableSneakers.add(new Store(IdGenerator.getId("D8"), IdGenerator.getId("8"), ESize.M10, 36));
		availableSneakers.add(new Store(IdGenerator.getId("D9"), IdGenerator.getId("9"), ESize.M9, 41));
		availableSneakers.add(new Store(IdGenerator.getId("D10"), IdGenerator.getId("10"), ESize.M5, 82));
		availableSneakers.add(new Store(IdGenerator.getId("D11"), IdGenerator.getId("11"), ESize.M7, 38));
		availableSneakers.add(new Store(IdGenerator.getId("D12"), IdGenerator.getId("12"), ESize.M12, 37));
		availableSneakers.add(new Store(IdGenerator.getId("D13"), IdGenerator.getId("13"), ESize.M8, 45));
		availableSneakers.add(new Store(IdGenerator.getId("D14"), IdGenerator.getId("14"), ESize.M10, 64));
		availableSneakers.add(new Store(IdGenerator.getId("D15"), IdGenerator.getId("15"), ESize.M15, 3));
		availableSneakers.add(new Store(IdGenerator.getId("D16"), IdGenerator.getId("16"), ESize.M13, 11));
		availableSneakers.add(new Store(IdGenerator.getId("D17"), IdGenerator.getId("17"), ESize.M13, 75));
		availableSneakers.add(new Store(IdGenerator.getId("D18"), IdGenerator.getId("18"), ESize.M14, 85));
		availableSneakers.add(new Store(IdGenerator.getId("D19"), IdGenerator.getId("19"), ESize.M11, 36));
		availableSneakers.add(new Store(IdGenerator.getId("D20"), IdGenerator.getId("20"), ESize.M6, 35));
		availableSneakers.add(new Store(IdGenerator.getId("D21"), IdGenerator.getId("21"), ESize.M11, 63));
		availableSneakers.add(new Store(IdGenerator.getId("D22"), IdGenerator.getId("22"), ESize.M10, 42));

		availableSneakers.add(new Store(IdGenerator.getId("S1"), IdGenerator.getId("1"), ESize.M7, 12));
		availableSneakers.add(new Store(IdGenerator.getId("S2"), IdGenerator.getId("2"), ESize.M10, 96));
		availableSneakers.add(new Store(IdGenerator.getId("S3"), IdGenerator.getId("3"), ESize.M12, 45));
		availableSneakers.add(new Store(IdGenerator.getId("S4"), IdGenerator.getId("4"), ESize.M9, 21));
		availableSneakers.add(new Store(IdGenerator.getId("S5"), IdGenerator.getId("5"), ESize.M5, 8));
		availableSneakers.add(new Store(IdGenerator.getId("S6"), IdGenerator.getId("6"), ESize.M14, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S7"), IdGenerator.getId("7"), ESize.M8, 63));
		availableSneakers.add(new Store(IdGenerator.getId("S8"), IdGenerator.getId("8"), ESize.M7, 60));
		availableSneakers.add(new Store(IdGenerator.getId("S9"), IdGenerator.getId("9"), ESize.M8, 74));
		availableSneakers.add(new Store(IdGenerator.getId("S10"), IdGenerator.getId("22"), ESize.M9, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S11"), IdGenerator.getId("11"), ESize.M10, 10));
		availableSneakers.add(new Store(IdGenerator.getId("S12"), IdGenerator.getId("12"), ESize.M12, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S13"), IdGenerator.getId("13"), ESize.M13, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S14"), IdGenerator.getId("14"), ESize.M6, 65));
		availableSneakers.add(new Store(IdGenerator.getId("S15"), IdGenerator.getId("15"), ESize.M12, 48));
		availableSneakers.add(new Store(IdGenerator.getId("S16"), IdGenerator.getId("16"), ESize.M10, 52));
		availableSneakers.add(new Store(IdGenerator.getId("S17"), IdGenerator.getId("17"), ESize.M14, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S18"), IdGenerator.getId("18"), ESize.M15, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S19"), IdGenerator.getId("19"), ESize.M8, 102));
		availableSneakers.add(new Store(IdGenerator.getId("S20"), IdGenerator.getId("20"), ESize.M9, 7));
		availableSneakers.add(new Store(IdGenerator.getId("S21"), IdGenerator.getId("21"), ESize.M8, 30));
		availableSneakers.add(new Store(IdGenerator.getId("S23"), IdGenerator.getId("22"), ESize.M8, 20));
		availableSneakers.add(new Store(IdGenerator.getId("S24"), IdGenerator.getId("1"), ESize.M7, 12));
		availableSneakers.add(new Store(IdGenerator.getId("S25"), IdGenerator.getId("2"), ESize.M10, 96));
		availableSneakers.add(new Store(IdGenerator.getId("S26"), IdGenerator.getId("7"), ESize.M10, 52));
		availableSneakers.add(new Store(IdGenerator.getId("S27"), IdGenerator.getId("8"), ESize.M14, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S28"), IdGenerator.getId("9"), ESize.M15, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S29"), IdGenerator.getId("10"), ESize.M8, 102));
		availableSneakers.add(new Store(IdGenerator.getId("S30"), IdGenerator.getId("10"), ESize.M9, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S31"), IdGenerator.getId("11"), ESize.M10, 10));
		availableSneakers.add(new Store(IdGenerator.getId("S32"), IdGenerator.getId("12"), ESize.M12, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S33"), IdGenerator.getId("13"), ESize.M13, 32));
		availableSneakers.add(new Store(IdGenerator.getId("S34"), IdGenerator.getId("14"), ESize.M6, 65));
		availableSneakers.add(new Store(IdGenerator.getId("S35"), IdGenerator.getId("15"), ESize.M12, 48));
		availableSneakers.add(new Store(IdGenerator.getId("S36"), IdGenerator.getId("22"), ESize.M14, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S37"), IdGenerator.getId("22"), ESize.M8, 63));
		availableSneakers.add(new Store(IdGenerator.getId("S38"), IdGenerator.getId("8"), ESize.M7, 60));
		availableSneakers.add(new Store(IdGenerator.getId("S39"), IdGenerator.getId("9"), ESize.M8, 74));
		availableSneakers.add(new Store(IdGenerator.getId("S40"), IdGenerator.getId("2"), ESize.M9, 7));
		availableSneakers.add(new Store(IdGenerator.getId("S41"), IdGenerator.getId("3"), ESize.M8, 30));
		availableSneakers.add(new Store(IdGenerator.getId("S42"), IdGenerator.getId("22"), ESize.M8, 20));
		availableSneakers.add(new Store(IdGenerator.getId("S43"), IdGenerator.getId("1"), ESize.M15, 3));
		availableSneakers.add(new Store(IdGenerator.getId("S44"), IdGenerator.getId("2"), ESize.M13, 11));
		availableSneakers.add(new Store(IdGenerator.getId("S45"), IdGenerator.getId("3"), ESize.M13, 75));
		availableSneakers.add(new Store(IdGenerator.getId("S46"), IdGenerator.getId("4"), ESize.M14, 85));
		availableSneakers.add(new Store(IdGenerator.getId("S47"), IdGenerator.getId("5"), ESize.M11, 36));
		availableSneakers.add(new Store(IdGenerator.getId("S48"), IdGenerator.getId("6"), ESize.M6, 35));
		availableSneakers.add(new Store(IdGenerator.getId("S49"), IdGenerator.getId("1"), ESize.M11, 63));
		availableSneakers.add(new Store(IdGenerator.getId("S50"), IdGenerator.getId("1"), ESize.M10, 42));
		availableSneakers.add(new Store(IdGenerator.getId("S51"), IdGenerator.getId("3"), ESize.M12, 45));
		availableSneakers.add(new Store(IdGenerator.getId("S52"), IdGenerator.getId("4"), ESize.M9, 21));
		availableSneakers.add(new Store(IdGenerator.getId("S53"), IdGenerator.getId("5"), ESize.M5, 8));

	}

}
