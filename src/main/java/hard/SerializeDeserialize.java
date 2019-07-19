package hard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserialize {

  private static Person deserialize(String personStr) {
    // deserialize the object
    try {
      byte[] serializedBytes = personStr.getBytes();
      ByteArrayInputStream bi = new ByteArrayInputStream(serializedBytes);
      ObjectInputStream si = new ObjectInputStream(bi);
      return (Person) si.readObject();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  private static String serialize(Person person) {
    // serialize the object
    try {
      ByteArrayOutputStream bo = new ByteArrayOutputStream();
      ObjectOutputStream so = new ObjectOutputStream(bo);
      so.writeObject(person);
      so.flush();
      return so.toString();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public static void main(String[] args) {
    Person pmk = new Person(24, "Pavitra");
    String serializedPMK = serialize(pmk);
    System.out.println(serializedPMK);
    Person deserializedPMK = deserialize(serializedPMK);
    System.out.println(deserializedPMK.toString());

    Person kp = new Person(7, "Komal");
  }
}

class Person {
  int age;
  String name;

  public Person() {
  }

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return "age=" + age + ", name='" + name;
  }
}
