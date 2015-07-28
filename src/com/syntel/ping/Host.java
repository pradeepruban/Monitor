package com.syntel.ping;

import java.io.Serializable;

public class Host implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;
	
	private String status;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
