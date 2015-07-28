package com.syntel.ping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class ReadFile {
 
	public static void main(String[] args) {
 
	BufferedReader br = null;
 
	try {
 
		List<Host> pingList=new ArrayList<Host>();
		List<TelnetHost> telnetList=new ArrayList<TelnetHost>();
		String line;
    	String token1 = "";
    	br = new BufferedReader(new FileReader("D:/Webservice/AjaxServlet/Monitor/src/healthchecks.properties"));
		List<String> temps = new LinkedList<String>();
		
		while((line = br.readLine()) != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
			 while (stringTokenizer.hasMoreElements()) {
				    String URL = stringTokenizer.nextElement().toString().trim();
				    System.out.println("Details:-"+URL);
				   
				    temps.add(URL);
				   }
		    }
		  
		    String[] hostList = temps.toArray(new String[0]);
		    
        for (int i = 0; i < hostList.length; i++) {
           Host host=new Host();
            String url = hostList[i];
            String status = getStatus(url);
            System.out.println(url + "\t\tStatus:" + status);
            host.setUrl(url);
            host.setStatus(status);
            pingList.add(host);
            System.out.println("Done");
        }
        
        
		
		
 		
		
 
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)
				br.close();
 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
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
	                result = "green";
	            }
	            else{
	            	  result = "red";
	            }
	        } catch (Exception e) {
	            result = "red";
	        }
	        return result;
	    }
}
