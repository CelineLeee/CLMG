package ds;

import java.lang.reflect.Array;

public class HashTable<Key extends Comparable<? super Key>, E> {
	private int M; // Size of the table
	private KVpair<Key, E>[] T; // Array of the elements

	@SuppressWarnings("unchecked") // Allow the generic array allocation
	public HashTable(int m) {
		M = m;
		T = (KVpair<Key, E>[]) Array.newInstance(KVpair.class, M);
		for (int i = 0; i < M; i++)
			T[i] = new KVpair<Key, E>();
	}

	/** Insert record r into T */
	public void hashInsert(Key k, E r) {
		// Fill in your codes

	}

	/** Search for the record with key k */
	public E hashSearch(Key k) {
		// Fill in your codes

	}

	/** Remove a record with key value k from the hash table */
	public E hashRemove(Key k) {
		// Fill in your codes

	}

	/** Change the open hashing to the closed hashing */
	public void changeToClosed(){
		// Fill in your codes

	}

	/** Print the entire elements with keys and values in order */
	public void hashPrint(){
		// Fill in your codes

	}

	/**
	 * If the key is an Integer, then use a simple mod function for the hash
	 * function. If the key is a String, then use folding.
	 */
	private int hash(Key k) {
		Object keyO = k;
		if (keyO.getClass() == Integer.class) {
			return Integer.parseInt(k.toString()) % M;
		} else {
			return k.hashCode() % M;
		}
	}


}

