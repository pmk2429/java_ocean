package generics.boundedgenerics;

public class Animal extends LivingBeing {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		return true;
	}

	String family;
	String category;

	public Animal(String name, int age, int weight, String family,
			String category) {
		super(name, age, weight);
		this.family = family;
		this.category = category;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void printType() {
		System.out.println("I am an Animal having name: " + this.getName()
				+ " and Family: " + this.getFamily() + " and categorized as: "
				+ this.getCategory());
		System.out.println("Age: " + this.getAge() + " Weight: "
				+ this.getWeight());
	}

	public boolean compareObj(Animal obj1, Animal obj2) {
		return obj1.equals(obj2);
	}
}
