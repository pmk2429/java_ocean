package strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueCharacters {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String inputString = input.nextLine();
    input.close();

    UniqueCharacters uniqueObj = new UniqueCharacters();
    Map<Character, Integer> mapUniqueChars = new HashMap<Character, Integer>();

    mapUniqueChars = uniqueObj.findUniqueCharacters(inputString);
    uniqueObj.printUniqueCharacters(mapUniqueChars);
  }

  @SuppressWarnings("unchecked")
  private void printUniqueCharacters(Map<Character, Integer> mapUniqueChars) {
    Set<?> setMap = mapUniqueChars.entrySet();
    Iterator<?> iter = setMap.iterator();
    while (iter.hasNext()) {
      Map.Entry<Character, Integer> entryMap = (Map.Entry<Character, Integer>) iter
              .next();
      if ((Integer) (entryMap.getValue()) == 1) {
        System.out.print(entryMap.getKey() + ", ");
      }
    }

    // OR

    // for (Map.Entry<Character, Integer> entry : mapUniqueChars.entrySet())
    // {
    // System.out.println(entry.getKey() + " : " + entry.getValue());
    // }
  }

  private Map<Character, Integer> findUniqueCharacters(String inputString) {
    Map<Character, Integer> mapUniqueChars = new HashMap<Character, Integer>();
    for (int i = 0; i < inputString.length(); i++) {
      if (mapUniqueChars.containsKey(inputString.charAt(i))) {
        mapUniqueChars.put(inputString.charAt(i),
                mapUniqueChars.get(inputString.charAt(i)) + 1);
      } else {
        mapUniqueChars.put(inputString.charAt(i), 1);
      }
    }
    return mapUniqueChars;
  }

}
