package com.sc.util;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The Class IdGenerator.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
public final class IdGenerator {

	/** The ids. */
	private static Map<String, UUID> ids = new HashMap<>();

	/**
	 * Gets the id.
	 *
	 * @param key
	 *            the key
	 * @return the id
	 */
	public static UUID getId(final String key) {

		if (key == null || key.isEmpty()) {
			throw new RuntimeException("The key canot be null");
		}

		UUID uuid = ids.get(key);

		if (uuid == null) {
			uuid = UUID.nameUUIDFromBytes(key.getBytes());
			ids.put(key, uuid);
		}

		return uuid;

	}

	/**
	 * Instantiates a new id generator.
	 */
	private IdGenerator() {
	}

	/**
	 * Gets the byte id.
	 *
	 * @param key
	 *            the key
	 * @return the byte id
	 */
	public static byte[] getByteId(final String key) {

		if (key == null || key.isEmpty()) {
			throw new RuntimeException("The key canot be null");
		}

		UUID uuid = ids.get(key);

		if (uuid == null) {
			uuid = UUID.nameUUIDFromBytes(key.getBytes());
			ids.put(key, uuid);
		}

		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());

		return bb.array();
	}
}

