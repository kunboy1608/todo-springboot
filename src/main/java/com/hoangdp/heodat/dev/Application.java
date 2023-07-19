package com.hoangdp.heodat.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
		System.out.println(System.getProperty("os.name"));
		try {
            WindowBean someBean = context.getBean(WindowBean.class);
			if (someBean!= null){
            System.out.println("Somebean tồn tại!");
			}
        }catch (Exception e){
            System.out.println("Somebean không tồn tại");
        }
	}
}
