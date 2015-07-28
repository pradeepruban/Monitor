package com.syntel.ping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;

public class URL_Tokens {

   public static void main (String[] args) throws IOException {
	   
     URL_Tokenizer url = new URL_Tokenizer ("http://192.168.175.16/nagios/ nagiosadmin scGct#3m");

    /* System.out.println ("Protocol: " + url.get_protocol());
     System.out.println ("Address: " + url.get_address());
     System.out.println ("Resourse: " + url.get_resource());*/
   }
   
   
}

class URL_Tokenizer {
   private String protocol;
   private String address;
   private String resource;

   public URL_Tokenizer (String URL_Text) throws IOException {

     StringTokenizer URL = new StringTokenizer (URL_Text, " ");
     protocol = URL.nextToken(" ");
     address = URL.nextToken();
     resource = URL.nextToken();
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
   }

  /* public String get_protocol () {
     return protocol;
   }

   public String get_address () {
     return address;
   }
  
   public String get_resource () {
     return resource;
   }*/
}