package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDem {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "Pavitra");
		map.put(2, "Mukund");
		map.put(3, "Mantra");
		map.put(4, "Rashmi");
		map.put(5, "Komal");
		Set setData = map.entrySet();
		Iterator iter = setData.iterator();
		while (iter.hasNext()) {
			Map.Entry entryData = (Map.Entry) iter.next();
			System.out.println(entryData.getKey() + " : "
					+ entryData.getValue());
		}
	}
}
