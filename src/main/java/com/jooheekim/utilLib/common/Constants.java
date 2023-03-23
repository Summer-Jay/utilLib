package com.jooheekim.utilLib.common;

import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;


public class Constants {
public static Properties readCurrentServiceConfig=null;
	
	static {
		readCurrentServiceConfig=getCurrentProjectConfig();
	}
	
	public static Properties getCurrentProjectConfig() {
		Properties props = null;
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(new ClassPathResource("config/application.yml"));

		props = factory.getObject();
		System.out.println("props====>"+props);

		String activeProfile = CommonUtil.getString(props.get("spring.profiles.active"));
		System.out.println("activeProfile----->"+activeProfile);

		factory.setResources(new ClassPathResource("config/application-"+activeProfile+".yml"));
		props=factory.getObject();

		return props;
	}

	
	public static String getProperties(String key) {
		String value="";
		System.out.println("key=====>"+key);
		value= CommonUtil.getString(readCurrentServiceConfig.getProperty(key));
		System.out.println("value=====>"+value);
		return value;
	}

}
