package com.syntel.ping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;

public class JavaCertifiedClass {

	public static void main(String arg[]) throws IOException
	{
		BufferedReader br = null;
		List<Host> pingList=new ArrayList<Host>();
		String line;
    	String token1 = "";
    	br = new BufferedReader(new FileReader("D:/Webservice/AjaxServlet/Monitor/src/healthchecks.properties"));
    	line=br.readLine();
    	System.out.println("Line:-"+line);
		List<String> temps = new LinkedList<String>();
		while((line = br.readLine()) != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
			 while (stringTokenizer.hasMoreElements()) {
				 String protocol = stringTokenizer.nextToken(" ");
				 String address = stringTokenizer.nextToken();
				   String resource =stringTokenizer.nextToken();
				   System.out.println("URL"+protocol);
				   
				   // temps.add(stringTokenizer);
				   }
		}
		StringTokenizer URL = new StringTokenizer (line," ");
		 String protocol = URL.nextToken(" ");
		   String address = URL.nextToken();
		   String resource =URL.nextToken();
		   System.out.println("URL"+protocol);
		     System.out.println("UName"+address);
		     System.out.println("Password"+resource);
		     String authString = address + ":" + resource+"";
		     System.out.println("auth string: " + authString);
				byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
				String authStringEnc = new String(authEncBytes);
				System.out.println("Base64 encoded auth string: " + authStringEnc);
				URL url = new URL(protocol);
				URLConnection urlConnection = url.openConnection();
				urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
				InputStream is = urlConnection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
		            if(isr!=null)
		            {
		            	System.out.println("Connected");
		            }
		            else
		            {
		            	System.out.println("Not connected");
		            }
		   }
		
	}
	
	

