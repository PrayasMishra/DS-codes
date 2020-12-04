/*	q4. display host ip of a website (ans)host soa.ac.in
	q8. show DNS Lookup for a Website soa.ac.in (ans)nslookup soa.ac.in
	q5)ans)traceroute google.com
	q7)ans)ping google.com
*/
package networking;
import java.net.*;
public class ServerName {
	public static void main(String[] args) {
		try {
			String s1 = "https://www.google.com";
			String s2 = "https://www.github.com";
			String s3 = "https://www.youtube.com";

			InetAddress ip = InetAddress.getByName(new URL(s2).getHost());
			String hostname = ip.getHostName();
			System.out.println("current IP address : " + ip);
			System.out.println("current Hostname : " + hostname);
		} catch (UnknownHostException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
