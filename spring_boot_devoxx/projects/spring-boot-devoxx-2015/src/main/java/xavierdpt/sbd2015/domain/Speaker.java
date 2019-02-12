package xavierdpt.sbd2015.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speaker implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String data;

	public Speaker() {
	}

	public Speaker(String name, String data) {
		this.name = name;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

}
