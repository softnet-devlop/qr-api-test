package com.softnet.qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class QrcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrcodeApplication.class, args);
	}

}
