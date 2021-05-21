package co.com.activos.topic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private ITopicRepository topicRepository;

	@Transactional
	public List<Topic> findAll() {
		return (List<Topic>) topicRepository.findAll();
	}

	@Transactional
	public Topic findById(Long id) {
		return topicRepository.findById(id).orElse(null);
	}

	@Transactional
	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}

	@Transactional
	public void delete(Long id) {
		topicRepository.deleteById(id);
	}
}