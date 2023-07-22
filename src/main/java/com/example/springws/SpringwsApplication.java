package com.example.springws;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.security.*;

@SpringBootApplication(scanBasePackages = {"stubs", "com.example.springws"})
@EntityScan(basePackages = {"stubs"})
public class SpringwsApplication {
	@Value("${server.port}") String propertyServerPort;
	private Logger logger = LoggerFactory.getLogger(SpringwsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringwsApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
			keyPairGen.initialize(2048);
			KeyPair pair = keyPairGen.generateKeyPair();
			PrivateKey privKey = pair.getPrivate();
			Signature sign = Signature.getInstance("SHA256withDSA");
			sign.initSign(privKey);
			byte[] bytes = "Hello how are you".getBytes();
			sign.update(bytes);
			byte[] signature = sign.sign();
			logger.info("Signature: " + new String(signature));

			logger.info("propertyServerPort: " + propertyServerPort);
		};
	}

}
