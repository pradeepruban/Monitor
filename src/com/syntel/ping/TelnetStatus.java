package com.syntel.ping;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TelnetStatus {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		String token1 = "";
		
		Scanner inFile1 = new Scanner(new File("C:/Users/K5007843/Documents/workspace-sts-3.6.2.RELEASE/Monitor/src/telnet.properties"));
		List<String> temps = new LinkedList<String>();
		
		while (inFile1.hasNext()) {
		      // find next line
			
			token1=inFile1.nextLine();
			System.out.println("full line"+token1);
			
			
		    temps.add(token1);
		    }
		    inFile1.close();

		    String[] hostList = temps.toArray(new String[0]);
		 
		    
		    for (int i = 0; i < hostList.length; i++) {
		    	 String ip="";
		    	 int port=80;
	            String url = hostList[i];
	            String status = getTelnetStatus(ip,port);
	 
	            System.out.println(url + "\t\tStatus:" + status);
	        }
		
	}
		    
		    
		    
		    
		    
		   
	private static String getTelnetStatus(String ip, int port) {
	
		String status="";
    	try{
    	
    	Socket s1=new Socket(ip,port);  
        InputStream is=s1.getInputStream();  
        DataInputStream dis=new DataInputStream(is);  
        if(dis!=null)  
        {  
            System.out.println("Connected with ip "+ip+" and port "+port);
        }  
        else  
        {  
            System.out.println("Connection invalid");
        }   
        dis.close();  
        s1.close();  
          
       }  
    catch(Exception e)  
    {  
        System.out.println("Not Connected,Please enter proper input");  
        return status;
    } 
		
		
		return null;
	}
	

}
