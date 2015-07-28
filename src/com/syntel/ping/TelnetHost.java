package com.syntel.ping;

import java.io.Serializable;

public class TelnetHost implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int port;
	private String ipAddress;
	private String status;
	private String appName;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
