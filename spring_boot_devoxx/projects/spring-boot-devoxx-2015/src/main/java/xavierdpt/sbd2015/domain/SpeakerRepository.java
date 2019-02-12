package xavierdpt.sbd2015.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

	@RestResource(path = "byName")
	Collection<Speaker> findByName(@Param("name") String name);

}
