//q2. write a java program to display ip addresses of the  dns server name or web server  names
package networking;
import  java.net.*;
public class q2 {

	public static void main(String[] args) {
		try {
			InetAddress add[] = InetAddress.getAllByName("www.google.com");
			for(int i=0; i<add.length; i++) {
				System.out.println(add[i]);
			}
		}catch(UnknownHostException e) {
			System.out.println(e);
		}
	}
}
