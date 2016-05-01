package object;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * Created by Pavitra on 4/29/2016.
 */
public class ObjectComparison {
    static Observation obs1, obs2;

    public static void main(String[] args) {
        obs1 = new Observation("American", "indiana", "onCloud", 3);

        Observation obs3 = SerializationUtils.clone(obs1);


        System.out.println("Equal?:" + obs3.equals(obs1));
        System.out.println("Obs3:" + obs3.toString());
        System.out.println("Obs1:" + obs1.toString());

        if (obs3.equals(obs1)) {
            System.out.println("equal");

        } else {
            System.out.println("different");
            System.out.println(obs3.hashCode());
            System.out.println(obs1.hashCode());
        }
    }
}

class Observation implements Serializable {
    String name;
    String species, imageUrl;
    int num_of_ticks;

    public Observation(String name, String species, String imageUrl, int num_of_ticks) {
        this.name = name;
        this.species = species;
        this.imageUrl = imageUrl;
        this.num_of_ticks = num_of_ticks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNum_of_ticks() {
        return num_of_ticks;
    }

    public void setNum_of_ticks(int num_of_ticks) {
        this.num_of_ticks = num_of_ticks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observation)) return false;

        Observation that = (Observation) o;

        if (getNum_of_ticks() != that.getNum_of_ticks()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSpecies() != null ? !getSpecies().equals(that.getSpecies()) : that.getSpecies() != null) return false;
        return getImageUrl() != null ? getImageUrl().equals(that.getImageUrl()) : that.getImageUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSpecies() != null ? getSpecies().hashCode() : 0);
        result = 31 * result + (getImageUrl() != null ? getImageUrl().hashCode() : 0);
        result = 31 * result + getNum_of_ticks();
        return result;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", num_of_ticks=" + num_of_ticks +
                '}';
    }
}
