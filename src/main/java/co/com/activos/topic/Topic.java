package co.com.activos.topic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long subchapter;
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSubchapter() {
		return subchapter;
	}

	public void setSubchapter(long subchapter) {
		this.subchapter = subchapter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}