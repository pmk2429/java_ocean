package designPattern.filterPattern.interfaces;

import java.util.List;

import designPattern.filterPattern.entities.Person;

public interface Criteria {
	public List<Person> meetCriteria(List<Person> persons);
}
