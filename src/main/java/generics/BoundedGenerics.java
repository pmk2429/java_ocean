package generics;

public class BoundedGenerics {

    public static void main(String[] args) {

        HumanBeing humansObj = new HumanBeing("Pavitra", 23, 100, "Kansara", 5.15);
        LivingGenerics<HumanBeing> humansGenericObj = new LivingGenerics<HumanBeing>(humansObj);
        humansObj = new HumanBeing("Mantra", 25, 90, "Kansara", 5.9);
        LivingGenerics<HumanBeing> humansGenericObj1 = new LivingGenerics<HumanBeing>(humansObj);
        humansGenericObj.printObj();
        humansGenericObj1.printObj();

        // String lastName = humansGenericObj.getObj().getLastName();
        // System.out.println("Last name of Human: " + lastName);
        System.out.println("\n");

        Animal animalObj = new Animal("Lion", 12, 550, "Felidae", "Carnivores");
        LivingGenerics<Animal> animalGenericObj = new LivingGenerics<Animal>(
            animalObj);
        animalObj = new Animal("Cat", 8, 50, "Felidae", "Herbivores");
        LivingGenerics<Animal> animalGenericObj1 = new LivingGenerics<Animal>(
            animalObj);
        animalObj = new Animal("Tiger", 6, 85, "Felidae", "Carnivores");
        LivingGenerics<Animal> animalGenericObj2 = new LivingGenerics<Animal>(
            animalObj);
        animalGenericObj.printObj();
        animalGenericObj1.printObj();
        animalGenericObj2.printObj();

        System.out.println("\n");
        boolean compareHumans = humansGenericObj.compareObj(
            humansGenericObj.getObj(), humansGenericObj1.getObj());
        System.out.println("Mantra and Pavitra have same height: "
            + compareHumans);

        boolean compareAnimals = animalGenericObj.compareObj(
            animalGenericObj.getObj(), animalGenericObj2.getObj());
        System.out.println("Tiger and Lion are equal: " + compareAnimals);

        boolean compareAnimals1 = animalGenericObj.compareObj(
            animalGenericObj1.getObj(), animalGenericObj2.getObj());
        System.out.println("Cat and Lion are equal: " + compareAnimals1);

    }
}

class LivingGenerics<T extends LivingBeing> {
    public T obj;

    public LivingGenerics(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void printObj() {
        this.obj.printType();
    }

    public boolean compareObj(T obj1, T obj2) {
        return obj1.equals(obj2);
    }
}
