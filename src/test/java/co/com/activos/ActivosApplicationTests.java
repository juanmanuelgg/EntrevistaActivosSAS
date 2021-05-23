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
package co.com.activos;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.activos.topic.Topic;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class ActivosApplicationTests {

	private final static String SUBCHAPTER_CONTROLLER_ENDPOINT = "/api/subchapter";
	private final static String TOPIC_CONTROLLER_ENDPOINT = "/api/topic";

	private MockMvc mockMvc;
	private ObjectMapper objectMapper;
	
	public ActivosApplicationTests() {
		objectMapper = new ObjectMapper();
	}

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation)).build();
	}

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void getSubchapters() throws Exception {
		this.mockMvc.perform(get(SUBCHAPTER_CONTROLLER_ENDPOINT).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getTopics() throws Exception {
		this.mockMvc.perform(get(SUBCHAPTER_CONTROLLER_ENDPOINT).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getTopic() throws Exception {
	}

	@Test
	public void createTopic() throws Exception {
		int testSubchapter = 1;
		String testText = "Test topic";
		//long expectedId = 167L;

		Topic topic = new Topic();
		topic.setSubchapter(testSubchapter);
		topic.setText(testText);

		this.mockMvc
				.perform(post(TOPIC_CONTROLLER_ENDPOINT).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(topic)))
				//.andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(expectedId))
				.andExpect(jsonPath("$.subchapter").value(testSubchapter))
				.andExpect(jsonPath("$.text").value(testText));
	}

	@Test
	public void updateTopic() throws Exception {
	}

	@Test
	public void deleteTopic() throws Exception {
	}
}