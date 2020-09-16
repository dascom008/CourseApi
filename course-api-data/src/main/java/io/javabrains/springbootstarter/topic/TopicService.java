package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("spring", " spring core", "spring desc"),
			new Topic("java", "core java", "java desc"), new Topic("hib", "hibernate", "hibernate desc")));
	
	public List<Topic> getAllTopic(){
		return (List<Topic>) topicRepository.findAll();
		//return topics;
	}

	public Topic getTopic(String id) {

		/*for (Topic t : topics) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;*/
		
		//return topicRepository.findById(id);
		
		Topic t = topicRepository.findById(id).get();
		return t;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {

		/*for(Topic t:topics) {
			if(t.getId().equals(id)) {
				t=topic;
			}
		}*/
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

	/*	for(Topic t:topics) {
			if(t.getId().equals(id)) {
				topics.remove(id);
			}
		}*/
			
		topicRepository.deleteById(id);
	}
}
