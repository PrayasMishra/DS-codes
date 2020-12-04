package networking;
import java.net.*;

public class TestUrl {
	public static void main(String[] args) {
		try{
			URL url = new URL("https://www.youtube.com");
			System.out.println("protocol - "+url.getProtocol());
			System.out.println("port - "+url.getPort());
			System.out.println("host - "+url.getHost());
			System.out.println("uri - "+url.toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
