/*
Copyright 2021 Juan Manuel González Garzón

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
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

	public Topic() {
	}

	public Topic(Topic topic) {
		this.subchapter = topic.getSubchapter();
		this.text = topic.getText();
	}

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