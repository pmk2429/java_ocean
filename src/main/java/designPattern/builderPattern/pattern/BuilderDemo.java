package designPattern.builderPattern.pattern;


public class BuilderDemo {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("Pavitra", "SF", "CA").isEmployed(true).isFemale
                (false).isHomeOwner(false).middleName("Mukund").streetAddress("150 Font Blvd").createPerson();

        System.out.println(person.toString());
    }
}
