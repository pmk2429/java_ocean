 package frequencyDistribution;

import java.util.HashMap;

public class CharactersList {

	Character characterRead;
	public static HashMap<Character, Integer> charactersMap = new HashMap<Character, Integer>();

	/*
	 * public char[] charactersMap = {'a','b','c','d','e','f','g','h',
	 * 'i','j','k','l','m','n','o','p','q','r', 's','t','u','v','w','x','y','z',
	 * //Special characters. '.',',','!','@','#','$','%','^','&',
	 * '*','(',')','"',';','=','-','+','/','\\'};
	 */
	public int frequencyCount;

	public CharactersList() {
		frequencyCount = 0;
	}

	public void initcharactersMap() {
		
		charactersMap.put('a', 1);
		charactersMap.put('b', 2);
		charactersMap.put('c', 3);
		charactersMap.put('d', 4);
		charactersMap.put('e', 5);
		charactersMap.put('f', 6);
		charactersMap.put('g', 7);
		charactersMap.put('h', 8);
		charactersMap.put('i', 9);
		charactersMap.put('j', 10);
		charactersMap.put('k', 11);
		charactersMap.put('l', 12);
		charactersMap.put('m', 13);
		charactersMap.put('n', 14);
		charactersMap.put('o', 15);
		charactersMap.put('p', 16);
		charactersMap.put('q', 17);
		charactersMap.put('r', 18);
		charactersMap.put('s', 19);
		charactersMap.put('t', 20);
		charactersMap.put('u', 21);
		charactersMap.put('v', 22);
		charactersMap.put('w', 23);
		charactersMap.put('x', 24);
		charactersMap.put('y', 25);
		charactersMap.put('z', 26);
		charactersMap.put('.', 27);
		charactersMap.put(',', 28);
		charactersMap.put('?', 29);
		charactersMap.put('!', 30);
		charactersMap.put('@', 31);
		charactersMap.put('#', 32);
		charactersMap.put('$', 33);
		charactersMap.put('%', 34);
		charactersMap.put('^', 35);
		charactersMap.put('&', 36);
		charactersMap.put('*', 37);
		charactersMap.put('(', 38);
		charactersMap.put(')', 39);
		charactersMap.put('-', 40);
		charactersMap.put('+', 41);
		charactersMap.put('=', 42);
		charactersMap.put('/', 43);
		charactersMap.put('\\', 44);
		charactersMap.put('[', 45);
		charactersMap.put(']', 46);
		charactersMap.put('{', 47);
		charactersMap.put('}', 48);
		charactersMap.put(':', 49);
		charactersMap.put(';', 50);
		charactersMap.put('[', 51);
		charactersMap.put('"', 52);
		charactersMap.put(' ', 53);
		charactersMap.put('A', 54);
		charactersMap.put('B', 55);
		charactersMap.put('C', 56);
		charactersMap.put('D', 57);
		charactersMap.put('E', 58);
		charactersMap.put('F', 59);
		charactersMap.put('G', 60);
		charactersMap.put('H', 61);
		charactersMap.put('I', 62);
		charactersMap.put('J', 63);
		charactersMap.put('K', 64);
		charactersMap.put('L', 65);
		charactersMap.put('M', 66);
		charactersMap.put('N', 67);
		charactersMap.put('O', 68);
		charactersMap.put('P', 69);
		charactersMap.put('Q', 70);
		charactersMap.put('R', 71);
		charactersMap.put('S', 72);
		charactersMap.put('T', 73);
		charactersMap.put('U', 74);
		charactersMap.put('V', 75);
		charactersMap.put('W', 76);
		charactersMap.put('X', 77);
		charactersMap.put('Y', 78);
		charactersMap.put('Z', 79);
		
	}

	public CharactersList(Character characterRead, int frequencyCount) {
		this.characterRead = characterRead;
		this.frequencyCount = frequencyCount;
	}

	//get the frequency count
	public int getFrequencyCount() {
		return frequencyCount;
	}
	//set the frequency count
	public void setFrequencyCount(int frequencyCount) {
		this.frequencyCount = frequencyCount;
	}
	
	//get the character read
	public Character getCharacterRead() {
		return characterRead;
	}
	//set the character read.
	public void setCharacterRead(Character characterRead) {
		this.characterRead = characterRead;
	}
	
	
	public HashMap<Character, Integer> getcharactersMap() {
		return charactersMap;
	}
	public void setcharactersMap(HashMap<Character, Integer> charactersMap) {
		this.charactersMap = charactersMap;
	}

}
