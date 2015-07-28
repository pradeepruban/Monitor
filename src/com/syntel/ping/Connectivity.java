package com.syntel.ping;

import java.io.*;  
import java.net.*;  
import java.util.*;  
import java.util.TimerTask;  

class Connectivity extends TimerTask  
{  
    public static void main(String args[])  
    {  
        try  
        {  
        	  String ip="";  
              TimerTask con  = new Connectivity();  
              int port=80;  
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
              
        }  
          
    }  
  
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
          
    }  
}  