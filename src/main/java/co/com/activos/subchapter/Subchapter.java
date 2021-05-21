package co.com.activos.subchapter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subchapter")
public class Subchapter {
	@Id
	private long id;
	private long chapter;
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getChapter() {
		return chapter;
	}

	public void setChapter(long chapter) {
		this.chapter = chapter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}