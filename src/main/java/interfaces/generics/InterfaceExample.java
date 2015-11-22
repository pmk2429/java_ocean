package interfaces.generics;

/**
 * Created by Pavitra on 11/16/2015.
 */
public class InterfaceExample {
    public static void main(String[] args) {
        EntityDao userDao = new UserDao();
        DbHelper dbHelper = new DbHelper(userDao);
        User user = (User) dbHelper.get("user");
        System.out.println(user.toString());
    }
}

interface EntityDao {
    <T extends Entity> T get(String entityName);
}

class TickDao implements EntityDao {

    @Override
    public Tick get(String entityName) {
        Tick tick = new Tick("American Dog Tick");
        return tick;
    }
}

class UserDao implements EntityDao {

    @Override
    public User get(String entityName) {
        User user = new User("PMK");
        return user;
    }
}

class DbHelper {
    private EntityDao entityDao;
    private Entity entity;

    public DbHelper(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    public Entity get(String name) {
        return this.entityDao.get(name);
    }

}

interface Entity {
    String getName();
}

class Tick implements Entity {

    String name;

    public Tick() {
    }

    public Tick(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Tick";
    }

    @Override
    public String toString() {
        return "Tick{" +
                "name='" + name + '\'' +
                '}';
    }
}

class User implements Entity {

    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "User";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
