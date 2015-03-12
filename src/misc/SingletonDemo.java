package misc;

/**
 * The Singleton's purpose is to control object creation, limiting the number of
 * objects to one only. Since there is only one Singleton instance, any instance
 * fields of a Singleton will occur only once per class, just like static
 * fields. Singletons often control access to resources such as database
 * connections or sockets.
 * 
 * For example, if you have a license for only one connection for your database
 * or your JDBC driver has trouble with multithreading, the Singleton makes
 * sure that only one connection is made or that only one thread can access the
 * connection at a time.
 * 
 * 
 * @author Pavitra
 * 
 */

public class SingletonDemo {

	/**
	 * The SingletonDemo class maintains a static reference to the lone
	 * singleton instance and returns that reference from the static
	 * getInstance() method.
	 * 
	 * Here SingletonDemo class employs a technique known as lazy instantiation
	 * to create the singleton; as a result, the singleton instance is not
	 * created until the getInstance() method is called for the first time. This
	 * technique ensures that singleton instances are created only when needed.
	 */
	private static SingletonDemo single = null;

	protected SingletonDemo() {
	}

	public static SingletonDemo getInstance() {
		if (single == null) {
			single = new SingletonDemo();
		}
		return single;
	}

	protected void demoMethod() {
		System.out.println("Singleton " + "method");
	}

	public static void main(String[] args) {
		SingletonDemo singleObj = SingletonDemo.getInstance();
		singleObj.demoMethod();
	}
}
