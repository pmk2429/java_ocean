package encoding;

import java.util.HashMap;

public class CharacterMap {
	public static HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();

	public CharacterMap() {
		initializeMap();
	}

	public void initializeMap() {
		char[] largeAlphabets = new char[26];
		int j = 65;
		for (int i = 0; i < largeAlphabets.length; i++) {
			largeAlphabets[i] = (char) j;
			characterMap.put(largeAlphabets[i], j);
			j++;
		}
	}
}
