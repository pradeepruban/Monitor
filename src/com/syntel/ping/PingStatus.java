package com.syntel.ping;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties; 
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.io.*;
/**
* @author Crunchify.com
*
*/
 
public class PingStatus {
	
    public static void main(String args[]) throws Exception {
    	//readPropertyFile();
    	Properties prop = new Properties();
    	InputStream input = null;
    	String token1 = "";
    	String filename = "healthcheck.properties";
    	Enumeration<?> e = prop.propertyNames();
    	String key=null;
    	String value=null;
		while (e.hasMoreElements()) {
			 key = (String) e.nextElement();
			 value = prop.getProperty(key);
			System.out.println("Key : " + key + ", Value : " + value);
			 
			
		}
		
		Scanner inFile1 = new Scanner(new File("C:/Users/K5007843/Documents/workspace-sts-3.6.2.RELEASE/Monitor/src/healthcheck.properties"));
		List<String> temps = new LinkedList<String>();
		
		while (inFile1.hasNext()) {
		      // find next line
		      token1 = inFile1.next();
		      temps.add(token1);
		    }
		    inFile1.close();

		    String[] hostList = temps.toArray(new String[0]);
		 
 
        for (int i = 0; i < hostList.length; i++) {
 
            String url = hostList[i];
            String status = getStatus(url);
 
            System.out.println(url + "\t\tStatus:" + status);
        }
 
    }
 
    
  
    
    
    public static String getStatus(String url) throws IOException {
 
        String result = "";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
 
            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
    }
 
}
