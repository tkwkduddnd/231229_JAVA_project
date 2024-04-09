package new02;

import java.io.IOException;
import java.net.URL;

public class Network02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		URL url = new URL("http://www.naver.com");
		System.out.println(url.getContent());
		System.out.println(url.getAuthority());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getQuery());
	}

}
