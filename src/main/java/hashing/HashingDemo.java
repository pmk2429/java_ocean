package hashing;

/**
 * Created by Pavitra on 12/3/2015.
 */
public class HashingDemo {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashingDemo)) return false;

        HashingDemo that = (HashingDemo) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static void main(String[] args) {

    }
}
