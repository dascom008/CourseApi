package io.javabrains.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseservice;

	@RequestMapping("topics/{id}/courses")
	public List<Course> getCourses(@PathVariable String id) {
		return courseservice.getAllCourses(id);
	}
	
	@RequestMapping("topics/{topicid}/course/{courseid}" )
	public Course getCourse(@PathVariable String id) {
		return courseservice.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"","") );
		courseservice.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value ="/topics/{topicid}/courses/{courseid}")
	public void putCourse(@RequestBody Course course, @PathVariable String topicid, @PathVariable String courseid) {
		course.setTopic(new Topic(topicid,"","") );
		courseservice.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value ="/topics/{id}/courses/{courseid}")
	public void deleteTopic(@PathVariable String id) {
		courseservice.deleteCourse(id);
	}
}
