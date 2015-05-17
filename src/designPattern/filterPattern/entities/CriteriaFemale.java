package designPattern.filterPattern.entities;

import java.util.ArrayList;
import java.util.List;

import designPattern.filterPattern.interfaces.Criteria;

public class CriteriaFemale implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {

		List<Person> malePersons = new ArrayList<Person>();

		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("MALE")) {
				malePersons.add(person);
			}
		}
		return malePersons;
	}

}
