package interfaces;

/**
 * Created by Pavitra on 10/19/2015.
 */
public class InterfaceTypeResolution {
    public static void main(String[] args) {
        new Activity().start();
    }
}

interface Entity {
    String getName(Entity entity);
}

class User implements Entity {

    @Override
    public String getName(Entity entity) {
        User user = (User) entity;
        user.printUser();
        return "User";
    }

    public void printUser() {
        System.out.println("Works like makkhan");
    }
}

class Tick implements Entity {

    @Override
    public String getName(Entity entity) {
        Tick tick = (Tick) entity;
        tick.printTick();
        return "User";
    }

    public void printTick() {
        System.out.println("TICK baba jay ho");
    }
}


class Activity {
    public void start() {
        Entity entity = new User();
        entity.getName(entity);
        entity = new Tick();
        entity.getName(entity);
    }
}
