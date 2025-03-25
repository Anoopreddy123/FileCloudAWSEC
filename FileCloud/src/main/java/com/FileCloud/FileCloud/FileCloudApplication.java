package com.FileCloud.FileCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EntityScan("com.FileCloud.FileCloud.entity")
@SpringBootApplication
public class FileCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileCloudApplication.class, args);
	}

}
