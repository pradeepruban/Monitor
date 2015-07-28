import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;

public class SSLJavaConnection {

	public static void main(String[] args) {

		try {
			String webPage = "http://192.168.175.16/nagios/";
			String name = "nagiosadmin";
			String password = "scGct#3m";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
                if(isr!=null)
                {
                	System.out.println("Connected");
                }
              
			
		} catch (MalformedURLException e) {
			System.out.println("Not connected");
			
		} catch (IOException e) {
			System.out.println("Not connected");
			
		}
	}

}