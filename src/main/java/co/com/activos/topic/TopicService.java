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