package xavierdpt.sbd2015.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xavierdpt.sbd2015.domain.Speaker;
import xavierdpt.sbd2015.domain.SpeakerRepository;

@RestController
public class HomeController {

	@Autowired
	private SpeakerRepository speakerRepository;

	@Value("${name:John}")
	private String name;

	@RequestMapping("/")
	public String home() {
		return "Hello " + name;
	}

	@RequestMapping("/createSpeaker")
	public Long createSpeaker(@RequestParam("name") String speakerName, @RequestParam("data") String speakerData) {
		Speaker speaker = speakerRepository.save(new Speaker(speakerName, speakerData));
		return speaker.getId();
	}
}
