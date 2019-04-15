package com.sc.domain;

/**
 * The Enum ESize.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public enum ESize {
	
	/** The m5. */
	M5("5"),
	
	/** The m6. */
	M6("6"),
	
	/** The m7. */
	M7("7"),
	
	/** The m8. */
	M8("8"),
	
	/** The m9. */
	M9("9"),
	
	/** The m10. */
	M10("10"),
	
	/** The m11. */
	M11("11"),
	
	/** The m12. */
	M12("12"),
	
	/** The m13. */
	M13("13"),	
	
	/** The m14. */
	M14("14"),
	
	/** The m15. */
	M15("15");
	
	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new e size.
	 *
	 * @param description the description
	 */
	private ESize(String description) {
		this.description = description;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}	
}
