package networking.examples;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {
	public static void main(String args[]) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				System.out.println("The URL is " + u);
				System.out.println("The scheme is " + u.getProtocol());
				System.out.println("The user info is " + u.getUserInfo());
				String host = u.getHost();
				if (host != null) {
					int atSign = host.indexOf('@');
					if (atSign != -1)
						host = host.substring(atSign + 1);
					System.out.println("The host is " + host);
				} else {
					System.out.println("The host is null.");
				}
				System.out.println("The port is " + u.getPort());
				System.out.println("The path is " + u.getPath());
				System.out.println("The ref is " + u.getRef());
				System.out.println("The query string is " + u.getQuery());
			} catch (MalformedURLException ex) {
				System.err.println(args[i] + " is not a URL I understand.");
			}
			System.out.println();
			
			/*% java URLSplitter \
			ftp://mp3:mp3@138.247.121.61:21000/c%3a/ \
			http://www.oreilly.com \
			http://www.ibiblio.org/nywc/compositions.phtml?category=Piano \
			http://admin@www.blackstar.com:8080/ \
			The URL is ftp://mp3:mp3@138.247.121.61:21000/c%3a/
			The scheme is ftp
			The user info is mp3:mp3
			The host is 138.247.121.61
			The port is 21000
			The path is /c%3a/
			The ref is null
			The query string is null*/
		}
	}
}
