package bitManipulation.bitset;

import java.util.BitSet;

public class BitSetDemo {
	public static void main(String[] args) {
		BitSet bitset = new BitSet(8);
		bitset.set(0);
		bitset.set(1);
		bitset.set(2);
		bitset.set(3);
		bitset.set(4);
		bitset.set(5);
		bitset.set(8);

		System.out.println(bitset);

		int lastindex = bitset.nextClearBit(0);
		System.out.println(lastindex);
	}
}
