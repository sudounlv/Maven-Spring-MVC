package com.richardhoppes.example.common;

import com.richardhoppes.example.exception.NotFoundException;

import java.util.Properties;

public class Settings {

	private Properties configProperties;

	private String getProperty(String property) throws NotFoundException {
		String retVal = configProperties.getProperty(property);
		if(retVal == null) {
			throw new NotFoundException("Property not found: " + property);
		}
		return retVal;
	}

	public String getMode() throws NotFoundException {
		return getProperty("mode");
	}

	public String getHttpClientSocketTimeoutMs() throws NotFoundException {
		return getProperty("http.client.socket.timeout.ms");
	}

	public String getZapposApiKey() throws NotFoundException {
		return getProperty("zappos.api.key");
	}

	public String getZapposApiProductUrl() throws NotFoundException {
		return getProperty("zappos.api.url.product");
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}
}
