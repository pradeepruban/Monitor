import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;


public class HttpBasicAuth {

    public static void main(String[] args) {

        try {
            URL url = new URL ("http://192.168.175.22:8010");

            Base64 b = new Base64();
            String encoding = b.encodeAsString(new String("test1:test1").getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
                new BufferedReader (new InputStreamReader (content));
            String line = in.readLine();
            while (line != null) {
            	System.out.println("Connected");
                //System.out.println(line);
            }
        } 
        catch(Exception e) {
        	System.out.println("Not connected");
            //e.printStackTrace();
        }
    }
}