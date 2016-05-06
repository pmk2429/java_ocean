package numbers;

import java.net.InetAddress;

public class IPAddress {
	public static void main(String args[]) throws Exception {
		System.out.println(InetAddress.getLocalHost());
		System.out.println(InetAddress.getLoopbackAddress());
	}
}
