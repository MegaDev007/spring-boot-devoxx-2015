package xavierdpt.sbd2015.domain;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xavierdpt.sbd2015.SpringBootDevoxx2015Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDevoxx2015Application.class)
public class SpeakerRepositoryTest {

	@Autowired
	private SpeakerRepository repository;

	@Test
	public void testFindByName() {
		Speaker john = repository.save(new Speaker("John", "Hello !"));
		Assert.assertThat(repository.findByName("John").iterator().next().getId(), Is.is(john.getId()));
	}

}
