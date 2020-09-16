package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courserepository;
	
	/*private List<Course> topics = new ArrayList<Course>(Arrays.asList(new Course("spring", " spring core", "spring desc"),
			new Course("java", "core java", "java desc"), new Course("hib", "hibernate", "hibernate desc")));*/
	
	public List<Course> getAllCourses(String topicId){
		
		return (List<Course>) courserepository.findByTopicId(topicId);
		//return topics;
	}

	public Course getCourse(String id) {

/*		for (Course t : topics) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
*/	
		Course course = courserepository.findById(id).get();
		return course;	
	
	}

	public void addCourse(Course course) {
		courserepository.save(course);
	}

	public void updateCourse(Course course) {

		/*for(Topic t:topics) {
			if(t.getId().equals(id)) {
				t=topic;
			}
		}*/
		courserepository.save(course);
	}

	public void deleteCourse(String id) {

	/*	for(Topic t:topics) {
			if(t.getId().equals(id)) {
				topics.remove(id);
			}
		}*/
			
		courserepository.deleteById(id);
	}

}
