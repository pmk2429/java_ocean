package designPattern.filterPattern.entities;

import java.util.ArrayList;
import java.util.List;

import designPattern.filterPattern.interfaces.Criteria;

public class CriteriaMale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<Person>();

		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("FEMALE")) {
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}

}
