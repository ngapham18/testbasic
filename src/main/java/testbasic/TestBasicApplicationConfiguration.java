/**
 * 
 */
package testbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author x3fm
 * this class use AutoConfiguration from Spring boot, 
 * this will allow the app run independent from container
 */
@SpringBootApplication(scanBasePackages="testbasic.")
@EnableJpaRepositories("testbasic.repository")
public class TestBasicApplicationConfiguration {

	public static void main (String[] args) {
			SpringApplication.run(TestBasicApplicationConfiguration.class, args);
	}
}
