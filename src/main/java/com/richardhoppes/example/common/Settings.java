package com.richardhoppes.example.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class Settings {

	private Properties configProperties;

	public String getMode() {
		return configProperties.getProperty("mode");
	}

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}
}
