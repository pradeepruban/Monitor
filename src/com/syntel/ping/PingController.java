package com.syntel.ping;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PingController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getWorkflowDetails(HttpSession session) throws IOException{
		List<Host> pingList=new ArrayList<Host>();
		List<TelnetHost> telnetList=new ArrayList<TelnetHost>();
		
    	String token1 = "";
		Scanner inFile1 = new Scanner(new File("D:/Webservice/AjaxServlet/Monitor/src/healthcheck.properties"));
		List<String> temps = new LinkedList<String>();
		
		while (inFile1.hasNext()) {
		      token1 = inFile1.next();
		      temps.add(token1);
		    }
		    inFile1.close();
		    String[] hostList = temps.toArray(new String[0]);
		    
        for (int i = 0; i < hostList.length; i++) {
           Host host=new Host();
            String url = hostList[i];
            System.out.println("URL"+url);
            String status = getStatus(url);
            System.out.println(url + "\t\tStatus:" + status);
            host.setUrl(url);
            host.setStatus(status);
            pingList.add(host);
            
        }
        
        
        
            BufferedReader br = null;
    		String line;
    		br = new BufferedReader(new FileReader("D:/Webservice/AjaxServlet/Monitor/src/telnet.properties"));
     
    		while ((line = br.readLine()) != null) {
    		   StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
     
    		   while (stringTokenizer.hasMoreElements()) {
    			TelnetHost telnet=new TelnetHost();
    			String appName = stringTokenizer.nextElement().toString();
    		    String ipAdd = stringTokenizer.nextElement().toString();
    		    Integer port = Integer.parseInt(stringTokenizer.nextElement().toString().trim());
                String status=getTelnetStatus(ipAdd,port);
                telnet.setIpAddress(ipAdd);
                telnet.setPort(port);
                telnet.setStatus(status);
                telnet.setAppName(appName);
                telnetList.add(telnet);
    		   }
    		}
             br.close();
        session.setAttribute("telnetList", telnetList);
		session.setAttribute("pingList", pingList);
		return "listPingStatus";
	}
	
	
	
	public static String getTelnetStatus(String ip,int port) throws IOException {
        String status="";
        try  
        {  
         
            Socket s1=new Socket(ip,port);  
            InputStream is=s1.getInputStream();  
            DataInputStream dis=new DataInputStream(is);  
            if(dis!=null)  
            {  
                System.out.println("Connected with ip "+ip+" and port "+port); 
                status="green";
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
              
        }
		return status;  
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
