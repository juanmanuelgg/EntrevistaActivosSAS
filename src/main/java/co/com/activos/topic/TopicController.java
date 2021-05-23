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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("")
	public List<Topic> index() {
		return topicService.findAll();
	}

	@GetMapping("/{id}")
	public Topic index(@PathVariable Long id) {
		return topicService.findById(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Topic create(@RequestBody Topic topic) {
		return topicService.save(topic);
	}

	@PutMapping("/{id}")
	public Topic update(@RequestBody Topic topic, @PathVariable Long id) {
		Topic actual = topicService.findById(id);

		actual.setSubchapter(topic.getSubchapter());
		actual.setText(topic.getText());

		return topicService.save(actual);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		topicService.delete(id);
	}

}