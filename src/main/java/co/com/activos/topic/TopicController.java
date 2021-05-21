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