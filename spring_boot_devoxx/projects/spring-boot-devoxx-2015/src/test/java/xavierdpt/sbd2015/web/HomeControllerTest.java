package xavierdpt.sbd2015.web;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xavierdpt.sbd2015.SpringBootDevoxx2015Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDevoxx2015Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void runAndInvokeHome() {
		String url = "http://localhost:" + port + "/";
		String body = new TestRestTemplate("user", "user").getForObject(url, String.class);
		Assert.assertThat(body, Is.is("Hello John"));
	}

}
