package br.edu.ifrn;

import br.edu.ifrn.devolvame.DevolvameApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevolvameApplication.class)
@WebAppConfiguration
public class DevolvameApplicationTests {

	@Test
	public void contextLoads() {
	}

}
