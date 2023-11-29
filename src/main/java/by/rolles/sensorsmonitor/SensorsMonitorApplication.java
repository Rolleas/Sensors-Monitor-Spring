package by.rolles.sensorsmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SensorsMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorsMonitorApplication.class, args);
	}

}
