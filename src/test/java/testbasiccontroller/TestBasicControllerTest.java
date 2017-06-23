package testbasiccontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class TestBasicControllerTest {

	private RestTemplate testTemplate;
	
	@Test
	public void testFirstCall() {
		
	}
}
