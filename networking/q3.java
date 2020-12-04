//q3. write a java program to display ip addresses of 3 dns server names
package networking;
import java.net.*;
public class q3 {
	public static void main(String[] args) {
		try {
			InetAddress add1=InetAddress.getByName("www.yahoo.com");
			InetAddress add2=InetAddress.getByName("www.github.com");
			InetAddress add3=InetAddress.getByName("www.microsoft.com");
			System.out.println(add1);
			System.out.println(add2);
			System.out.println(add3);
		}catch(UnknownHostException e) {
			System.out.println(e);
		}
	}
}